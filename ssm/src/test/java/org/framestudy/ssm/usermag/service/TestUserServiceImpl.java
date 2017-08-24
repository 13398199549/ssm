package org.framestudy.ssm.usermag.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.framestudy.ssm.beans.Pager;
import org.framestudy.ssm.beans.UserBean;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-context.xml"})
public class TestUserServiceImpl {

	@Resource
	private IUserService userServiceImpl;
	
	
	@Test
	public void testFindUserList2PagerByMap() {
		Map params = new HashMap();
		int index = 0;//(page-1)*rows
		params.put("index", index);
		params.put("rows", 8);
		params.put("userName", "小");
		params.put("age", 19);
		
		try {
			Pager pager = userServiceImpl.findUserList2PagerByMap(params);
			
			System.out.println(pager);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
	}
	
	
	
	
	
	@Ignore
	public void testFindUserListByUserName() {
		try {
			List<UserBean> users = userServiceImpl.findUserListByUserName("小");
			System.out.println(users);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Ignore
	public void testUpdateUserBean() {
		try {
			UserBean user = userServiceImpl.getUserBeanById("4");
			Assert.assertNotNull(user);
			user.setAge(17);
			user.setPassword("654321");
			user.setCreateTime(new Date());
			int rows = userServiceImpl.updateUserBean(user);
			Assert.assertEquals(1, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Ignore
	public void testSaveUserBean() {
		UserBean user = new UserBean();
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		user.setId(id);
		user.setLoginName("e");
		user.setUserName("小王八");
		user.setPassword("123456");
		user.setAge(19);
		user.setCreateTime(new Date());
		
		
		try {
			int rows = userServiceImpl.saveUserBean(user);
			
			Assert.assertEquals(1, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
