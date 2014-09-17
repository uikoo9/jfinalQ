package com.uikoo9.controller;

import com.jfinal.plugin.spring.Inject;
import com.uikoo9.service.Md5ServiceI;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * project md5 controller
 * @author uikoo9
 */
@QControllerUrl("/md5")
public class Md5Controller extends QController{
	
	@Inject.BY_TYPE
	private Md5ServiceI md5Service;
	
	/**
	 * 跳转到md5首页
	 */
	public void index(){
		render("/WEB-INF/view/md5.ftl");
	}
	
	/**
	 * 将code md5加密
	 * @throws InterruptedException 
	 */
	public void encode(){
		renderJson(new QJson(md5Service.encode(getPara("code"))));
	}
	
}
