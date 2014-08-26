package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.spring.Inject;
import com.uikoo9.service.ProMd5ServiceI;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * project md5 controller
 * @author uikoo9
 */
@QActionMap("/pro/md5")
public class ProMd5Controller extends Controller{
	
	@Inject.BY_TYPE
	private ProMd5ServiceI proMd5Service;
	
	/**
	 * 跳转到md5首页
	 */
	public void index(){
		render("/WEB-INF/view/pro-md5.ftl");
	}
	
	/**
	 * 将code md5加密
	 * @throws InterruptedException 
	 */
	public void encode(){
		renderJson(new QJson(proMd5Service.encode(getPara("code"))));
	}
	
}
