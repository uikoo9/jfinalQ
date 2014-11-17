package com.uikoo9.fore.controller;

import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.file.QCacheUtil;
import com.uikoo9.util.http.QCookieUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.util.jfinal.QLoginService;

/**
 * 用户中心-登录controller
 * @author uikoo9
 */
@QControllerUrl("/login")
public class LoginController extends QController{
	
	private QLoginService loginService = QLoginService.getInstance();
	
	/**
	 * 用户登录
	 */
	public void login(){
		renderJson(new QJson(loginService.login(getParaMap(), getResponse())));
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
	
	/**
	 * 跳转到修改密码页面
	 */
	public void modifyPwdp(){
		render("/WEB-INF/view/fore/home-modifypwd.ftl");
	}
	
	/**
	 * 修改密码
	 */
	public void modifyPwd(){
		renderJson(loginService.modifyPwd(getParaMap(), getRequest()));
	}
	
}
