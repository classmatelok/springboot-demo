package com.lok.common.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lok.common.service.imp.TestServiceImp;
import com.lok.common.domain.JsonDemo;
import com.lok.common.service.CommonService;
import com.lok.common.utils.CookieTools;
import com.lok.common.utils.JedisPoolTools;

import redis.clients.jedis.Jedis;

/**
 * 此controller为了测试一些接口
 * @author lok
 */
@RestController
@RequestMapping("/test")// -> 访问路径为http://localhost:8080/test
public class TestController {
	
	@Autowired
	private TestServiceImp testService;
	@Autowired
	private CommonService commonService;
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
	
	/**
	 * 测试策略模式的运用：传入不同课程类型，触发不同上课内容
	 * @param courseType 
	 * @return
	 */
	@GetMapping("/teach/{courseType:\\w+}")//路径参数courseType需满足该正则表达式
	public String teachByCourseType(@PathVariable("courseType") String courseType) {
		return this.commonService.teachByCourseType(courseType);
	}
	
	/**
	 * 测试函数式接口的运用：将输入数字按不同函数式实现算出结果。
	 * 使用场景：尤其是多个功能接口的实现里有大量相同逻辑代码，仅局部逻辑不同时，即可考虑函数时接口，可视作匿名内部类使用
	 * @param num 输入数字 
	 * @return
	 */
	@GetMapping("/functionInterface")
	public List<String> testFunctionInterface(@RequestParam("num") Integer num) {
		return this.testService.testFunctionInterface(num);
	}
}
