package com.lok.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lok.service.CommonService;
import com.lok.service.Course;

/**
 * @Description 公用service实现类
 * @date 2017年10月9日
 */
@Service
public class CommonServiceImp implements CommonService{
//	private volatile int i = 0;//无法保证原子性
	private AtomicInteger iAtomic = new AtomicInteger(1);//使用原子类保证原子性，不会受指令重排序影响
	
	@Autowired
	private List<Course> courses;
	
	/**
	 * 异步调用，不推荐在下列3方法直接使用@Async注解，否则将变同线程处理
	 */
	public String printOut1() {
		System.out.println("============== printOut1 ==============");
		try {
			Thread.sleep(2000);//让线程1睡眠测试多线程是否生效
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("thread1:"+Thread.currentThread().getName());
		return "task 1 complete";
	}
	public String printOut2() {
		System.out.println("============== printOut2 ==============");
		System.out.println("thread2:"+Thread.currentThread().getName());
		return "task 2 complete";
	}
	public void printOut3() {
		System.out.println("============== printOut3 ==============");
		System.out.println("thread3:"+Thread.currentThread().getName());
	}

	/**
	 * 定时任务
	 */
	//@Scheduled(cron=" 10 * * ? * *") // 秒 分 时 日 月 星期 [年] ，?代表占位，*代表所有，此例子代表每到x分10秒时执行
	@Scheduled(fixedRate=60*1000) //毫秒单位，此处表示每60秒执行一次
	public void printForSchedule() {
//		System.out.println("定时任务执行了!第"+(i++)+"次");
		System.out.println("定时任务执行了!第"+(iAtomic.getAndIncrement())+"次");//内部已是volatile修饰
	}
	
	/**
	 * 策略模式的运用：传入不同课程类型，触发不同上课内容（避免过多臃肿的ifelse）
	 */
	@Override
	public String teachByCourseType(String courseType) {
		Optional<Course> courseOpt = courses.stream().filter(c -> c.getCourseType().equalsIgnoreCase(courseType)).findFirst();
		return courseOpt.isPresent()? courseOpt.get().teach() : "抱歉，未找到相关课程！";
	}
}
