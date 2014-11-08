package com.uikoo9.common.controller;

import com.uikoo9.common.service.LoginService;
import com.uikoo9.util.crud.QJson;
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
	 * 跳转到md5首页
	 */
	public void login(){
		setAttr("username", getPara("username"));
		renderJson(new QJson(LoginService.getInstance().login(getParaMap(), getSession(true))));
	}
	
	/**
	 * 退出登录
	 */
	public void logout(){
		removeSessionAttr("user");
		redirect(QJfinalUtil.url("/"));
	}
	
}
