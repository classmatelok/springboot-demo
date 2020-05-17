package com.lok.schedule;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleJobServiceImp {

	@Autowired
	private ScheduleJobManager scheduleJobManager;
	
	@PostConstruct //spring加载此类完毕即执行此注解标注的方法
	private void initClass() {
		System.out.println("ScheduleJobServiceImp初始化了。");
		startTask();
		//此处可做如从db查出定时任务列表，遍历调用下面startTask，作为初始化数据库已有定时任务
	}
	
	public void startTask() {
		//此处可查db等查出一个定时任务list数据，遍历创建
		System.out.println("即将新建定时任务.");
		this.scheduleJobManager.startTask(() -> {
			System.out.println("xxx动态新增的定时任务执行了。xxx");
		}, "*/50 * * ? * MON-FRI"); //表示工作周每隔1分钟
	}
	
	//另可@scheduled直接设定一个特殊的定时任务，在里面再动态管理别的定时任务
}
