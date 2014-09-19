package com.uikoo9.common.controller;

import com.jfinal.plugin.spring.Inject;
import com.uikoo9.common.service.LoginServiceI;
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
	
	@Inject.BY_TYPE
	private LoginServiceI loginService;
	
	/**
	 * 跳转到md5首页
	 */
	public void login(){
		setAttr("username", getPara("username"));
		renderJson(new QJson(loginService.login(getParaMap(), getSession(true))));
	}
	
	/**
	 * 退出登录
	 */
	public void logout(){
		removeSessionAttr("user");
		redirect(QJfinalUtil.url("/"));
	}
	
}
