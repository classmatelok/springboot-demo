package com.lok.common.service.imp;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lok.common.utils.AsyncCoreTools;

@Service
public class TestServiceImp {

//	@Autowired
//	private CommonService commonService;
	
	@Autowired
	private AsyncCoreTools asyncCoreTools;
	
	/**
	 * 测试多线程异步调用
	 */
	public void testAsync() {
		String str1 = null;
		String str2 = null;
		
		//方式一：同步测试，所有输出结果会按顺序执行
//		str1 = commonService.printOut1();
//		str2 = commonService.printOut2();
//		commonService.printOut3();
		
		//方式二：异步多线程测试，通过异步工具类
		ThreadLocal<String> commonStr = new ThreadLocal<String>();//用ThreadLocal包装线程共享变量
		commonStr.set("done");
		
		Future<String> test1 = asyncCoreTools.test1(commonStr.get());
		Future<String> test2 = asyncCoreTools.test2(commonStr.get());
		asyncCoreTools.test3();
		System.out.println("===== main thread =====");
		try {
			//会阻塞线程
			str1 = test1.get();
			str2 = test2.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//最后输出结果
		System.out.println(str1);
		System.out.println(str2);
	}

}
