package com.lok.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lok.utils.JedisPoolTools;

import redis.clients.jedis.Jedis;

/**
 * @Description redis测试工具类
 */

@RestController
@RequestMapping("testRedis")
public class TestRedisController {
	
	// 测试添加到redis
	@RequestMapping(value="/add",method=RequestMethod.PUT)
	public String addRedis(@RequestParam("code")String code) {
		Jedis jedis = JedisPoolTools.getJedis();
		jedis.set("code", code);
		return "success";
	}
	
	// 测试根据ticket查询redis
	@RequestMapping(value="/select",method=RequestMethod.GET)
	public String selectRedis(@RequestParam("code")String code) {
		Jedis jedis = JedisPoolTools.getJedis();
		String result = jedis.get("code");
		return result;
	}
}
