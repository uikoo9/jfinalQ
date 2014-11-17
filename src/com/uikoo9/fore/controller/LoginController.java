package com.uikoo9.fore.controller;

import com.uikoo9.manage.service.LoginService;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 用户中心-登录controller
 * @author uikoo9
 */
@QControllerUrl("/login")
public class LoginController extends QController{
	
	private LoginService loginService = LoginService.getInstance();
	
	/**
	 * 用户登录
	 */
	public void login(){
		renderJson(loginService.login(getParaMap(), getResponse()));
	}
	
	/**
	 * 退出登录
	 */
	public void logout(){
		loginService.logout(getRequest(), getResponse());
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
