package com.lok.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lok.utils.CookieTools;

/**
 * @Description 测试cookie工具类
 */

@RestController
@RequestMapping("testCookie")
public class TestCookieController {
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String testMethod(HttpServletRequest request, HttpServletResponse response) {
		// 设置cookie值 （带特殊字符时tomcat会默认加上双引号，-1代表随session销毁）
		CookieTools.addCookie(request, response, "testCookie", "test+%@3", -1);
		return "success";
	}
}
