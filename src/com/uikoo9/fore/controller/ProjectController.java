package com.uikoo9.fore.controller;

import com.jfinal.aop.Before;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.util.jfinal.QJfinalUtil;
import com.uikoo9.z.interceptor.ProMenusInterceptor;

@QControllerUrl("/project")
public class ProjectController extends QController{
	
	@Before(ProMenusInterceptor.class)
	public void index(){
		Integer id = getParaToInt(0);
		if(id != null){
			ProDetailModel detail = ProDetailModel.dao.findById(id); 
			if(detail != null){
				setAttr("detail", detail);	
				render("/WEB-INF/view/project.ftl");
				return;
			}
		}
		
		redirect(QJfinalUtil.url("/"));
	}
	
}
