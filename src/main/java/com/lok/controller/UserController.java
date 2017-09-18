package com.lok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lok.domain.User;
import com.lok.domain.util.ResponseData;
import com.lok.service.UserService;

/**
 * @Description 
 */

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseData testMethod() {
		ResponseData rd = new ResponseData();
		List<User> users = userService.findUser();
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
}
