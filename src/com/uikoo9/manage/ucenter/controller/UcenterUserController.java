package com.uikoo9.manage.ucenter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.function.QEncodeUtil;
import com.uikoo9.util.plugin.contants.QContantsUtil;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.z.QContants;
import com.uikoo9.z.jfinal.QController;

/**
 * 用户中心-用户controller
 * @author uikoo9
 */
@QControllerUrl("/ucenter/user")
public class UcenterUserController extends QController{
	
	private static final Logger logger = LoggerFactory.getLogger(UcenterUserController.class);
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(UcenterUserModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-user-index.html");
	}
	
	/**
	 * 跳转到搜索页 
	 */
	public void search(){
		setAttr("yesnos", QContantsUtil.list(QContants.YESNO));
		setAttr("usertypes", QContantsUtil.list(QContants.USER_TYPE));
		
		render("/WEB-INF/view/manage/ucenter/ucenter-user-search.html");
	}

	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("yesnos", QContantsUtil.list(QContants.YESNO));
		setAttr("usertypes", QContantsUtil.list(QContants.USER_TYPE));
		
		setAttr("row", getRow(UcenterUserModel.class));
		
		render("/WEB-INF/view/manage/ucenter/ucenter-user-input.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(UcenterUserModel.class));
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/* (non-Javadoc)
	 * @see com.uikoo9.util.jfinal.QController#initRecord(com.jfinal.plugin.activerecord.Record)
	 */
	public Record initRecord(Record record){
		String pwd = record.getStr("ucenter_user_key");
		try {
			record.set("ucenter_user_key", QEncodeUtil.md5Encrypt(pwd));
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
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
