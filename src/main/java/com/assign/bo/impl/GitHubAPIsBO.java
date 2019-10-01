package com.assign.bo.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

import com.assign.vo.GitHubVO;
import com.assign.vo.GitlabVO;
import com.assign.vo.UserVO;

public class GitHubAPIsBO extends Platform{
	private static final Logger LOGGER = Logger.getLogger(GitHubAPIsBO.class);

	public List<GitHubVO> getGitHub(UserVO userVO){
		try {
			List<GitHubVO> gitHubVOs = null;
			RepositoryService service = new RepositoryService();
			List<Repository> repos = service.getRepositories(userVO.getSearchHubUser());
			if(repos.size() > 0) {
				gitHubVOs = new ArrayList<GitHubVO>();
				for (Repository repository : repos) {
					GitHubVO gitVo = new GitHubVO();
					gitVo.setProjectId(String.valueOf(repository.getId()));
					gitVo.setProjectName(repository.getName());
					gitVo.setVisibility("Public");
					gitVo.setWebUrl(repository.getHtmlUrl());
					gitVo.setGitHubUser(userVO.getSearchHubUser());
					gitHubVOs.add(gitVo);
				}
			}
			return gitHubVOs;
		} catch (IOException e) {
			LOGGER.error("getGitHub() IOException"); 
			e.printStackTrace();
		}catch (Exception e) {
			LOGGER.error("getGitHub() Exception"); 
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public String getGitLabUser(String searchUser, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGitLabAccessToken(String userName, String password,
			String grantType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<GitlabVO> getGitLabUserProjects(String searchUserId, String token,
			String searchUserName, boolean owned) {
		// TODO Auto-generated method stub
		return null;
	}

}
