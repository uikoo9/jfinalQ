package com.uikoo9.fore.controller;

import com.jfinal.aop.Before;
import com.uikoo9.QContants;
import com.uikoo9.common.interceptor.IndexInterceptor;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.util.jfinal.QJfinalUtil;

@QControllerUrl("/project")
@Before(IndexInterceptor.class)
public class ProjectController extends QController{
	
	public void index(){
		String type = getPara(0);
		if(QStringUtil.isIn(type, QContants.C_PRO_TYPE)){
			setAttr("details", ProDetailModel.dao.find("select * from t_pro_detail where pro_type=?", type));
			render("/WEB-INF/view/project.ftl");
		}else{
			redirect(QJfinalUtil.url("/"));
		}
	}
	
}
