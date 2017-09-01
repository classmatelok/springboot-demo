package com.lok.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 
 */

@RestController
@RequestMapping("user")
public class UserController {
	
	@RequestMapping(value="/select",method=RequestMethod.GET)
	public String testMethod() {
		return "success";
	}
}
