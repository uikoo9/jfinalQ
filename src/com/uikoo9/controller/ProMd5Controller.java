package com.uikoo9.controller;

import com.jfinal.plugin.spring.Inject;
import com.uikoo9.QContants;
import com.uikoo9.service.ProMd5ServiceI;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

/**
 * project md5 controller
 * @author uikoo9
 */
@QActionMap(QContants.U_PRO_MD5)
public class ProMd5Controller extends QController{
	
	@Inject.BY_TYPE
	private ProMd5ServiceI proMd5Service;
	
	/**
	 * 跳转到md5首页
	 */
	public void index(){
		render(QContants.P_PRO_MD5_INDEX);
	}
	
	/**
	 * 将code md5加密
	 * @throws InterruptedException 
	 */
	public void encode(){
		renderJson(new QJson(proMd5Service.encode(getPara(QContants.C_CODE))));
	}
	
}
