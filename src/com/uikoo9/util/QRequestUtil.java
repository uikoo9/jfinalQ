package com.uikoo9.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Request工具类
 * 1.获取request中一些常用的信息
 * 2.获取项目的绝对路径
 * 3.判断是否盗链
 * @author uikoo9
 * @version 0.0.4.20140617
 */
public class QRequestUtil {
	
	/**
	 * 获取request中一些常用的信息
	 * @param request
	 * @return
	 */
	public static Map<String, String> getRequestInfos(HttpServletRequest request){
		Map<String, String> info = new HashMap<String, String>();
		
		info.put("serverIp", request.getLocalAddr());
		info.put("serverPCName", request.getLocalName());
		info.put("serverName", request.getServerName());
		info.put("serverPort", request.getServerPort() + "");
		info.put("serverPath", request.getContextPath());
		info.put("servletPath", request.getServletPath());
		info.put("userAgent", request.getHeader("user-agent"));
		info.put("userIp", request.getRemoteAddr());
		info.put("userRefer", request.getHeader("referer"));
		info.put("userURL", request.getRequestURL().toString());
		info.put("userURI", request.getRequestURI());
		info.put("userQuery", request.getQueryString());
		info.put("userMethod", request.getMethod());
		
		return info;
	}
	
	/**
	 * 获取项目的绝对路径
	 * @param request
	 * @return
	 */
	public static String getHttpPath(HttpServletRequest request){
		StringBuilder path = new StringBuilder();
		
		path.append(request.getScheme() + "://");
		path.append(request.getServerName() + ":");
		path.append(request.getServerPort());
		path.append(request.getContextPath());
		
		return path.toString();
	}
	
	/**
	 * 判断是否盗链
	 * @param request
	 * @return
	 */
	public static boolean isHotLinking(HttpServletRequest request){
		String referer = request.getHeader("referer");
		
		return (referer == null || !referer.contains(request.getServerName())) ? true : false; 
	}
	
}
