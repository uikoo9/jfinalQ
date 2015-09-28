package com.uikoo9.manage.ucenter.controller;

import com.jfinal.aop.Duang;
import com.uikoo9.manage.ucenter.service.LoginService;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.z.jfinal.QController;

/**
 * 用户中心-登录controller
 * @author uikoo9
 */
@QControllerUrl("/login")
public class UcenterLoginController extends QController{
	
	private LoginService loginService = Duang.duang(LoginService.class);
	
	/**
	 * 跳转到登录页面
	 */
	public void index(){
		render("/WEB-INF/view/manage/ucenter/ucenter-login.html");
	}
	
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
		String rurl = loginService.logout(getRequest(), getResponse());
		if(QStringUtil.isEmpty(rurl) || !"/dishi".equals(rurl)){
			redirect("/");
		}else{
			redirect("/dishi");
		}
	}
	
	/**
	 * 跳转到修改密码页面
	 */
	public void modifyPwdp(){
		render("/WEB-INF/view/manage/ucenter/ucenter-user-modifypwd.html");
	}
	
	/**
	 * 修改密码
	 */
	public void modifyPwd(){
		renderJson(loginService.modifyPwd(getParaMap(), getRequest()));
	}
	
	/**
	 * 跳转到修改密码页面
	 */
	public void modifyNicknamep(){
		render("/WEB-INF/view/manage/ucenter/ucenter-user-modifynickname.html");
	}
	
	/**
	 * 修改密码
	 */
	public void modifyNickname(){
		renderJson(loginService.modifyNickname(getParaMap(), getRequest()));
	}
	
}
