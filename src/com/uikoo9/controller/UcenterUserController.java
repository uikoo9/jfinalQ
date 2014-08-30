package com.uikoo9.controller;

import com.uikoo9.QContants;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

/**
 * 用户中心-用户controller
 * @author uikoo9
 */
@QActionMap(QContants.U_UCENTER_USER)
public class UcenterUserController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr(QContants.C_QPAGE, list(getParaMap(), QContants.SQL_UCENTER_USER));
		render(QContants.P_UCENTER_USER_INDEX);
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr(QContants.C_ROW, get(getPara(QContants.C_ID), QContants.SQL_UCENTER_USER));
		render(QContants.P_UCENTER_USER_INPUT);
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(new QJson(save(getParaMap(), QContants.SQL_UCENTER_USER)));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(new QJson(del(getPara(QContants.C_IDS), QContants.SQL_UCENTER_USER)));
	}
	
}
