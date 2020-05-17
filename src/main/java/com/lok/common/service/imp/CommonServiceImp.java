package com.lok.common.service.imp;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lok.common.service.CommonService;

/**
 * @Description 公用service实现类
 * @date 2017年10月9日
 */
@Service
public class CommonServiceImp implements CommonService{
//	private volatile int i = 0;//无法保证原子性
	private AtomicInteger iAtomic = new AtomicInteger(1);//使用原子类保证原子性，不会受指令重排序影响
	
	/**
	 * 异步调用，不推荐在下列3方法直接使用@Async注解，否则将变同线程处理
	 */
	public String printOut1(String commonStr) {
		System.out.println(">> printOut1 started with thread: " + Thread.currentThread().getName() + " and going to sleep 2s.");
		try {
			Thread.sleep(2000);//让线程1睡眠测试future1.get()时是否阻塞别的线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "task 1 " + commonStr;
	}
	public String printOut2(String commonStr) {
		System.out.println(">> printOut2 started with thread: " + Thread.currentThread().getName());
		return "task 2 " + commonStr;
	}
	public void printOut3() {
		System.out.println(">> printOut3 started with thread: " + Thread.currentThread().getName());
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
}
