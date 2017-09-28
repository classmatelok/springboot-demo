package com.lok.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description 格式化工具类
 * @date 2017年9月28日
 */

public class FormatTools {

	/*public static void main(String[] args) {
		//给list排序
		String[] arr = {"A","A-","A+","AA","AA-","AA+","AAA","B","B-",  "B+", "BB", "BB-", "BB+","BBB","BBB-","BBB+"};
		sortList(Arrays.asList(arr));
	}*/
	
	/**
	 * 字符串等级排序
	 * @param list
	 */
	public static void sortList(List<String> list ) {
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
}
