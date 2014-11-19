package com.uikoo9.manage.ac.controller;

import com.uikoo9.manage.ac.model.AcAccountModel;
import com.uikoo9.manage.ac.model.AcDetailModel;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * AcAccountController
 * @author qiaowenbin
 */
@QControllerUrl("/ac/account")
public class AcAccountController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(AcAccountModel.class));
		render("/WEB-INF/view/manage/ac/ac-account-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(AcAccountModel.class));
		
		render("/WEB-INF/view/manage/ac/ac-account-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(AcAccountModel.class);
			if(QJson.TYPE_BS_SUCC.equals(json.getType())){
				AcAccountModel.dao.reloadAllToCache();
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
		renderJson(del(AcAccountModel.class, AcDetailModel.class, "account_id"));
	}
	
}
