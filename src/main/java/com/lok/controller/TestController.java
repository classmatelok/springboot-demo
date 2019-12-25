package com.lok.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lok.domain.JsonDemo;
import com.lok.service.TestService;
import com.lok.utils.CookieTools;
import com.lok.utils.JedisPoolTools;

import redis.clients.jedis.Jedis;

/**
 * 此controller为了测试一些接口
 * @author lok
 */
@RestController
@RequestMapping("/test")// -> 访问路径为http://localhost:8080/test
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Resource
	private List<JsonDemo> students;
	
	@GetMapping("/json")
	public List<JsonDemo> testGetJsonFileContent() {
		return students;
	}
	
	/**
	 * 测试springboot异步调用功能
	 */
	@GetMapping("/async")//spring4.3才出
	//@RequestMapping(value="/async",method=RequestMethod.GET)
	public void testAsync() {
		testService.testAsync();
	}
	
	/**
	 * 测试新增cookie
	 */
	@RequestMapping(value="/cookie/add",method=RequestMethod.GET)
	public String testCookieAdd(HttpServletRequest request, HttpServletResponse response) {
		// 设置cookie值 （带特殊字符时tomcat会默认加上双引号，-1代表随session销毁）
		CookieTools.addCookie(request, response, "testCookie", "test+%@3", -1);
		return "success";
	}
	

	/** 
	 * 测试添加到redis
	 * @param code
	 */
	@RequestMapping(value="/redis/add",method=RequestMethod.PUT)
	public void testAddRedis(@RequestParam("code")String code) {
		Jedis jedis = JedisPoolTools.getJedis();
		jedis.setex("code", 10, code);//设置生存时间方法，单位秒
		JedisPoolTools.closeJedis(jedis);//释放连接
	}
	
	/** 
	 * 测试根据ticket查询redis
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/redis/find",method=RequestMethod.GET)
	public String testFindRedis(@RequestParam("code")String code) {
		Jedis jedis = JedisPoolTools.getJedis();
		String result = jedis.get(code);
		JedisPoolTools.closeJedis(jedis);//释放连接
		return result;
	}
}
