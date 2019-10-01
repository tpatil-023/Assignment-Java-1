package com.assign.bo.impl;

import java.util.List;

import com.assign.vo.GitHubVO;
import com.assign.vo.GitlabVO;
import com.assign.vo.UserVO;

abstract class Platform {
	abstract List<GitlabVO> getGitLabUserProjects(String searchUserId, String token, String searchUserName,boolean owned);
	
	abstract String getGitLabUser(String searchUser,String token);
	
	abstract String getGitLabAccessToken(String userName, String password, String grantType);
	
	abstract List<GitHubVO> getGitHub(UserVO userVO);
}
