package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/home")
public class HomeController extends Controller{
	
	/**
	 * 未登录跳转
	 */
	public void index(){
		render("/WEB-INF/view/fore/home/home-index.ftl");
	}
	
	/**
	 * 跳转到项目展示页面
	 */
	public void project(){
		setAttr("proDetails", ProDetailModel.dao.findAllByCache());
		render("/WEB-INF/view/fore/home/home-project.ftl");
	}
	
	/**
	 * 跳转到版本更新
	 */
	public void version(){
		render("/WEB-INF/view/fore/home/home-version.ftl");
	}
	
}
