package com.lok.utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * @author Lok
 * @2020年1月26日
 * @description 
 */
public class TimeUtil {

	public static void main(String[] args) {
		Instant instant = getCurrentMillion();
		LocalDate date = getToday();
		Period between = Period.between(date, date);
		between.getDays();
		Duration duration = Duration.between(instant, Instant.now());
		System.out.println(duration.getNano());
		System.out.println(date.toString()); // 2020-01-27
		System.out.println(date.getYear()); // 2020
		System.out.println(date.getMonthValue()); // 1
		System.out.println(date.getDayOfMonth()); // 27
		System.out.println(date.getDayOfWeek()); // MONDAY
		System.out.println("======================");
		System.out.println(getDate(2020, 1, 2)); // 2020-01-02
		System.out.println("======================");
		System.out.println(getNow()); // 15:52:47.239
		System.out.println("======================");
		System.out.println(getFormat(getTodayTime(), "dd/MM/yyyy")); // 27/01/2020
	}
	
	
	//毫秒数
	public static Instant getCurrentMillion() {
		Instant instant = Instant.now();
		return instant;
	}
	
	//日期
	public static LocalDate getToday() {
		LocalDate date = LocalDate.now();
		return date;
	}
	
	//指定日期
	public static String getDate(int year, int month, int dayOfMonth) {
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		return date.toString();
	}
	
	//时间
	public static LocalTime getNow() {
		LocalTime now = LocalTime.now();
		return now;
	}
	
	// 日期+时间
	public static LocalDateTime getTodayTime() {
		LocalDateTime now = LocalDateTime.now();
		return now;
	}
	
	//格式化
	public static String getFormat(LocalDateTime date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String result = date.format(formatter);
		return result;
	}
}
