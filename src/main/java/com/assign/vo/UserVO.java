package com.assign.vo;

public class UserVO {

	private String gitLabUser;
	private String grantType;
	private String gitLabpassword;
	private String searchLabUser;
	private String searchHubUser;
	private boolean owned;
	
	public boolean isOwned() {
		return owned;
	}
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	public String getSearchHubUser() {
		return searchHubUser;
	}
	public void setSearchHubUser(String searchHubUser) {
		this.searchHubUser = searchHubUser;
	}
	public String getGrantType() {
		return grantType;
	}
	public String getGitLabUser() {
		return gitLabUser;
	}
	public void setGitLabUser(String gitLabUser) {
		this.gitLabUser = gitLabUser;
	}
	public String getGitLabpassword() {
		return gitLabpassword;
	}
	public void setGitLabpassword(String gitLabpassword) {
		this.gitLabpassword = gitLabpassword;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getSearchLabUser() {
		return searchLabUser;
	}
	public void setSearchLabUser(String searchLabUser) {
		this.searchLabUser = searchLabUser;
	}
}


