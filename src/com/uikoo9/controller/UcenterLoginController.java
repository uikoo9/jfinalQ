package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.spring.Inject;
import com.uikoo9.service.UcenterLoginServiceI;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 用户中心-登录controller
 * @author uikoo9
 */
@QActionMap("/ucenter/login")
public class UcenterLoginController extends Controller{
	
	@Inject.BY_TYPE
	private UcenterLoginServiceI ucenterLoginService;
	
	/**
	 * 跳转到md5首页
	 */
	public void login(){
		setAttr("username", getPara("username"));
		
		String errorMsg = ucenterLoginService.login(getParaMap(), getSession(true));
		if(errorMsg == null){
			setSessionAttr("user", "1");
			System.out.println(getSessionAttr("user"));
			redirect("/ucenter");
		}else{
			setAttr("errorMsg", errorMsg);
			render("/WEB-INF/view/pro-index.ftl");
		}
	}
	
}
