package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QJfinalUtil;

/**
 * 首页跳转controller
 * @author uikoo9
 */
@QActionMap("/menu")
public class UcenterMenuController extends Controller{
	
	private final String tableName = "ucenter_menu";
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", QJfinalUtil.list(getParaMap(), tableName));
		render("/WEB-INF/view/menu-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", QJfinalUtil.get(getPara("id"), tableName));
		render("/WEB-INF/view/menu-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(new QJson(QJfinalUtil.save(getParaMap(), tableName)));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(new QJson(QJfinalUtil.del(getPara("ids"), tableName)));
	}
	
}
