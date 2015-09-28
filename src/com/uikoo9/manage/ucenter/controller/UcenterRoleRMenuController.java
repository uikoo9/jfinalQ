package com.uikoo9.manage.ucenter.controller;

import com.uikoo9.manage.ucenter.model.UcenterRoleRMenuModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.z.jfinal.QController;

/**
 * UcenterRoleRMenuController
 * @author qiaowenbin
 */
@QControllerUrl("/ucenter/role/r/menu")
public class UcenterRoleRMenuController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(UcenterRoleRMenuModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-role-r-menu-index.html");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(UcenterRoleRMenuModel.class));
		render("/WEB-INF/view/manage/ucenter-role-r-menu-input.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(UcenterRoleRMenuModel.class));
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(UcenterRoleRMenuModel.class));
	}
	
}
