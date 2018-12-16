package com.lok.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * @Description 
 * @date 2017年9月18日
 */

@Data
@Entity
@Table(name="User")
//@DynamicInsert(true) //动态插入，与下雷同
//@DynamicUpdate(true) //动态更新，update时无内容的默认不更新，否则数据库都更为null了
public class User {
	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="age")
	private int age;
	
}
