package org.framestudy.ssm.usermag.dao;

import java.util.List;
import java.util.Map;

import org.framestudy.ssm.beans.Pager;
import org.framestudy.ssm.beans.UserBean;

public interface IUserDao {
	
	public int saveUserBean(UserBean user) throws Exception;
	
	public int updateUserBean(UserBean user) throws Exception;

	public int deleteUserBean(UserBean user) throws Exception;

	public int deleteUserBeanById(String id) throws Exception;
	
	public int deleteUserBeanByIds(String[] id) throws Exception;
	
	public UserBean getUserBeanById(String id) throws Exception;

	public List<UserBean> findUserListByUserName(String userName) throws Exception;
	
	public Pager findUserList2PagerByMap(Map params) throws Exception;
}
