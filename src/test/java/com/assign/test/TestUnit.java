package com.assign.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assign.bo.IUserBO;
import com.assign.vo.ProjectsVO;
import com.assign.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/business-beans.xml"})
public class TestUnit  {
	
	@Autowired
	IUserBO userBO;
	
	private static final Logger LOGGER = Logger.getLogger(TestUnit.class);
 
  @Test
   public void testStoreData() {
	  UserVO userVo = new UserVO();
	  userVo.setGitLabUser("username");
	  userVo.setGitLabpassword("password");
	  userVo.setGrantType("password");
	  userVo.setSearchLabUser("email");
	  userVo.setOwned(true);
	  userVo.setSearchHubUser("username");
	  ProjectsVO projectsVO = userBO.processPlatforms(userVo);
	  assertNotNull(projectsVO);
  }
}