package com.uikoo9.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 数组工具类
 * 1.去除数组中重复元素，返回List
 * 2.判断数组为空
 * 3.判断数组非空
 * 4.将文件数组转为文件list
 * @author uikoo9
 * @version 0.0.1.20140423
 */
public class QArrayUtil {
	/**
	 * 去除数组中重复元素，并且返回无重复的List
	 * @param strings 字符串数组
	 * @return 去掉重复元素之后的List
	 */
	public static List<String> stringsDistinct(String[] strings){
		List<String> list = new ArrayList<String>(Arrays.asList(strings));
		
		HashSet<String> h = new HashSet<String>(list);
		list.clear();
		list.addAll(h);
		
		return list;
	}
	
	/**
	 * 去掉list中的重复元素
	 * @param strings
	 * @return
	 */
	public static List<String> stringsDistinct(List<String> strings){
		HashSet<String> h = new HashSet<String>(strings);
		strings.clear();
		strings.addAll(h);
		
		return strings;
	}
	
	/**
	 * 判断一个数组为null或者空
	 * @param lists
	 * @return
	 */
	public static boolean isEmpty(List<? extends Object> lists){
		return lists == null || lists.size() == 0 ? true : false;
	}
	
	/**
	 * 判断数组中有数据
	 * @param lists
	 * @return
	 */
	public static boolean notEmpty(List<? extends Object> lists){
		return lists != null && lists.size() > 0 ? true : false;
	}
	
	/**
	 * 将文件数组转为文件list
	 * @param files
	 * @return
	 */
	public static List<File> getFileListByFiles(File[] files){
		List<File> list = new ArrayList<File>();
		for(File f : files){
			list.add(f);
		}
		
		return list;
	}
}
