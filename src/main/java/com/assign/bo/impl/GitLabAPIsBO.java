package com.assign.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.assign.common.CommonUtils;
import com.assign.common.HttpClient;
import com.assign.vo.GitHubVO;
import com.assign.vo.GitlabVO;
import com.assign.vo.UserVO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GitLabAPIsBO extends Platform{

	private static final Logger LOGGER = Logger.getLogger(GitLabAPIsBO.class);

	public List<GitlabVO> getGitLabUserProjects(String searchUserId, String token, String searchUserName, boolean owned){
		try{
			String api = "/users/"+searchUserId+"/projects";
			String params = "?access_token="+token;
			if(owned){
				params += "&owned=true";		
			}
			List<GitlabVO> labVos = new ArrayList<GitlabVO>();
			String response = HttpClient.GET(api, params);
			if(!response.isEmpty()){
				JSONArray jsonArr;
				jsonArr = new JSONArray(response);
				for (int i = 0; i < jsonArr.length(); i++)
		        {
		            JSONObject jsonObj = jsonArr.getJSONObject(i);
		            GitlabVO gitlabVO = new GitlabVO();
		            gitlabVO.setProjectId(jsonObj.get("id").toString());
		            gitlabVO.setProjectName(jsonObj.get("name").toString());
		            gitlabVO.setVisibility(jsonObj.get("visibility").toString());
		            gitlabVO.setWebUrl(jsonObj.get("web_url").toString());
		            gitlabVO.setGitLabUser(searchUserName);
		            labVos.add(gitlabVO);
		        }
				return labVos;
			}	
		}catch(JSONException j) {
			LOGGER.error("getGitLabUserProjects() : JSONException");
			j.printStackTrace();
		}catch(Exception e) {
			LOGGER.error("getGitLabUserProjects() : Exception");
			e.printStackTrace();
			throw e;
		}
		return null;
	}
	
	public String getGitLabUser(String searchUser,String token) {
		try{
			String params = searchUser +"&access_token="+token; 
			String response = HttpClient.GET(CommonUtils.GITLAB_GET_USER, params);
			if(!response.isEmpty()){
				JSONArray jsonArr;
					jsonArr = new JSONArray(response);
					return jsonArr.getJSONObject(0).get("id").toString();
			}	
		}catch(JSONException j) {
			LOGGER.error("getGitLabUser() : JSONException");
			j.printStackTrace();
		}catch(Exception e) {
			LOGGER.error("getGitLabUser() : Exception");
			e.printStackTrace();
			throw e;
		}
		return null;
	}
	
	public String getGitLabAccessToken(String userName, String password, String grantType) {
		try{
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("grant_type", grantType));
			urlParameters.add(new BasicNameValuePair("username", userName));
			urlParameters.add(new BasicNameValuePair("password", password));
			String response = HttpClient.POST(CommonUtils.GITLAB_OAUTH, urlParameters);
			if(!response.isEmpty()){
				JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();	
				return jsonObject.get("access_token").getAsString();
			}
		}catch (Exception e) {
			LOGGER.error("getGitLabAccessToken() : Exception");
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	List<GitHubVO> getGitHub(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
