package com.uikoo9.controller;

import com.uikoo9.model.UcenterUserModel;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

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
		render("/WEB-INF/view/ucenter-user-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(UcenterUserModel.class));
		render("/WEB-INF/view/ucenter-user-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(UcenterUserModel.class));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(UcenterUserModel.class));
	}
	
}
