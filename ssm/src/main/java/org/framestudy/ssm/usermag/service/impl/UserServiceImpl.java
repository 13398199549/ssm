package org.framestudy.ssm.usermag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.ssm.beans.Pager;
import org.framestudy.ssm.beans.UserBean;
import org.framestudy.ssm.usermag.dao.IUserDao;
import org.framestudy.ssm.usermag.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDaoImpl;
	
	
	public int saveUserBean(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.saveUserBean(user);
	}

	public int updateUserBean(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.updateUserBean(user);
	}

	public int deleteUserBean(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.deleteUserBean(user);
	}

	public UserBean getUserBeanById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserBeanById(id);
	}

	public List<UserBean> findUserListByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.findUserListByUserName(userName);
	}

	public Pager findUserList2PagerByMap(Map params) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.findUserList2PagerByMap(params);
	}

	public int deleteUserBeanById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.deleteUserBeanById(id);
	}

	public int deleteUserBeanByIds(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		return userDaoImpl.deleteUserBeanByIds(ids);
	}

}
