package com.lok.domain;

//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * @Description 
 * @date 2017年9月18日
 */

@Data
//@DynamicInsert(true) //动态插入，与下雷同
//@DynamicUpdate(true) //动态更新，update时无内容的默认不更新，否则数据库都更为null了
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
