package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.fore.service.AccountService;
import com.uikoo9.manage.ac.model.BillAccountModel;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/ac")
public class AccountController extends Controller{
	
	private AccountService accountService = AccountService.getInstance();
	
	/**
	 * 跳转到记账首页
	 */
	public void index(){
		setAttr("accountList", accountService.getAccountSum());
		render("/WEB-INF/view/fore/account/account-index.ftl");
	}
	
	/**
	 * 跳转到转账页面
	 */
	public void tozhuan(){
		setAttr("accounts", BillAccountModel.dao.findAllByCache());
		render("/WEB-INF/view/fore/account/account-zhuan.ftl");
	}
	
	/**
	 * 转账
	 */
	public void zhuan(){
		renderJson(accountService.zhuan(getRequest()));
	}
	
	/**
	 * 跳转到账户明细页面
	 */
	public void details(){
		setAttr("accountDetails", accountService.getAccountDetails());
		render("/WEB-INF/view/fore/account/account-details.ftl");
	}
	
	/**
	 * 跳转到账户管理页面
	 */
	public void accounts(){
		render("/WEB-INF/view/fore/account/account-accounts.ftl");
	}
	
}
