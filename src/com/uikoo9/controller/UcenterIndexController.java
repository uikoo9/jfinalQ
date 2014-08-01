package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.spring.Inject;
import com.uikoo9.service.TestServiceI;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 首页跳转controller
 * @author uikoo9
 */
@QActionMap("/")
public class UcenterIndexController extends Controller{
	
	@Inject.BY_TYPE
	private TestServiceI testService;
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/pro-md5.ftl");
	}
	
	public void test(){
		setAttr("test", testService.test());
		
		render("/WEB-INF/view/test.ftl");
	}
	
}
