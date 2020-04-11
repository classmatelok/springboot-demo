package com.lok.service;

/**
 * @Description 公用service接口
 * @date 2017年10月9日
 */

public interface CommonService {

	/**
	 * 异步调用
	 */
	String printOut1();
	String printOut2();
	void printOut3();
	
	/**
	 * 定时任务
	 */
	void printForSchedule();
	
	/**
	 * 策略模式的运用：传入不同课程类型，触发不同上课内容（避免过多臃肿的ifelse）
	 */
	String teachByCourseType(String courseType);
}
