package com.uikoo9.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.QContants;
import com.uikoo9.interceptor.IndexInterceptor;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

@QActionMap(QContants.U_PROJECT)
@Before(IndexInterceptor.class)
public class ProjectController extends QController{
	
	public void index(){
		String type = getPara(0);
		if(QStringUtil.isIn(type, QContants.C_PRO_TYPE)){
			setAttr("details", Db.find("select * from pro_detail where pro_type=?", type));
			render(QContants.P_PROJECT);
		}else{
			redirect(QContants.url(QContants.U_BASE));
		}
	}
	
}
