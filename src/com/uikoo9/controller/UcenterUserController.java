package com.uikoo9.controller;

import com.uikoo9.model.UcenterUserModel;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 用户中心-用户controller
 * @author uikoo9
 */
@QControllerUrl("/ucenter/user")
public class UcenterUserController extends BaseController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		test(UcenterUserModel.class);
		setAttr("qpage", list(getParaMap(), "t_ucenter_user"));
		render("/WEB-INF/view/ucenter-user-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", get(getPara("id"), "t_ucenter_user"));
		render("/WEB-INF/view/ucenter-user-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(getParaMap(), "t_ucenter_user"));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(getPara("id"), "t_ucenter_user"));
	}
	
}
