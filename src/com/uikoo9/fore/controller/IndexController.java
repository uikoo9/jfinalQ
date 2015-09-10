package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.jfinal.ucenter.model.UcenterMenuModel;

/**
 * 用户中心-首页controller
 * @author uikoo9
 */
@QControllerUrl("/")
public class IndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/fore/home/home-index.html");
	}
	
	/**
	 * 跳转到版本更新
	 */
	public void version(){
		render("/WEB-INF/view/fore/home/home-version.html");
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void manage(){
		setAttr("menus", UcenterMenuModel.dao.findAllByCache());
		render("/com/uikoo9/util/jfinal/view/common/manage.html");
	}
	
}
