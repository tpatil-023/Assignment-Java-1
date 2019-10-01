package com.assign.vo;

import java.util.List;

public class ProjectsVO {

	private List<GitlabVO> gitLab;
	private List<GitHubVO> gitHub;
	
	public List<GitlabVO> getGitLab() {
		return gitLab;
	}
	
	public void setGitLab(List<GitlabVO> gitLab) {
		this.gitLab = gitLab;
	}
	public List<GitHubVO> getGitHub() {
		return gitHub;
	}
	public void setGitHub(List<GitHubVO> gitHub) {
		this.gitHub = gitHub;
	}
}


