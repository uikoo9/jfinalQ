package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.manage.project.model.ProjectDetailModel;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.util.ucenter.model.UcenterMenuModel;

/**
 * 用户中心-首页controller
 * @author uikoo9
 */
@QControllerUrl("/")
public class IndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/fore/home-index.ftl");
	}
	
	/**
	 * 跳转到项目展示页面
	 */
	public void project(){
		setAttr("proDetails", ProjectDetailModel.dao.findAllByCache());
		render("/WEB-INF/view/fore/home-project.ftl");
	}
	
	/**
	 * 跳转到版本更新
	 */
	public void version(){
		render("/WEB-INF/view/fore/home-version.ftl");
	}

	/**
	 * 跳转到关于我
	 */
	public void me(){
		setAttr("diary", DiaryArticleModel.dao.findById(8));
		render("/WEB-INF/view/fore/home-me.ftl");
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void manage(){
		setAttr("menus", UcenterMenuModel.dao.findAllByCache());
		render("/com/uikoo9/util/ucenter/view/manage.ftl");
	}
	
}
