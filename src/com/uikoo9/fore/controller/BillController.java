package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.fore.service.BillService;
import com.uikoo9.manage.bill.model.BillAccountModel;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/bill")
public class BillController extends Controller{
	
	private BillService billService = BillService.getInstance();
	
	/**
	 * 跳转到记账首页
	 */
	public void index(){
		setAttr("accountList", billService.getAccountSum());
		render("/WEB-INF/view/fore/bill/bill-index.ftl");
	}
	
	/**
	 * 跳转到转账页面
	 */
	public void tozhuan(){
		setAttr("accounts", BillAccountModel.dao.findAllByCache());
		render("/WEB-INF/view/fore/bill/bill-zhuan.ftl");
	}
	
	/**
	 * 转账
	 */
	public void zhuan(){
		renderJson(billService.zhuan(getRequest()));
	}
	
	/**
	 * 跳转到账户明细页面
	 */
	public void details(){
		setAttr("accountDetails", billService.getAccountDetails());
		render("/WEB-INF/view/fore/bill/bill-details.ftl");
	}
	
	/**
	 * 跳转到账户管理页面
	 */
	public void accounts(){
		render("/WEB-INF/view/fore/bill/bill-accounts.ftl");
	}
	
}
