package com.uikoo9.manage.ac.controller;

import com.uikoo9.manage.ac.model.AcAccountModel;
import com.uikoo9.manage.ac.model.AcDetailModel;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * AcDetailController
 * @author qiaowenbin
 */
@QControllerUrl("/ac/detail")
public class AcDetailController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", listBySql(getParaMap(), " (select ad.*,aa.account_name aname from t_ac_detail ad, t_ac_account aa where ad.account_id=aa.id ) as tad ", "tad"));
		render("/WEB-INF/view/manage/ac/ac-detail-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("accounts", AcAccountModel.dao.findAllByCache());
		setAttr("row", getRow(AcDetailModel.class));
		
		render("/WEB-INF/view/manage/ac/ac-detail-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(AcDetailModel.class));
		}else{
			renderJson(new QJson(validate, QJson.TYPE_BS_DANG));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(AcDetailModel.class));
	}
	
}
