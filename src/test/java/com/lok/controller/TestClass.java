package com.lok.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.lok.crud.domain.User;
import com.lok.crud.service.UserService;

@RunWith(SpringRunner.class)//或全称SpringJUnit4ClassRunner
@SpringBootTest(classes=com.lok.LokApplication.class)
@TestPropertySource("classpath:application-test.properties")//配置特殊文件配置，若不另配test环境配置文件，默认只读application.properties
public class TestClass {
	
	@Autowired
	private UserService userService;
	
	@Before
	public void setUp() {
		System.out.println("setup success!");
	}
	
	@Test
	public void testQuery() {
		List<User> listUser = userService.listUser();
		System.out.println(listUser);
	}
	
}
