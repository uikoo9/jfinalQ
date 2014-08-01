package com.uikoo9.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 1.格式化时间
 * 2.时间字符串
 * 3.得到几天前或几天后的date
 * 4.判断当前日期是否在一个有效期内
 * 5.获取当前时间精确到毫秒的字符串
 * @author uikoo9
 * @version 0.0.1.20140430
 */
public class QDateUtil {
	
	/**
	 * 格式化日期和时间
	 * @param date 需要格式化的日期时间
	 * @param toStr 格式化成的样子
	 * y	年
	 * M	月
	 * d	天
	 * H	时
	 * m	分
	 * s	秒
	 * @return
	 */
	public static String format(Date date, String format){
		return date == null ? null : new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 获取系统当前毫秒数
	 * @return
	 */
	public static long getNowTime(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 得到几天前或几天后的date
	 * @param day 负数代表几天前，正数代表几天后
	 * @return date
	 */
	public static Date getDateByDays(int day){
		Calendar calendar = Calendar.getInstance();
		long now = calendar.getTimeInMillis();
		long res = now + (new BigDecimal(day).multiply(new BigDecimal(24 * 60 * 60 * 1000)).longValue());
		calendar.setTimeInMillis(res);
		
		return calendar.getTime();
	}
	
	/**
	 * 判断当前日期是否在一个有效期内
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean between(Date start, Date end){
		Date now = new Date();
		if(start == null || end == null){
			return false;
		}else if(now.after(start) && now.before(end)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 得到当前时间精确到秒的字符串
	 * @return
	 */
	public static String dateStr(){
		return format(new Date(), "yyyyMMddHHmmss");
	}
	
}