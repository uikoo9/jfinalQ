package com.uikoo9.fore.controller;

import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/ac")
public class AccountController extends QController{
	
	/**
	 * 跳转到记账首页
	 */
	public void index(){
		render("/WEB-INF/view/fore/account-index.ftl");
	}
}
