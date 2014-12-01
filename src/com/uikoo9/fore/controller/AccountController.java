package com.uikoo9.fore.controller;

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
	
	/**
	 * 跳转到写日记页面
	 */
	public void toDiaryAdd(){
		render("/WEB-INF/view/fore/diary-add.ftl");
	}
	
	/**
	 * 跳转到看日记页面
	 */
	public void toDiaryList(){
		render("/WEB-INF/view/fore/diary-list.ftl");
	}
	
	/**
	 * 跳转到日记详情页面
	 */
	public void toDiaryDetail(){
		render("/WEB-INF/view/fore/diary-detail.ftl");
	}
	
}
