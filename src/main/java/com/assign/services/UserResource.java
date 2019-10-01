package com.assign.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assign.bo.IUserBO;
import com.assign.vo.ProjectsVO;
import com.assign.vo.UserVO;


@Controller
public class UserResource {
	
	private static final String COMMON_SERVICE_PATH = "/rest/user/";
	
	@Autowired
	private IUserBO userBO;
	
	@RequestMapping(value = COMMON_SERVICE_PATH + "searchRepos", method = RequestMethod.POST)
	public @ResponseBody
	ProjectsVO register(@RequestBody UserVO userVO){
		ProjectsVO projectsVO = this.userBO.processPlatforms(userVO);
		return projectsVO;
	}	
}
