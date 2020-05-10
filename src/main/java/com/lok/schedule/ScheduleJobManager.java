package com.lok.schedule;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component//或将此类scope设为多例，将map放到别的地方，即可start/stop时不加锁
public class ScheduleJobManager {

	//用于存放正在跑的定时任务，key为自定义job唯一的标识
	private Map<String, ScheduledFuture<?>> jobs = new ConcurrentHashMap<>();
	private Lock lock = new ReentrantLock();
	
	@Autowired
	private TaskScheduler taskScheduler;
	
	public void startTask(Runnable task, String cron) {
		ScheduledFuture<?> future = taskScheduler.schedule(task, new CronTrigger(cron)); //CronTrigger也可指定TimeZone
		jobs.put("xxx", future);//可挪至使用类处操作，亦可传key进来操作
	}
	
	public void stopTask(String jobKey) {
		ScheduledFuture<?> future = jobs.get(jobKey);
		lock.lock();
		if (future != null) {
			future.cancel(true);//是否等任务线程完成再中断
		}
		lock.unlock();
	}
}
