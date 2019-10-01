package com.assign.vo;

public class GitlabVO {

	private String projectId;
	private String projectName;
	private String visibility;
	private String webUrl;
	private String gitLabUser;
	
	
	public String getGitLabUser() {
		return gitLabUser;
	}
	public void setGitLabUser(String gitLabUser) {
		this.gitLabUser = gitLabUser;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
}


