package com.uikoo9.controller;

import com.uikoo9.QContants;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QActionMap;
import com.uikoo9.util.jfinal.QController;

@QActionMap(QContants.U_PROJECT)
public class ProjectController extends QController{
	
	public void index(){
		String type = getPara(0);
		if(QStringUtil.isIn(type, QContants.C_PRO_TYPE)){
			
		}else{
			redirect(QContants.url(QContants.U_BASE));
		}
	}
	
}
