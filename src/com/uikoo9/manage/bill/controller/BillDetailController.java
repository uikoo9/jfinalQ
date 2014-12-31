package com.uikoo9.manage.bill.controller;

import com.uikoo9.manage.bill.model.BillAccountModel;
import com.uikoo9.manage.bill.model.BillDetailModel;
import com.uikoo9.util.crud.QJsonUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * AcDetailController
 * @author qiaowenbin
 */
@QControllerUrl("/bill/detail")
public class BillDetailController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", listBySql(getParaMap(), " (select ad.*,aa.bill_account_name aname from t_bill_detail ad, t_bill_account aa where ad.bill_account_id=aa.id ) as tad ", "tad"));
		render("/WEB-INF/view/manage/bill/bill-detail-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("accounts", BillAccountModel.dao.findAllByCache());
		
		setAttr("row", getRow(BillDetailModel.class));
		
		render("/WEB-INF/view/manage/bill/bill-detail-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(BillDetailModel.class));
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(BillDetailModel.class));
	}
	
}
