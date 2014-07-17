package com.uikoo9.controller;

import com.jfinal.core.Controller;

/**
 * 首页跳转controller
 * @author uikoo9
 */
public class UcenterIndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/pro-md5.ftl");
	}
	
}
