package com.uikoo9.manage.pro.controller;

import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.pro.model.ProVersionModel;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 项目明细controller
 * @author uikoo9
 */
@QControllerUrl("/pro/version")
public class ProVersionController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", listBySql(getParaMap(), " (select pv.*,pd.pro_name pname from t_pro_version pv, t_pro_detail pd where pv.pro_detail_id=pd.id ) as pdv ", "pdv"));
		render("/WEB-INF/view/pro-version-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("pros", Db.find("select * from t_pro_detail"));
		setAttr("row", getRow(ProVersionModel.class));
		
		render("/WEB-INF/view/pro-version-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(ProVersionModel.class));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(ProVersionModel.class));
	}
	
}
