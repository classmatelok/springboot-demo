package com.lok.functionInterface;

//函数时接口注解：接口里只能有且仅有一个抽象方法，否则报错。但java.lang.Object中的方法抽象不算
@FunctionalInterface
public interface FunctionInterfaceWithParam {
	
	String getByFunctionInterfaceWithParam(Integer num);
}
