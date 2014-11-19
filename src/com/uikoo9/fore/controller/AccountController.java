package com.uikoo9.fore.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.uikoo9.fore.service.AccountService;
import com.uikoo9.manage.ac.model.AcAccountModel;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/ac")
public class AccountController extends QController{
	
	private AccountService accountService = AccountService.getInstance();
	
	/**
	 * 跳转到记账首页
	 */
	public void index(){
		setAttr("accountList", accountService.getAccountSum());
		render("/WEB-INF/view/fore/account-index.ftl");
	}
	
	/**
	 * 跳转到转账页面
	 */
	public void tozhuan(){
		setAttr("accounts", AcAccountModel.dao.findAllByCache());
		render("/WEB-INF/view/fore/account-zhuan.ftl");
	}
	
	/**
	 * 转账
	 */
	@Before(Tx.class) 
	public void zhuan(){
		renderJson(accountService.zhuan(getRequest()));
	}
	
	/**
	 * 跳转到账户明细页面
	 */
	public void details(){
		setAttr("accountDetails", accountService.getAccountDetails());
		render("/WEB-INF/view/fore/account-details.ftl");
	}
	
	/**
	 * 跳转到账户管理页面
	 */
	public void accounts(){
		render("/WEB-INF/view/fore/account-accounts.ftl");
	}
	
}
