package com.assign.bo.impl;

public class HubFactory {
    
	public Platform getPlatForm(String platFormName){  
	    if(platFormName == null){  
	     return null;  
	    }  
	    if(platFormName.equalsIgnoreCase("GITLAB")) {  
	             return new GitLabAPIsBO();  
	    }   
       else if(platFormName.equalsIgnoreCase("GITHUB")){  
            return new GitHubAPIsBO();  
        }   
      return null;  
    }
}
