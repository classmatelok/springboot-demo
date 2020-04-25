package com.lok.mongo;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @Description 
 * @date 2017年9月18日
 */

@Data
//@Document(collection = "xx_user")//jpa配置
public class MongoBeanDemo {

	//@Id//jpa配置
	private int id;
	private String name;
	private String sex;
	private int age;
	
}
