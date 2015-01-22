package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.blog.model.BlogTypeModel;
import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.manage.other.model.OtherDonateModel;
import com.uikoo9.util.core.annotation.QControllerUrl;

@QControllerUrl("/bootstrapQ")
public class BootstrapQController extends Controller{
	
	/**
	 * 跳转到首页
	 */
	public void index(){
		setAttr("blog", BlogArticleModel.dao.findByCode("bootstrapq-started"));
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-index.ftl");
	}
	
	/**
	 * 跳转到文档界面
	 */
	public void docs(){
		setAttr("blogs", BlogTypeModel.dao.findById(8).articles());
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-docs.ftl");
	}
	
	/**
	 * 捐助
	 */
	public void donate(){
		setAttr("donates", OtherDonateModel.dao.findAllByCache());
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-donate.ftl");
	}

	/**
	 * 跳转到关于我
	 */
	public void me(){
		setAttr("diary", DiaryArticleModel.dao.findById(8));
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-me.ftl");
	}
	
}
