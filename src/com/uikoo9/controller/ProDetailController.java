package com.uikoo9.controller;

import com.uikoo9.QContants;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 项目明细controller
 * @author uikoo9
 */
@QControllerUrl("/pro/detail")
public class ProDetailController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(getParaMap(), "t_pro_detail"));
		render("/WEB-INF/view/pro-detail-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("protypes", QContantsUtil.list(QContants.C_PRO_TYPE));
		setAttr("row", get(getPara("id"), "t_pro_detail"));
		render("/WEB-INF/view/pro-detail-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(getParaMap(), "t_pro_detail"));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(getPara("id"), "t_pro_detail"));
	}
	
}
