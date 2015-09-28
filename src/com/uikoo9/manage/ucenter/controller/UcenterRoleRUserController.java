package com.uikoo9.manage.ucenter.controller;

import com.uikoo9.manage.ucenter.model.UcenterRoleRUserModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.z.jfinal.QController;

/**
 * UcenterRoleRUserController
 * @author qiaowenbin
 */
@QControllerUrl("/ucenter/role/r/user")
public class UcenterRoleRUserController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(UcenterRoleRUserModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-role-r-user-index.html");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(UcenterRoleRUserModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-role-r-user-input.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(UcenterRoleRUserModel.class));
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(UcenterRoleRUserModel.class));
	}
	
}
