package com.uikoo9.common.controller;

import com.uikoo9.common.service.LoginService;
import com.uikoo9.util.QCacheUtil;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.http.QCookieUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.util.jfinal.QJfinalUtil;

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
		String method = getRequest().getMethod();
		if("GET".equals(method)){
			render("/WEB-INF/view/fore/home-login.ftl");
		}else{
			setAttr("username", getPara("username"));
			
			String res = LoginService.getInstance().login(getParaMap(), getResponse());
			if("suc".equals(res)){
				redirect(QJfinalUtil.url("/manage"));
			}else{
				setAttr("errorMsg", res);
				render("/WEB-INF/view/fore/home-login.ftl");
			}
		}
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
		
		redirect(QJfinalUtil.url("/"));
	}
	
}
