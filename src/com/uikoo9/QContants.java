package com.uikoo9;

import com.uikoo9.util.QFileUtil;

/**
 * 常量
 * @author uikoo9
 */
public class QContants {
	
	/**
	 * 常量
	 */
	public static final String C_CODE		= "code";
	public static final String C_MENUS 		= "menus";
	
	public static final String C_USER 		= "user";
	public static final String C_USERNAME	= "username";
	public static final String C_PASSWORD	= "password";
	
	public static final String C_ID			= "id";
	public static final String C_IDS		= "ids";
	public static final String C_ROW		= "row";
	public static final String C_QPAGE		= "qpage";
	// end-----------------------------------------------------------------------------------------
	
	/**
	 * 提示信息
	 */
	public static final String T_SUC		= "suc";
	public static final String T_MD5_FAIL	= "md5 encode fail！";
	public static final String T_MD5_REQ	= "please enter sth.";
	public static final String T_LOGIN_FAIL	= "用户名或密码错误！";
	public static final String T_LOGIN_REQ	= "请输入用户名和密码！";
	// end-----------------------------------------------------------------------------------------
	
	/**
	 * controller url
	 */
	public static final String U_BASE			= "/";
	public static final String U_LOGIN			= "/login";
	public static final String U_MD5			= "/md5";
	
	public static final String U_UCENTER_MENU	= "/ucenter/menu";
	public static final String U_UCENTER_USER	= "/ucenter/user";
	
	public static final String U_PRO_DETAIL		= "/pro/detail";
	public static final String U_PRO_VERSION	= "/pro/version";
	// end-----------------------------------------------------------------------------------------

	/**
	 * 页面地址
	 */
	public static final String P_HOME				= "/WEB-INF/view/home.ftl";
	public static final String P_MANAGE		 		= "/WEB-INF/view/manage.ftl";
	
	public static final String P_UCENTER_MENU_INDEX	= "/WEB-INF/view/ucenter-menu-index.ftl";
	public static final String P_UCENTER_MENU_INPUT	= "/WEB-INF/view/ucenter-menu-input.ftl";
	public static final String P_UCENTER_USER_INDEX	= "/WEB-INF/view/ucenter-user-index.ftl";
	public static final String P_UCENTER_USER_INPUT	= "/WEB-INF/view/ucenter-user-input.ftl";
	
	public static final String P_PRO_DETAIL_INDEX	= "/WEB-INF/view/pro-detail-index.ftl";
	public static final String P_PRO_DETAIL_INPUT	= "/WEB-INF/view/pro-detail-input.ftl";
	
	public static final String P_MD5		 		= "/WEB-INF/view/md5.ftl";
	// end-----------------------------------------------------------------------------------------
	
	/**
	 * table name
	 */
	public static final String TABLE_UCENTER_MENU			= "ucenter_menu";
	public static final String TABLE_UCENTER_USER			= "ucenter_user";

	public static final String TABLE_PRO_DETAIL				= "pro_detail";
	// end-----------------------------------------------------------------------------------------
	
	/**
	 * sql语句
	 */
	public static final String SQL_UCENTER_MENU_ALL		= "select * from ucenter_menu";
	public static final String SQL_UCENTER_USER_ALL		= "select * from ucenter_user";
	public static final String SQL_UCENTER_USER_LOGIN	= "select * from ucenter_user where username=? and password=?";
	// end-----------------------------------------------------------------------------------------
	
	/**
	 * 返回一个路径的绝对路径
	 * @param url
	 * @return
	 */
	public static final String BASE_URL = QFileUtil.readProperties("/config.properties").getProperty("baseUrl");
	public static String url(String url){
		return BASE_URL + url;
	}
	
}
