package com.uikoo9.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session工具类
 * 01.获取session
 * 02.移除session
 * 03.获取session的属性名称集合
 * 04.获取属性
 * 05.设置属性
 * 06.移除属性
 * 07.获取有效期
 * 08.设置有效期
 * 09.获取id
 * 10.获取创建时间
 * 11.获取最后访问时间
 * 12.判断是否新建
 * @author uikoo9
 * @version 0.0.3.20140617
 */
public class QSessionUtil {
	
	/**
	 * 获取session
	 * @param request
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest request){
		return request.getSession(true);
	}
	
	/**
	 * 删除这个session
	 * @param session
	 */
	public static void removeSession(HttpSession session){
		session.invalidate();
	}
	
	/**
	 * 获取session的属性名称集合
	 * @param session
	 * @return
	 */
	public static Enumeration<String> getAttributeNames(HttpSession session){
		return session.getAttributeNames();
	}
	
	/**
	 * 获取session中的一个属性值
	 * @param session
	 * @param name
	 * @return
	 */
	public static Object getAttribute(HttpSession session, String name){
		return session.getAttribute(name);
	}
	
	/**
	 * 为session添加属性
	 * @param session
	 * @param name
	 * @param value
	 */
	public static void setAttribute(HttpSession session, String name, Object value){
		session.setAttribute(name, value);
	}
	
	/**
	 * 移除session的一个属性
	 * @param session
	 * @param name
	 */
	public static void removeAttribute(HttpSession session, String name){
		session.removeAttribute(name);
	}
	
	/**
	 * 获取session的有效期，单位为秒
	 * @param session
	 * @return
	 */
	public static int getInterval(HttpSession session){
		return session.getMaxInactiveInterval();
	}
	
	/**
	 * 设置session的有效期，单位为秒
	 * @param session
	 * @param interval
	 */
	public static void setMaxInterval(HttpSession session, int interval){
		session.setMaxInactiveInterval(interval);
	}
	
	/**
	 * 获取session的id
	 * @param session
	 * @return
	 */
	public static String getId(HttpSession session){
		return session.getId();
	}
	
	/**
	 * 获取session的创建时间
	 * @param session
	 * @return
	 */
	public static long getCreateTime(HttpSession session){
		return session.getCreationTime();
	}
	
	/**
	 * 获取session的最后一次访问时间
	 * @param session
	 * @return
	 */
	public static long getModifyTime(HttpSession session){
		return session.getLastAccessedTime();
	}
	
	/**
	 * 获取session是否为新建的
	 * @param session
	 * @return
	 */
	public static boolean isNew(HttpSession session){
		return session.isNew();
	}
	
}
