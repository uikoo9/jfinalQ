package com.uikoo9.controller;

import com.jfinal.plugin.spring.Inject;
import com.uikoo9.QContants;
import com.uikoo9.service.LoginServiceI;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

/**
 * 用户中心-登录controller
 * @author uikoo9
 */
@QActionMap(QContants.U_LOGIN)
public class LoginController extends QController{
	
	@Inject.BY_TYPE
	private LoginServiceI loginService;
	
	/**
	 * 跳转到md5首页
	 */
	public void login(){
		setAttr(QContants.C_USERNAME, getPara(QContants.C_USERNAME));
		renderJson(new QJson(loginService.login(getParaMap(), getSession(true))));
	}
	
	/**
	 * 退出登录
	 */
	public void logout(){
		removeSessionAttr(QContants.C_USER);
		redirect(QContants.url(QContants.U_BASE));
	}
	
}
