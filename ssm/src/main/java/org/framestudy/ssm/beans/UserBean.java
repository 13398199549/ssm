package org.framestudy.ssm.beans;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable{

	private String id;
	private String userName;
	private String password;
	private String loginName;
	private Integer age;
	private Date createTime;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", userName=" + userName + ", password=" + password + ", loginName=" + loginName
				+ ", age=" + age + ", createTime=" + createTime + "]";
	}
}
