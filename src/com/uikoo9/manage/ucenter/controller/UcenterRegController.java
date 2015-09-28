package com.uikoo9.manage.ucenter.controller;

import com.jfinal.aop.Duang;
import com.uikoo9.manage.ucenter.service.RegService;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.z.jfinal.QController;

/**
 * 用户中心-登录controller
 * @author uikoo9
 */
@QControllerUrl("/reg")
public class UcenterRegController extends QController{
	
	private RegService regService = Duang.duang(RegService.class);
	
	/**
	 * 跳转到注册页面
	 */
	public void index(){
		render("/WEB-INF/view/manage/ucenter/ucenter-reg.html");
	}

	/**
	 * 用户注册
	 */
	public void reg(){
		renderJson(regService.reg(getParaMap()));
	}
	
	/**
	 * 滴石用户注册确认
	 */
	public void regConfirm(){
		setAttr("regMsg", regService.regConfirm(getParaMap()));
		render("/WEB-INF/view/manage/ucenter/ucenter-reg-confirm.html");
	}
	
}
