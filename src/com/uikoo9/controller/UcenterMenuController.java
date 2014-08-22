package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 首页跳转controller
 * @author uikoo9
 */
@QActionMap("/menu")
public class UcenterMenuController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/menu-index.ftl");
	}
	
	/**
	 * ucenter menu list
	 */
	public void list() {
		setAttr("rows", Db.find("select * from ucenter_menu"));
		
		render("/WEB-INF/view/menu-list.ftl");
	}
	
}
