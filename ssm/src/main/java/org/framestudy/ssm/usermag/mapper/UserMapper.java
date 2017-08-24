package org.framestudy.ssm.usermag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.framestudy.ssm.beans.UserBean;

public interface UserMapper {
	
	@Insert("insert into t_user (id,user_name,pwd,login_name,age,create_time) values (#{user.id},#{user.userName},#{user.password},#{user.loginName},#{user.age},#{user.createTime})")
	public int saveUserBean(@Param("user")UserBean user) throws Exception;
	/**
	 * 最好使用配制文件,编写动态SQL (set---if)
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Update("update t_user set user_name = #{user.userName},pwd=#{user.password},login_name=#{user.loginName},age=#{user.age},create_time=#{user.createTime} where id = #{user.id}")
	public int updateUserBean(@Param("user")UserBean user) throws Exception;
	
	@Delete("delete from t_user where id = #{user.id}")
	public int deleteUserBean(@Param("user")UserBean user) throws Exception;
	
	@Delete("delete from t_user where id = #{id}")
	public int deleteUserBeanById(@Param("id")String id) throws Exception;
	
	public int deleteUserBeanByIds(@Param("ids")String[] id) throws Exception;

	@ResultType(UserBean.class)
	@Select("select id as id,user_name as userName,login_name as loginName,pwd as password,age as age,create_time as createTime from t_user where id = #{id}")
	public UserBean getUserBeanById(@Param("id")String id) throws Exception;

	@ResultType(UserBean.class)
	@Select("select id as id,user_name as userName,login_name as loginName,pwd as password,age as age,create_time as createTime from t_user where user_name like CONCAT(#{userName},'%') order by create_time desc")
	public List<UserBean> findUserListByUserName(@Param("userName")String userName) throws Exception;
	
	public int countUserList2PagerByMap(@Param("params")Map params) throws Exception;
	
	public List<UserBean> findUserList2PagerByMap(@Param("params")Map params) throws Exception;

}
