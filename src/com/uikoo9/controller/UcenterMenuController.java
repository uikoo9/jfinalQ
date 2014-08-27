package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.uikoo9.QContants;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QJfinalUtil;

/**
 * 用户中心-菜单controller
 * @author uikoo9
 */
@QActionMap(QContants.U_UCENTER_MENU)
public class UcenterMenuController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr(QContants.C_QPAGE, QJfinalUtil.list(getParaMap(), QContants.SQL_UCENTER_MENU));
		render(QContants.P_UCENTER_MENU_INDEX);
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr(QContants.C_ROW, QJfinalUtil.get(getPara(QContants.C_ID), QContants.SQL_UCENTER_MENU));
		render(QContants.P_UCENTER_MENU_INPUT);
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(new QJson(QJfinalUtil.save(getParaMap(), QContants.SQL_UCENTER_MENU)));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(new QJson(QJfinalUtil.del(getPara(QContants.C_IDS), QContants.SQL_UCENTER_MENU)));
	}
	
}
