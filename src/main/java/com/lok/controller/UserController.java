package com.lok.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lok.domain.User;
import com.lok.domain.util.ResponseData;
import com.lok.service.UserService;

/**
 * @Description 
 */

@RestController
@RequestMapping("/user")//访问路径为：http://localhost:8080/user
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseData listUser() {
		ResponseData rd = new ResponseData();
		List<User> users = this.userService.listUser();
		if(users!=null&&users.size()>0) {
			rd.setStatus(1);
			rd.setMessage("查询成功！");
			rd.setData(users);
		}else {
			rd.setStatus(0);
			rd.setMessage("查询失败！");
		}
		return rd;
	}
	
	/**
	 * 根据id查询用户
	 * @return
	 */
	@RequestMapping(value="/find",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseData findUser(Integer id) {
		ResponseData rd = new ResponseData();
		User user = this.userService.findUser(id);
		if(user!=null) {
			rd.setStatus(1);
			rd.setMessage("查询成功！");
			rd.setData(user);
		}else {
			rd.setStatus(0);
			rd.setMessage("查询失败！");
		}
		return rd;
	}
	
	/**
	 * 添加或修改
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)//指定响应内容为json,utf-8格式
	@ResponseStatus
	public ResponseData addOrUpdateUser(@RequestBody User user) {
		ResponseData rd = new ResponseData();
		try {
			user = this.userService.addOrUpdateUser(user);
			rd.setStatus(1);
			rd.setMessage("添加或修改成功！");
			rd.setData(user);
			
		} catch (Exception e) {
			logger.info("添加或修改失败！User="+user);
			rd.setStatus(0);
			rd.setMessage("添加或修改失败！");
		}
		return rd;
	}
	
	/**
	 * 删除
	 * @return 
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseStatus
	public ResponseData deleteUser(@RequestParam("ids") List<Integer> ids) {
		ResponseData rd = new ResponseData();
		try {
			this.userService.deleteUser(ids);
			rd.setStatus(1);
			rd.setMessage("删除成功！");
			
		} catch (Exception e) {
			logger.info("删除失败,ids="+ids);
			rd.setStatus(0);
			rd.setMessage("删除失败！");
		}
		return rd;
	}
}
