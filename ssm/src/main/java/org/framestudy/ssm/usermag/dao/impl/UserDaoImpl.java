package org.framestudy.ssm.usermag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.ssm.beans.Pager;
import org.framestudy.ssm.beans.UserBean;
import org.framestudy.ssm.usermag.dao.IUserDao;
import org.framestudy.ssm.usermag.mapper.UserMapper;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements IUserDao {

	@Resource
	private UserMapper userMapper;
	
	public int saveUserBean(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.saveUserBean(user);
	}

	public int updateUserBean(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateUserBean(user);
	}

	public int deleteUserBean(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteUserBean(user);
	}

	public UserBean getUserBeanById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserBeanById(id);
	}

	public List<UserBean> findUserListByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findUserListByUserName(userName);
	}

	public Pager findUserList2PagerByMap(Map params) throws Exception {
		// TODO Auto-generated method stub
		int total = userMapper.countUserList2PagerByMap(params);
		List<UserBean> rows = userMapper.findUserList2PagerByMap(params);
		return new Pager(total, rows);
	}

	public int deleteUserBeanById(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteUserBeanById(id);
	}

	public int deleteUserBeanByIds(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteUserBeanByIds(ids);
	}

}
