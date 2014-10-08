package com.uikoo9.manage.ucenter.controller;

import java.util.List;

import com.uikoo9.manage.ucenter.model.UcenterMenuModel;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 用户中心-菜单controller
 * @author uikoo9
 */
@QControllerUrl("/ucenter/menu")
public class UcenterMenuController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(UcenterMenuModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-menu-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(UcenterMenuModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-menu-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String res = validate();
		if(res == null){
			renderJson(save(UcenterMenuModel.class));
		}else{
			renderJson(new QJson(res, QJson.TYPE_BS_DANG));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(UcenterMenuModel.class));
	}
	
	/**
	 * 保存和修改的校验
	 * @return
	 */
	private String validate(){
		// require
		String menuText = getPara("row.menu_title");
		if(QStringUtil.isEmpty(menuText)) return "请输入菜单名称";
		
		String menuUrl = getPara("row.menu_url");
		if(QStringUtil.isEmpty(menuUrl)) return "请输入菜单地址";

		String menuSn = getPara("row.menu_sn");
		if(QStringUtil.isEmpty(menuSn)) return "请输入菜单序号";
		
		// unique
		Integer id = getParaToInt("row.id");
		if(id == null){
			List<UcenterMenuModel> menus = UcenterMenuModel.dao.find("select * from t_ucenter_menu where menu_title=?", menuText);
			if(menus != null && menus.size() > 0) return "菜单名称已经存在！";
		}else{
			List<UcenterMenuModel> menus = UcenterMenuModel.dao.find("select * from t_ucenter_menu where menu_title=? and id!=?", menuText, id);
			if(menus != null && menus.size() > 0) return "菜单名称已经存在！";
		}
		
		return null;
	}
	
}
