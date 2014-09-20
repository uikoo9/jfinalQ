package com.uikoo9.common.controller;

import com.jfinal.aop.Before;
import com.uikoo9.manage.ucenter.model.UcenterMenuModel;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.z.interceptor.ProDetailsInterceptor;
import com.uikoo9.z.interceptor.ProMenusInterceptor;

/**
 * 用户中心-首页controller
 * @author uikoo9
 */
@QControllerUrl("/")
public class IndexController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	@Before({ProMenusInterceptor.class,ProDetailsInterceptor.class})
	public void index(){
		render("/WEB-INF/view/fore/home.ftl");
	}
	
	/**
	 * 未登录跳转
	 */
	@Before({ProMenusInterceptor.class,ProDetailsInterceptor.class})
	public void home(){
		render("/WEB-INF/view/fore/home.ftl");
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void manage(){
		setAttr("menus", UcenterMenuModel.dao.findAll());
		render("/WEB-INF/view/manage/manage.ftl");
	}
	
}
