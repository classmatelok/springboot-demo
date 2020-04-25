package com.lok.common.service;

import com.lok.functionInterface.FunctionInterface;
import com.lok.functionInterface.FunctionInterfaceWithParam;

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
	
	/**
	 * 策略模式的运用：传入不同课程类型，触发不同上课内容（避免过多臃肿的ifelse）
	 */
	String teachByCourseType(String courseType);
	
	/**
	 * 函数式接口的运用：输入数字，(通过公共逻辑统一处理后，)局部按函数式不同的实现，算出结果
	 */
	void getByFunctionInterface(FunctionInterface funInterface);//无参无返回值例子
	String getByFunctionInterfaceWithParam(FunctionInterfaceWithParam funInterfaceWithParam, Integer num);//有参有返回值例子
}
