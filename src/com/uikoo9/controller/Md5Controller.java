package com.uikoo9.controller;

import com.jfinal.plugin.spring.Inject;
import com.uikoo9.QContants;
import com.uikoo9.service.Md5ServiceI;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

/**
 * project md5 controller
 * @author uikoo9
 */
@QActionMap(QContants.U_MD5)
public class Md5Controller extends QController{
	
	@Inject.BY_TYPE
	private Md5ServiceI md5Service;
	
	/**
	 * 跳转到md5首页
	 */
	public void index(){
		render(QContants.P_MD5);
	}
	
	/**
	 * 将code md5加密
	 * @throws InterruptedException 
	 */
	public void encode(){
		renderJson(new QJson(md5Service.encode(getPara(QContants.C_CODE))));
	}
	
}
