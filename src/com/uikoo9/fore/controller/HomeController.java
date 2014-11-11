package com.uikoo9.fore.controller;

import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/home")
public class HomeController extends QController{
	
	/**
	 * 未登录跳转
	 */
	public void index(){
		render("/WEB-INF/view/fore/home-index.ftl");
	}
	
	/**
	 * 跳转到项目展示页面
	 */
	public void project(){
		try {
			Integer id = getParaToInt(0);
			if(id != null){
				ProDetailModel detail = ProDetailModel.dao.findById(id); 
				if(detail != null){
					setAttr("detail", detail);	
					render("/WEB-INF/view/fore/home-project.ftl");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		redirect("/home");
	}
	
	/**
	 * 跳转到版本更新
	 */
	public void version(){
		render("/WEB-INF/view/fore/home-version.ftl");
	}
	
}
