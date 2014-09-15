package com.uikoo9.controller;

import com.uikoo9.QContants;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

/**
 * 项目明细controller
 * @author uikoo9
 */
@QActionMap(QContants.U_PRO_DETAIL)
public class ProDetailController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr(QContants.V_QPAGE, list(getParaMap(), QContants.TABLE_PRO_DETAIL));
		render(QContants.P_PRO_DETAIL_INDEX);
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr(QContants.V_PROTYPES, QContantsUtil.list(QContants.C_PRO_TYPE));
		setAttr(QContants.V_ROW, get(getPara(QContants.V_ID), QContants.TABLE_PRO_DETAIL));
		render(QContants.P_PRO_DETAIL_INPUT);
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		renderJson(save(getParaMap(), QContants.TABLE_PRO_DETAIL));
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(getPara(QContants.V_IDS), QContants.TABLE_PRO_DETAIL));
	}
	
}
