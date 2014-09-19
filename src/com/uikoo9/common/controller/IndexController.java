package com.uikoo9.common.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
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
	@Before(ProMenusInterceptor.class)
	public void index(){
		render("/WEB-INF/view/home.ftl");
	}
	
	/**
	 * 未登录跳转
	 */
	@Before(ProMenusInterceptor.class)
	public void home(){
		render("/WEB-INF/view/home.ftl");
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void manage(){
		setAttr("menus", Db.find("select * from t_ucenter_menu"));
		render("/WEB-INF/view/manage.ftl");
	}
	
}
