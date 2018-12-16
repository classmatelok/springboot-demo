package com.lok.service.imp;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lok.service.CommonService;

/**
 * @Description 公用service实现类
 * @date 2017年10月9日
 */
@Service
public class CommonServiceImp implements CommonService{
	private int i = 0;
	
	/**
	 * 异步调用
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
		System.out.println("执行了!第"+(i++)+"次");
	}
}
