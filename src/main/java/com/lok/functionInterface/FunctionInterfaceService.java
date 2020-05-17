package com.lok.functionInterface;

import org.springframework.stereotype.Service;
import com.lok.functionInterface.FunctionInterface;
import com.lok.functionInterface.FunctionInterfaceWithParam;

/**
 * @Description 函数式接口service运用例子：输入数字，(通过公共逻辑统一处理后)局部按函数式不同的实现，算出结果。
 * 使用场景：尤其是多个功能接口的实现里有大量相同逻辑代码，仅局部逻辑不同时，即可考虑函数时接口，可视作匿名内部类使用
 * @date 2017年10月9日
 */
@Service
public class FunctionInterfaceService{
	
	public void getByFunctionInterface(FunctionInterface funInterface) {
		funInterface.getByFunctionInterface();
	}
	
	public String getByFunctionInterfaceWithParam(FunctionInterfaceWithParam funInterfaceWithParam, Integer num) {
		//1.公共逻辑
		num = Integer.valueOf(num.intValue()*10);
		//2.局部逻辑，根据不同的函数式接口来实现不同运算逻辑，由调用方定义此块逻辑
		String commonResult = funInterfaceWithParam.getByFunctionInterfaceWithParam(num);
		//3.公共逻辑
		return "统一乘以10，" + commonResult;
	}
}
