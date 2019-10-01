package com.assign.bo;

import java.util.List;

import com.assign.vo.GitlabVO;


public interface IGitLabAPIsBO {
	
	List<GitlabVO> getGitLabUserProjects(String searchUserId, String token);
	
	String getGitLabUser(String searchUser,String token);
	
	String getGitLabAccessToken(String userName, String password, String grantType);
	
}
