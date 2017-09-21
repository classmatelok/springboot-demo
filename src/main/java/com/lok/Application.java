package com.lok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
*/

/**
 * @Description 启动类
 */

/*
//@SpringBootApplication相当于以下三个
@Configuration // 默认加载classpath下的application.properties
@EnableAutoConfiguration
@ComponentScan // 可指定包，默认扫启动类的同包及子包
*/
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
/*		
		//可设置JVM参数
		System.setProperty("TEST_JVM_VALUE", "testtesttest");
		//可获取JVM参数（优先获取动态设置的，再获取手动配置的）
		System.out.println(System.getProperty("TEST_JVM_VALUE"));
		//可获取系统环境变量
		System.out.println(System.getenv("path"));
*/
		SpringApplication.run(Application.class, args);
	}
}
