package com.lok.utils;

import java.math.BigDecimal;

/**
 * @author Lok
 * @2020年1月24日
 * @description 
 */
public class BigDecimalTools {

	
	private static String addDecimal(String num1Str, String num2Str) {
		BigDecimal num1 = new BigDecimal(num1Str);
		return num1.add(new BigDecimal(num2Str)).toPlainString();//取消科学计数显示模式
	}
	
	private static String subtractDecimal(String num1Str, String num2Str) {
		BigDecimal num1 = new BigDecimal(num1Str);
		return num1.subtract(new BigDecimal(num2Str)).toPlainString();//取消科学计数显示模式
	}
	
	private static String multiplyDecimal(String num1Str, String num2Str) {
		BigDecimal num1 = new BigDecimal(num1Str);
		return num1.multiply(new BigDecimal(num2Str)).toPlainString();//取消科学计数显示模式
	}
	
	private static String divideDecimal(String num1Str, String num2Str) {
		BigDecimal num1 = new BigDecimal(num1Str);
		return num1.divide(new BigDecimal(num2Str)).toPlainString();//取消科学计数显示模式
	}
}
