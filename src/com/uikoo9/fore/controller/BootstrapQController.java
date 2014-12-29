package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/bootstrapQ")
public class BootstrapQController extends Controller{
	
	/**
	 * 跳转到首页
	 */
	public void index(){
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-index.ftl");
	}
	
	/**
	 * 跳转到起步
	 */
	public void started(){
		setAttr("blog", BlogArticleModel.dao.findByCode("bootstrapQ-started"));
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-started.ftl");
	}
	
	public void docs(){
		
	}
	
	/**
	 * 跳转到关于我
	 */
	public void me(){
		setAttr("diary", DiaryArticleModel.dao.findById(8));
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-me.ftl");
	}
	
}
