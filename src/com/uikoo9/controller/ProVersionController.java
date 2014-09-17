package com.uikoo9.controller;

import com.jfinal.plugin.activerecord.Db;
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
		setAttr("qpage", list(getParaMap(), " (select pv.*,pd.pro_name pname from t_pro_version pv, t_pro_detail pd where pv.pro_id=pd.id ) as pdv "));
		render("/WEB-INF/view/pro-version-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("pros", Db.find("select * from t_pro_detail"));
		setAttr("row", get(getPara("id"), "t_pro_version"));
		render("/WEB-INF/view/pro-version-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(getParaMap(), "t_pro_version"));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(getPara("id"), "t_pro_version"));
	}
	
}
