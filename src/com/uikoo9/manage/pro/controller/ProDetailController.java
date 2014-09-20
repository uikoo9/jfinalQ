package com.uikoo9.manage.pro.controller;

import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.z.QContants;

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
		setAttr("qpage", list(ProDetailModel.class));
		render("/WEB-INF/view/manage/pro/pro-detail-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("protypes", QContantsUtil.list(QContants.C_PRO_TYPE));
		setAttr("row", getRow(ProDetailModel.class));
		
		render("/WEB-INF/view/manage/pro/pro-detail-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(ProDetailModel.class));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(ProDetailModel.class));
	}
	
}
