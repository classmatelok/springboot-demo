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
}
