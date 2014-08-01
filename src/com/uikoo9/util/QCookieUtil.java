package com.uikoo9.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie 工具类
 * 1.添加一个cookie
 * 2.添加一个cookie，设置有效期
 * 3.通过name获取一个cookie的value
 * 4.删除某一个cookie
 * 5.删除所有cookie
 * @author uikoo9
 * @version 0.0.1.20140430
 */
public class QCookieUtil {
	
	/**
	 * 添加cookie
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void addCookie(HttpServletResponse response, String name, String value){
		response.addCookie(new Cookie(name, value));
	}
	
	/**
	 * 添加cookie，并设置有效期
	 * maxage：负数浏览器关闭，正数单位是秒，0表示删除
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxage){
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxage);
		
		response.addCookie(cookie);
	}
	
	/**
	 * 获取一个cookie的值
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getValue(HttpServletRequest request, String name){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(name.equals(cookie.getName())){
				return cookie.getValue();
			}
		}
		
		return null;
	}
	
	/**
	 * 删除某一个cookie
	 * @param response
	 * @param name
	 */
	public static void delCookie(HttpServletResponse response, String name){
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		
		response.addCookie(cookie);
	}
	
	/**
	 * 删除所有cookie
	 * @param request
	 * @param response
	 */
	public static void delAll(HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			cookie.setValue(null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			
			response.addCookie(cookie);
		}
	}
	
}
