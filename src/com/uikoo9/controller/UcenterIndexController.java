package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 首页跳转controller
 * @author uikoo9
 */
@QActionMap("/")
public class UcenterIndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/pro-index.ftl");
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void man(){
		render("/WEB-INF/view/man-index.ftl");
	}
	
}
