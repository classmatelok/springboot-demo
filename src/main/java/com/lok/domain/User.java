package com.lok.domain;

import lombok.Data;

/**
 * @Description 
 * @date 2017年9月18日
 */

@Data
public class User {
	private int id;
	private String name;
	private String sex;
	private int age;
	
	public User() {
		super();
	}
	public User(int id, String name, String sex, int age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
}
