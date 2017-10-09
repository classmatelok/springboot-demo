package com.lok.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lok.utils.AsyncCoreTools;

/**
 * @Description 
 * @date 2017年10月9日
 */

@RestController
@RequestMapping("testAsync")
public class TestSBFunctionController {
	
	@Autowired
	private AsyncCoreTools asyncCore;//注入异步中心管理类
	
	/**
	 * 测试异步调用，通过异步中心管理类
	 * @return
	 */
	@RequestMapping("/asyncTools")
	public String testAsync() {
		String result1 = "";
		String result2 = "";
		Future<String> test1F = asyncCore.test1();
		Future<String> test2F = asyncCore.test2();
		asyncCore.test3();
		System.out.println("===== main thread =====");
		
		try {
			result1 = test1F.get();
			result2 = test2F.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return result1+" = "+result2;
	}
	
}
