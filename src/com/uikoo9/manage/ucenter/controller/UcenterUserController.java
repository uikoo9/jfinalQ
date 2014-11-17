package com.uikoo9.manage.ucenter.controller;

import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.file.QEncodeUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.z.QContants;

/**
 * 用户中心-用户controller
 * @author uikoo9
 */
@QControllerUrl("/ucenter/user")
public class UcenterUserController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(UcenterUserModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-user-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("usertypes", QContantsUtil.list(QContants.C_UCENTER_USER_TYPE));
		
		setAttr("row", getRow(UcenterUserModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-user-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(UcenterUserModel.class));
		}else{
			renderJson(new QJson(validate, QJson.TYPE_BS_DANG));
		}
	}
	
	/* (non-Javadoc)
	 * @see com.uikoo9.util.jfinal.QController#initRecord(com.jfinal.plugin.activerecord.Record)
	 */
	public Record initRecord(Record record){
		String pwd = record.getStr("user_key");
		try {
			record.set("user_key", QEncodeUtil.md5Encrypt(pwd));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(UcenterUserModel.class));
	}
	
}
