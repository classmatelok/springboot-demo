package com.lok.common.service;

/**
 * @Description 公用service接口
 * @date 2017年10月9日
 */

public interface CommonService {

	/**
	 * 异步调用
	 * @param commonStr 
	 */
	String printOut1(String commonStr);
	String printOut2(String commonStr);
	void printOut3();
	
	/**
	 * 定时任务
	 */
	void printForSchedule();
}
