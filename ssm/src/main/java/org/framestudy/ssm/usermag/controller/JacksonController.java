package org.framestudy.ssm.usermag.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.ssm.beans.Pager;
import org.framestudy.ssm.beans.UserBean;
import org.framestudy.ssm.pojos.Messager;
import org.framestudy.ssm.usermag.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/jsons")
@RestController // ===@Controller + @ResponseBody
public class JacksonController {

	@Resource
	private IUserService userServiceImpl;

	@RequestMapping(value = "/seven", produces = { "application/json;charset=utf-8" })
	public Map seven(String userName) {
		Map map = new HashMap();
		map.put("status", true);
		map.put("info", "操作成功！");
		try {
			System.out.println(userName);

		} catch (Exception e) {
			// TODO: handle exception
			map.put("status", false);
			map.put("info", "系统繁忙，请稍后重试！");
		}
		return map;
	}

	@RequestMapping(value = "/six", produces = { "application/json;charset=utf-8" })
	public Pager five(UserBean user, int page, int rows) {
		Pager pager = null;

		try {

			Map params = new HashMap();
			int index = (page - 1) * rows;
			params.put("index", index);
			params.put("rows", rows);
			params.put("userName", user.getUserName());
			params.put("age", user.getAge());
			pager = userServiceImpl.findUserList2PagerByMap(params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pager;
	}

	/**
	 * 根据用户名查询大批量用户
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/five", produces = { "application/json;charset=utf-8" })
	public List<UserBean> five(String userName) {
		List<UserBean> users = null;
		try {
			users = userServiceImpl.findUserListByUserName(userName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/four", produces = { "application/json;charset=utf-8" })
	public Messager four(@RequestBody String[] ids) {
		Messager msg = new Messager(true, "操作成功！");
		try {

			System.out.println(Arrays.toString(ids));
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试！");
		}
		return msg;
	}

	/**
	 * 单个字符串接收
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/three", produces = { "application/json;charset=utf-8" })
	public Messager three(String id) {
		Messager msg = new Messager(true, "操作成功！");
		try {

			System.out.println(id);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试！");
		}
		return msg;
	}

	/**
	 * 批量的新增或删除
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/two", produces = { "application/json;charset=utf-8" })
	public Messager two(@RequestBody List<UserBean> users) {
		Messager msg = new Messager(true, "操作成功！");
		try {

			System.out.println(users);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试！");
		}
		return msg;
	}

	/**
	 * 单个新增或修改或删除
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/one", produces = { "application/json;charset=utf-8" })
	public Messager one(@RequestBody UserBean user) {
		Messager msg = new Messager(true, "操作成功！");
		try {
			user.setCreateTime(new Date());
			System.out.println(user);

		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInfo("系统繁忙，请稍后重试！");
		}
		return msg;
	}

}
