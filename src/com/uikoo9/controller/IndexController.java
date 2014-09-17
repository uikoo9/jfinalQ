package com.uikoo9.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.interceptor.IndexInterceptor;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 用户中心-首页controller
 * @author uikoo9
 */

@QControllerUrl("/")
@Before(IndexInterceptor.class)
public class IndexController extends QController{
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/home.ftl");
	}
	
	/**
	 * 未登录跳转
	 */
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
