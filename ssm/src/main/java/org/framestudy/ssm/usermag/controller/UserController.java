package org.framestudy.ssm.usermag.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.framestudy.ssm.beans.Pager;
import org.framestudy.ssm.beans.UserBean;
import org.framestudy.ssm.pojos.DataBox;
import org.framestudy.ssm.pojos.Messager;
import org.framestudy.ssm.usermag.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {
	
	//当前类，需要使用log4j日志框架来完成日志记录
	private Logger log = Logger.getLogger(this.getClass());	
	
	@Resource
	private IUserService userServiceImpl;
	
	@RequestMapping(value="/gender",method=RequestMethod.GET, produces = { "application/json;charset=utf-8" })
	public List<DataBox> getGenderBox(){
		List<DataBox> datas = new ArrayList<DataBox>();
		
		DataBox data01 = new DataBox("1","男");
		DataBox data02 = new DataBox("0","女");
		DataBox data03 = new DataBox("-1","不男不女");
		
		datas.add(data01);
		datas.add(data02);
		datas.add(data03);
		
		return datas;
	}
	
	
	
	/**
	 * 分页查询用户
	 * @param user 查询参数
	 * @param page 当前页码
	 * @param rows 每页的行数
	 * @return
	 */
	@RequestMapping(value="/page",method=RequestMethod.GET,produces = { "application/json;charset=utf-8" })
	public Pager findUserList2Pager(UserBean user,int page,int rows) {
		log.info(user);
		log.info(page);
		log.info(rows);
		Pager pager = null;
		try {
			Map params = new HashMap();
			int index = (page - 1)*rows;
			params.put("index", index);
			params.put("rows", rows);
			params.put("userName", user.getUserName());
			params.put("age", user.getAge());
			pager = userServiceImpl.findUserList2PagerByMap(params);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
		}
		return pager;
	}
	
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public Messager saveUserBean(@RequestBody UserBean user) {
		log.info(user);
		Messager msg = new Messager(true,"操作成功！");
		try {
			user.setId(UUID.randomUUID().toString());
			user.setCreateTime(new Date());
			userServiceImpl.saveUserBean(user);
		} catch (Exception e) {
			log.error(e);
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试");
		}
		log.info(msg);
		return msg;
	}
	/**
	 * 修改用户
	 * @param user
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT, produces = { "application/json;charset=utf-8" })
	public Messager updateUserBean(@RequestBody UserBean user,@PathVariable("id") String id) {
		log.info(user);
		log.info(id);
		
		Messager msg = new Messager(true,"操作成功！");
		try {
			user.setId(id);
			user.setCreateTime(new Date());
			userServiceImpl.updateUserBean(user);
		} catch (Exception e) {
			log.error(e);
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试");
		}
		log.info(msg);
		return msg;
	}
	
	/**
	 * 根据ID批量删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{ids}",method=RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public Messager deleteUserBean(@RequestBody String[] ids) {
		log.info(ids);
		Messager msg = new Messager(true,"操作成功！");
		try {
			userServiceImpl.deleteUserBeanByIds(ids);
		} catch (Exception e) {
			log.error(e);
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试");
		}
		log.info(msg);
		return msg;
	}
	
	
	
	/**
	 * 根据ID删除用户
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE, produces = { "application/json;charset=utf-8" })
	public Messager deleteUserBean(@PathVariable("id") String id) {
		log.info(id);
		Messager msg = new Messager(true,"操作成功！");
		try {
			userServiceImpl.deleteUserBeanById(id);
		} catch (Exception e) {
			log.error(e);
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试");
		}
		log.info(msg);
		return msg;
	}*/
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET, produces = { "application/json;charset=utf-8" })
	public UserBean getUserBeanById(@PathVariable("id") String id) {
		log.info(id);
		UserBean user = null;
		try {
			user = userServiceImpl.getUserBeanById(id);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
		}
		return user;
	}
}
