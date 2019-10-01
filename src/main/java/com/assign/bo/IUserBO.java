package com.assign.bo;

import com.assign.vo.ProjectsVO;
import com.assign.vo.UserVO;


public interface IUserBO {
	
	ProjectsVO processPlatforms(UserVO userVo);
}
