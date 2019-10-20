package com.lok.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class OtherUtils {
	public static void main(String[] args) {
//		System.out.println("431456196803022030".matches("([1-9]\\d{5}(18|19)\\d{2}(0[1-9]|1[0-2])\\d{5}[0-9Xx])|\\d{15}"));//身份证正则校验
		
		//时间转毫秒数
//		timeTurnMillion("2019-01-01 00:00:00");
		
		//毫秒数转时间
//		millionTurnTime("1519272156000");
		
		//打印A~Z and a~z
		getCode();
		
		//按“，”分割字符串
//		splitStr("");
		
		//去“-”符号
//		removeSymbol("78974515-6");
		
		//给list排序
//		String[] arr = {"A","A-","A+","AA","AA-","AA+","AAA","B","B-",  "B+", "BB", "BB-", "BB+","BBB","BBB-","BBB+"};
//		sortList(Arrays.asList(arr));
//		for (String string : arr) {
//			System.out.println(string);
//		}
		
		//获取list中当前页的子list(参1:pageSize，参2：pageNum)
//		getCurrentPageContent(3,3,Arrays.asList(1,2,3,4,5,6,7,8));
		//获取map中当前页的子map(参1:pageSize，参2：pageNum)
//		Map<String, String> map = new HashMap<>();
//		map.put("1", "a");
//		map.put("2", "b");
//		map.put("3", "c");
//		map.put("4", "d");
//		map.put("5", "e");
//		getCurrentPageContent(2,3,map);
		
	}
	
	/** 日期转毫秒数 */
	private static void timeTurnMillion(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(time);
			System.out.println(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/** 毫秒数转日期 */
	private static void millionTurnTime(String million) {
		Date date = new Date();
		date.setTime(Long.parseLong(million));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
	}
	
	/** 打印A~Z and a~z */
	private static void getCode() {
		for (int i = 97; i < 97+26; i++) {
			System.out.print((char)i);
		}
		System.out.println();
		for (int i = 65; i < 65+26; i++) {
			System.out.print((char)i);
		}
	}
	
	/** 按“，”分割字符串 */
	private static void splitStr(String str) {
		for (String string : str.split(",")) {
			System.out.println(string);
		}
	}
	
	/** 去“-”符号 */
	private static void removeSymbol(String str) {
		int index = str.lastIndexOf("-");
		if (index!=-1) {
			str = str.substring(0,index)
					+str.substring(index+1);
		}
		System.out.println(str);
	}
	
	/** 排序，如:{"A","A-","A+","AA","AA-","AA+","AAA","B","B-",  "B+", "BB", "BB-", "BB+","BBB","BBB-","BBB+"} */
	private static void sortList(List<String> list ) {
		Collections.sort(list,new Comparator<String>() {
			//把等级列表按如"AAA,AA+,AA,AA-,A+"降序排列
			@Override
			public int compare(String o1, String o2) {
				if (null!=o1 && null!=o2) {
					
					if(o1.charAt(0)==o2.charAt(0)) {
						//若A- 与  A 比较，采取“升序”
						if (o1.length()==o2.length()+1 && o1.charAt(o1.length()-1)=='-'&&o2.charAt(o2.length()-1)==o2.charAt(0)) {
							return 1;
						}
						return -1;
					}else {
						//若 A 与 B 开头的比较，采取升序
						return 1;
					}
				}
				return o1.compareTo(o2);
			}
		});
	}
	
	/** 获取list中当前页的子list(参1:pageSize，参2：pageNum) */
	private static <T> void getCurrentPageContent(int pageSize, int pageNum, List<T> list) {
		List<T> subList = null;
		int listSize = list.size();
		//当数据不足一页时直接返回
		if(listSize<=pageSize) {
			subList = list;
		}else {
			int totalPage = listSize/pageSize;
			int pageRest = listSize%pageSize;
			int start=(pageNum-1)*pageSize;
			int end=pageNum*pageSize;
			//恰好总页数是pagesize的倍数，且页码不大于总页数
			if(pageRest>=0 && pageNum<=totalPage) {
				subList = list.subList(start, end);
			}else if(pageRest>0 && pageNum==(totalPage+1)){
				subList = list.subList(start, listSize);
			}else {
				System.out.println("请求页码有误，请求pageNum:"+ pageNum + ",而List长度为：" +listSize +"，pageSize："+pageSize);
			}
		}
		System.out.println(subList);
	}
	
	/** 获取map中当前页的子map(参1:pageSize，参2：pageNum) */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void getCurrentPageContent(int pageSize, int pageNum, Map<String,String> map) {
		Map subMap = null;
		int mapSize = map.size();
		if(mapSize<=pageSize) {
			subMap = map;
		}else {
			subMap = new HashMap<>();
			Map keyMap = new HashMap<>();
			Map valueMap = new HashMap<>();
			int start=(pageNum-1)*pageSize;
			int end=pageNum*pageSize;
			int i = 0;
			for (Map.Entry<String,String> entry : map.entrySet()) {
				keyMap.put(i, entry.getKey());
				valueMap.put(i, entry.getValue());
				i++;
			}
			for (int j = start; j < end; j++) {
				if(j>=mapSize) {
					break;
				}
				subMap.put(keyMap.get(j), valueMap.get(j));
			}
		}
		System.out.println(subMap);
	}
}

