package com.uikoo9.fore.controller;

import com.uikoo9.fore.service.AccountService;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/ac")
public class AccountController extends QController{
	
	/**
	 * 跳转到记账首页
	 */
	public void index(){
		setAttr("accountList", AccountService.getInstance().getAccountSum());
		render("/WEB-INF/view/fore/account-index.ftl");
	}
	
	public void details(){
		setAttr("accountDetails", AccountService.getInstance().getAccountDetails());
		render("/WEB-INF/view/fore/account-details.ftl");
	}
	
}
