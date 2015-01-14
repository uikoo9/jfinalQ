package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.fore.service.BillService;
import com.uikoo9.manage.bill.model.BillAccountModel;
import com.uikoo9.util.core.annotation.QControllerUrl;

@QControllerUrl("/bill")
public class BillController extends Controller{
	
	private BillService billService = BillService.getInstance();
	
	/**
	 * 跳转到记账首页
	 */
	public void index(){
		setAttr("msgcount", countMsg());
		
		setAttr("accountList", billService.getAccountSum());
		render("/WEB-INF/view/fore/bill/bill-index.ftl");
	}
	private Long countMsg(){
		String sql = "select count(*) from t_blog_comment t1 where t1.blog_comment_parent_id=0 and not exists(select 1 from t_blog_comment t2 where t2.blog_comment_parent_id=t1.id)";
		return Db.queryLong(sql);
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
	
}
