package com.lok.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lok.domain.User;
import com.lok.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=com.lok.LokApplication.class)
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
