package com.assign.vo;

public class GitHubVO {

	private String projectId;
	private String projectName;
	private String visibility;
	private String webUrl;
	private String gitHubUser;
	
	public String getGitHubUser() {
		return gitHubUser;
	}
	public void setGitHubUser(String gitHubUser) {
		this.gitHubUser = gitHubUser;
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


