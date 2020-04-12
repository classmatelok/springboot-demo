package com.lok.common.utils;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.lok.common.service.CommonService;

/**
 * @Description 异步中心管理类
 * （避免直接侵入项目存在的类和方法，使同一个方法可自由选择是否异步，需要则通过此管理类去调）
 * @date 2017年10月9日
 */

@Component
public class AsyncCoreTools {

	//注入需要异步调用的相关的类
	@Autowired
	private CommonService commonService;
	
	//有返回值例子
	@Async
	public Future<String> test1(String commonStr) {
		String result1 = commonService.printOut1(commonStr);
		return new AsyncResult<String>(result1);
	}
	@Async
	public Future<String> test2(String commonStr) {
		String result2 = commonService.printOut2(commonStr);
		return new AsyncResult<String>(result2);
	}
	//没有返回值例子
	@Async
	public void test3() {
		commonService.printOut3();
	}
}
