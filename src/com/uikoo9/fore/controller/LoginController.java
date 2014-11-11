package com.uikoo9.fore.controller;

import com.uikoo9.fore.service.LoginService;
import com.uikoo9.util.QCacheUtil;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.http.QCookieUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 用户中心-登录controller
 * @author uikoo9
 */
@QControllerUrl("/login")
public class LoginController extends QController{
	
	/**
	 * 用户登录
	 */
	public void login(){
		String res = LoginService.getInstance().login(getParaMap(), getResponse());
		renderJson(new QJson(res));
	}
	
	/**
	 * 退出登录
	 */
	public void logout(){
		String cookieUserId = QCookieUtil.getValue(getRequest(), "uikoo9userid");
		if(QStringUtil.notEmpty(cookieUserId)){
			QCacheUtil.removeEHCache(cookieUserId);
			QCookieUtil.removeCookie(getResponse(), "uikoo9userid");
		}
		
		redirect("/home");
	}
	
}
