package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.QFileUtil;

/**
 * 首页跳转controller
 * @author uikoo9
 */
public class UcenterIndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/pro-md5.ftl");
	}
	
	public void test(){
		setAttr("test", QFileUtil.getJarPath());
		
		QFileUtil.getAllFiles(QFileUtil.getJarPath().split("classes")[0] + "classes");
		setAttr("files", QFileUtil.fileList);
		
		render("/WEB-INF/view/test.ftl");
	}
	
}
