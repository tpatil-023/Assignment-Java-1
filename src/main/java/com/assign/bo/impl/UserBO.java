package com.assign.bo.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.assign.bo.IUserBO;
import com.assign.vo.GitHubVO;
import com.assign.vo.GitlabVO;
import com.assign.vo.ProjectsVO;
import com.assign.vo.UserVO;

@Service
public class UserBO implements IUserBO {

	private static final Logger LOGGER = Logger.getLogger(UserBO.class);

	@Override
	public ProjectsVO processPlatforms(UserVO userVo) {
		List<GitlabVO> labVos = handleGitLab(userVo);
		List<GitHubVO> hubVos = handleGitHub(userVo);
		ProjectsVO projectsVO = new ProjectsVO();
		projectsVO.setGitLab(labVos);
		projectsVO.setGitHub(hubVos);
		return projectsVO;
	}
	
	private List<GitHubVO> handleGitHub(UserVO userVO) {
		try{
			HubFactory hubFactory = new HubFactory();  
			Platform platform = hubFactory.getPlatForm("GITHUB");
			return platform.getGitHub(userVO);	
		}catch(Exception e){
			LOGGER.error("handleGitHub() Exception");
			e.printStackTrace();
			throw e;
		}
	}

	private List<GitlabVO> handleGitLab(UserVO userVo){
		try{
			String token = null;
			String searchUserId = null;
			List<GitlabVO> labVos = null;
			
			HubFactory hubFactory = new HubFactory();  
			Platform platform = hubFactory.getPlatForm("GITLAB");
			if(!userVo.getGitLabUser().isEmpty()) {
				token = platform.getGitLabAccessToken(userVo.getGitLabUser(), userVo.getGitLabpassword(), userVo.getGrantType());
			}
			if(!token.isEmpty()){
				searchUserId =  platform.getGitLabUser(userVo.getSearchLabUser(), token);
			}
			if(!searchUserId.isEmpty()) {
				labVos = platform.getGitLabUserProjects(searchUserId, token, userVo.getSearchLabUser(),userVo.isOwned());
			}
			if(labVos.size() > 0){
				return labVos;
			}			
		}catch(Exception e){
			LOGGER.error("handleGitLab() Exception");
			e.printStackTrace();
			throw e;
		}
		return null;
	}
}
