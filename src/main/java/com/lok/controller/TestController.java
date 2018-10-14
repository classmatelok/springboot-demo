package com.lok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lok.service.TestService;

/**
 * 此controller为了测试一些接口
 * @author lok
 */
@RestController
@RequestMapping("/test")//访问路径为http://localhost:8080/test
public class TestController {
	
	@Autowired
	private TestService testService;
	
	//@GetMapping//spring4.3才出
	@RequestMapping(value="async",method=RequestMethod.GET)
	public void testAsync() {
		testService.testAsync();
	}
}
