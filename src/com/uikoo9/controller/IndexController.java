package com.uikoo9.controller;

import com.jfinal.aop.Before;
import com.uikoo9.QContants;
import com.uikoo9.interceptor.IndexInterceptor;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

/**
 * 用户中心-首页controller
 * @author uikoo9
 */
@QActionMap(QContants.U_BASE)
@Before(IndexInterceptor.class)
public class IndexController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render(QContants.P_HOME);
	}
	
	/**
	 * 未登录跳转
	 */
	public void home(){
		render(QContants.P_HOME);
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void manage(){
		render(QContants.P_MANAGE);
	}
	
}
