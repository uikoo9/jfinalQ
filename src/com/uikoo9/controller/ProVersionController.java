package com.uikoo9.controller;

import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.QContants;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

/**
 * 项目明细controller
 * @author uikoo9
 */
@QActionMap(QContants.U_PRO_VERSION)
public class ProVersionController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr(QContants.V_QPAGE, list(getParaMap(), QContants.SQL_PRO_VERSION_WITH_PRO));
		render(QContants.P_PRO_VERSION_INDEX);
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr(QContants.V_PROS, Db.find(QContants.SQL_PRO_DETAIL_ALL));
		setAttr(QContants.V_ROW, get(getPara(QContants.V_ID), QContants.TABLE_PRO_VERSION));
		render(QContants.P_PRO_VERSION_INPUT);
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(getParaMap(), QContants.TABLE_PRO_VERSION));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(getPara(QContants.V_IDS), QContants.TABLE_PRO_VERSION));
	}
	
}
