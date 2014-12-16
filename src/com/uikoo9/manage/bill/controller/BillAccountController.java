package com.uikoo9.manage.bill.controller;

import com.uikoo9.manage.bill.model.BillAccountModel;
import com.uikoo9.manage.bill.model.BillDetailModel;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.file.QCacheUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * AcAccountController
 * @author qiaowenbin
 */
@QControllerUrl("/bill/account")
public class BillAccountController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(BillAccountModel.class));
		render("/WEB-INF/view/manage/bill/bill-account-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(BillAccountModel.class));
		render("/WEB-INF/view/manage/bill/bill-account-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(BillAccountModel.class);
			if(QJson.TYPE_BS_SUCC.equals(json.getType())){
				QCacheUtil.putToEHCache("accounts", BillAccountModel.dao.findAll("order by bill_account_name"));
			}
			
			renderJson(json);
		}else{
			renderJson(new QJson(validate, QJson.TYPE_BS_DANG));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		QJson json = del(BillAccountModel.class, BillDetailModel.class, "bill_account_id");
		if(QJson.TYPE_BS_SUCC.equals(json.getType())){
			QCacheUtil.putToEHCache("accounts", BillAccountModel.dao.findAll("order by bill_account_name"));
		}
		
		renderJson(json);
	}
	
}
