package com.uikoo9.z;

import com.uikoo9.util.jfinal.QJfinalConfig;

/**
 * 常量
 * @author uikoo9
 */
public class QContants {
	
	// 是，否
	public static final String C_COMMON_YES					= "000101";
	public static final String C_COMMON_NO					= "000102";
	public static final String[] C_COMMON_YESNO				= new String[]{C_COMMON_YES,C_COMMON_NO};

	// 用户类型
	public static final String C_UCENTER_USER_TYPE_CUSTOM	= "010101";
	public static final String C_UCENTER_USER_TYPE_ADMIN	= "010102";
	public static final String[] C_UCENTER_USER_TYPE 		= new String[]{C_UCENTER_USER_TYPE_CUSTOM,C_UCENTER_USER_TYPE_ADMIN};
	
	// 项目类型
	public static final String C_PRO_TYPE_JAVASE			= "020101";
	public static final String C_PRO_TYPE_JAVAEE			= "020102";
	public static final String[] C_PRO_TYPE 				= new String[]{C_PRO_TYPE_JAVASE,C_PRO_TYPE_JAVAEE};
	
	/**
	 * 返回一个路径的绝对路径
	 * @param url
	 * @return
	 */
	public static final String BASE_URL = QJfinalConfig.config.getProperty("baseUrl");
	public static String url(String url){
		return BASE_URL + url;
	}
	
}
