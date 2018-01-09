package com.lok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description 启动类
 */

/*
@Configuration // 默认加载classpath下的application.properties
@EnableAutoConfiguration
@ComponentScan // 可指定包，默认扫启动类的同包及子包
*/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) //相当于以上三个
@EnableAsync //开启异步调用功能
@EnableScheduling //开启定时任务
public class Application {
	
	/*//配置TaskExecutor线程池类，不配则默认SimpleAsyncTaskExecutor
	@Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        return executor;
    }*/
	
	
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
