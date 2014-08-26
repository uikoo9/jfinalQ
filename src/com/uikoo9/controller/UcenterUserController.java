package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QJfinalUtil;

/**
 * 用户中心-用户controller
 * @author uikoo9
 */
@QActionMap("/ucenter/user")
public class UcenterUserController extends Controller{
	
	private final String tableName = "ucenter_user";
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", QJfinalUtil.list(getParaMap(), tableName));
		render("/WEB-INF/view/ucenter-user-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", QJfinalUtil.get(getPara("id"), tableName));
		render("/WEB-INF/view/ucenter-user-input.ftl");
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
