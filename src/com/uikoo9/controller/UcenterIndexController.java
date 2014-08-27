package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.QContants;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 用户中心-首页controller
 * @author uikoo9
 */
@QActionMap(QContants.U_BASE)
public class UcenterIndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render(QContants.P_PRO_INDEX);
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void ucenter(){
		setAttr(QContants.C_MENUS, Db.find(QContants.SQL_UCENTER_MENU_ALL));
		render(QContants.P_UCENTER_INDEX);
	}
	
}
