package com.lok.common.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaDemo {
	
	private static String[] arr_demo = {"a","ab", "bcd", "bcd","abc","abcd", "cde","abcde"};
	private static List<String> list_demo;
	private static Map<String, String> map_demo;
	
	static {
		list_demo = new ArrayList<>(Arrays.asList(arr_demo));
		map_demo = new HashMap<>();
		map_demo.put("1", "test1");
		map_demo.put("2", "test2");
		map_demo.put("3", "test3");
		map_demo.put("4", "test4");
	}

	public static void main(String[] args) {
		//数组遍历
		System.out.println("===========数组============");
		Arrays.stream(arr_demo).forEach(x -> System.out.println(x));//或Stream.of(arr_demo)
		
		/** List */
		System.out.println("===========list============");
		listAction();
		
		/** Map */
		System.out.println("===========map=============");
		mapAction();
	}

	/** List */
	private static void listAction() {
		//过滤筛选
		List<String> list1 = list_demo.stream().filter(x -> x.contains("bc")).collect(Collectors.toList());
		System.out.println("包含bc的有：" + list1);
		System.out.println("包含bc并去重并排序：" + list1.stream().distinct().sorted().collect(Collectors.toList()));
		
		//找出匹配条件的第一个元素
		Optional<String> strOpt1 = list_demo.stream().filter(x -> x.contains("bc")).findFirst();
		if (strOpt1.isPresent()) System.out.println("方式一：找到包含bc的第一个元素：" + strOpt1.get());//方式一
		strOpt1.ifPresent(x->System.out.println("方式二：找到包含bc的第一个元素：" + x));//方式二
		System.out.println("方式三：找到包含bc的第一个元素：" + strOpt1.orElse("抱歉，找不到"));//方式三
		
		//是否有匹配条件的元素
		boolean containsBc = list_demo.stream().anyMatch(x -> x.contains("ac"));
		System.out.println("是否包含ac: " + containsBc);
		
		//改变list的元素
		List<String> list2 = list_demo.stream().map(x->"test_" + x).collect(Collectors.toList());
		System.out.println("每个元素加test_前缀：" + list2);
	}
	
	private static void mapAction() {
		//Map过滤
		Map<String, String> map1 = map_demo.entrySet().stream().filter(e -> e.getKey().equals("1"))
				.collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));
		System.out.println("key为1的是：" + map1);
	}
	
}
