package com.lok.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Lok
 * @2020年1月26日
 * @description 
 */
public class TimeUtil {

	public static void main(String[] args) throws Exception {
//		getAllTimezoneId();
		System.out.println("To GMT time: "+ convertToGmtTime("Europe/London", "13:00:00"));//Europe/London, Asia/Shanghai
		System.out.println("To User time: "+ convertToUserTime("Europe/London", "13:00:00"));//Europe/London, Asia/Shanghai
//		getDaysGap();
//		getTimeGap();
//		System.out.println(date.toString()); // 2020-01-27
//		System.out.println(date.getYear()); // 2020
//		System.out.println(date.getMonthValue()); // 1
//		System.out.println(date.getDayOfMonth()); // 27
//		System.out.println(date.getDayOfWeek()); // MONDAY
//		System.out.println(getDate(2020, 1, 2)); // 2020-01-02
		System.out.println(getTime(8, 30, 0)); // 15:52:47.239
//		System.out.println(getFormat(getTodayTime(), "dd/MM/yyyy")); // 27/01/2020
	}

	//毫秒数
	public static Instant getCurrentMillion() {
		Instant instant = Instant.now();
		return instant;
	}
	
	//日期
	public static String getDate(int year, int month, int dayOfMonth) {
		//方式一: 通过年月日构造
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		//方式二：直接字符串解析
		//LocalDate date2 = LocalDate.parse("2020-01-01");//默认用就是DateTimeFormatter.ISO_LOCAL_DATE
		//LocalDate date2 = LocalDate.parse("20200101", DateTimeFormatter.BASIC_ISO_DATE);
		return date.toString();
	}
	
	//时间
	public static LocalTime getTime(int hour, int minute, int second) {
		//方式一：通过时分秒构造
		LocalTime time = LocalTime.of(hour, minute, second);
		//方式二：直接字符串解析
		//LocalTime time2 = LocalTime.parse("08:30:00", DateTimeFormatter.ISO_LOCAL_TIME);
		return time;
	}
	
	// 日期+时间
	public static LocalDateTime getTodayTime() {
		LocalDateTime now = LocalDateTime.now();
		return now;
	}
	
	//格式化
	public static String getFormat(LocalDateTime date, String pattern) {
		//有几个常用的如 yyyy-MM-dd->DateTimeFormatter.ISO_LOCAL_DATE，yyyyMMdd->DateTimeFormatter.BASIC_ISO_DATE
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String result = date.format(formatter);
		return result;
	}
	
	//获取2时间相差(秒数)例子
	public static void getTimeGap() {
		Instant instant = getCurrentMillion();
		Duration duration = Duration.between(instant, Instant.now());
		System.out.println(duration.getNano());
	}
	
	//获取2日期相差(天数)例子
	public static int getDaysGap() {
		LocalDate date = LocalDate.now();
		Period between = Period.between(date, date);
		int days = between.getDays();
		return days;
	}

	//获取标准时区列表
	public static void getAllTimezoneId() {
		String[] availableIDs = TimeZone.getAvailableIDs();
		for (String string : availableIDs) {
			System.out.println(string);
		}
	}
	
	//根据timezoneId将指定时区时间转成gmt时间(因服务器环境总会改变默认Timezone，故需TimeZone.setDefault方式指定时区)
	public static String convertToGmtTime(String fromTimezoneId, String userTime) throws ParseException {
		return convertTimeByTimezone(fromTimezoneId, "GMT", userTime);
	}
	
	//根据timezoneId将gmt时间转成指定时区时间(因服务器环境总会改变默认Timezone，故需TimeZone.setDefault方式指定时区)
	public static String convertToUserTime(String toTimezoneId, String userTime) throws ParseException {
		return convertTimeByTimezone("GMT", toTimezoneId, userTime);
	}
	
	public static String convertTimeByTimezone(String fromTimezoneId, String toTimezoneId, String fromTime) throws ParseException {
		TimeZone.setDefault(TimeZone.getTimeZone(fromTimezoneId));
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date fromDate = dateFormat.parse(fromTime);
		TimeZone.setDefault(TimeZone.getTimeZone(toTimezoneId));
		LocalDateTime toDateTime = LocalDateTime.ofInstant(fromDate.toInstant(), ZoneId.of(TimeZone.getDefault().getID()));
		//TimeZone.setDefault(TimeZone.getTimeZone(timezoneId));
		//ZonedDateTime zonedDateTime = toDateTime.atZone(ZoneId.of(TimeZone.getDefault().getID()));
		//LocalDateTime gmtDateTime = zonedDateTime.toLocalDateTime();
		return DateTimeFormatter.ISO_LOCAL_TIME.format(toDateTime);//DateTimeFormatter.ISO_LOCAL_TIME格式为HH:mm:ss
	}
	
}
