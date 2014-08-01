package com.uikoo9.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串工具类
 * 1.字符串判空
 * 2.字符串非空
 * 3.校验字符串数组中任一字符串为空
 * 4.校验一个字符串数组中的字符串都不为空
 * 5.将s转为字符串
 * 6.将s转为int
 * 7.分隔字符串
 * 8.首字母大写
 * 9.首字母小写
 * 10.分隔符最后一个字符串
 * 11.将驼峰命名的字符串拆分
 * @author uikoo9
 * @version 0.0.3.20140702
 */
public class QStringUtil {

	/**
	 * 判断字符串是空字符串
	 * @param s 字符串
	 * @return 判断结果
	 */
	public static boolean isEmpty(String s){
		return s == null || s.trim().equals("") ? true : false;
	}
	
	/**
	 * 判断字符串不是空字符串
	 * @param s 字符串
	 * @return 判断结果
	 */
	public static boolean notEmpty(String s){
		return s != null && !s.trim().equals("") ? true : false;
	}
	
	/**
	 * 校验字符串数组中任一字符串为空
	 * @param ss
	 * @return
	 */
	public static boolean anyoneEmpty(String[] ss){
		if(ss.length == 0) return true;
		
		for(String s : ss){
			if(isEmpty(s)) return true;
		}
		
		return false;
	}
	
	/**
	 * 校验一个字符串数组中的字符串都不为空
	 * @param ss
	 * @return
	 */
	public static boolean allNotEmpty(String[] ss){
		if(ss.length == 0) return false;
		
		for(String s : ss){
			if(isEmpty(s)) return false;
		}
		
		return true;
	}
	
	/**
	 * 若s为null则返回空字符串
	 * @param s
	 * @return
	 */
	public static String toStr(String s){
		return s == null ? "" : s;
	}
	
	/**
	 * 将String转为int
	 * @param s
	 * @return
	 */
	public static int toInt(String s){
		return isEmpty(s) ? 0 : Integer.parseInt(s);
	}
	
	/**
	 * 用分隔符将字符串分割为字符串的List，
	 * 若字符串为空则返回null
	 * @param s 待分隔的字符串
	 * @param split 分隔符
	 * @return 分隔后的字符串List
	 */
	public static List<String> splitToList(String s, String split){
		if(s == null) return null;
		
		return new ArrayList<String>(Arrays.asList(s.split(split)));
	}
	
	/**
	 * 字符串首字母大写
	 * @param s
	 * @return
	 */
	public static String firstUpper(String s){
		StringBuilder sb = new StringBuilder(s);
		
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		
		return sb.toString();
	}
	
	/**
	 * 首字母小写
	 * @param s
	 * @return
	 */
	public static String firstLower(String s){
		StringBuilder sb = new StringBuilder(s);
		
		sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
		
		return sb.toString();
	}
	
	/**
	 * 得到分隔符分隔后的最后一个字符串
	 * @param str
	 * @param split
	 * @return
	 */
	public static String lastString(String str, String split){
		if(isEmpty(str)){
			return "";
		}else{
			String[] ss = str.split(split);
			return ss[ss.length - 1];
		}
	}
	
	/**
	 * 将驼峰命名的字符串拆分
	 * @param s
	 * @return
	 */
	public static List<String> tuoFeng(String s){
		List<String> res = new ArrayList<String>();
		
		if(QStringUtil.notEmpty(s)){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<s.length(); i++){
				if(i != 0 && Character.isUpperCase(s.charAt(i))){
					res.add(sb.toString());
					sb.delete(0, sb.length());
				}
				
				sb.append(s.charAt(i));
				
				if((i+1) == s.length()){
					res.add(sb.toString());
				}
			}
		}
		
		return res;
	}
	
}
