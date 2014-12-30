package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/bootstrapQ")
public class BootstrapQController extends Controller{
	
	/**
	 * 跳转到首页
	 */
	public void index(){
		setAttr("blog", BlogArticleModel.dao.findByCode("bootstrapq-index"));
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-index.ftl");
	}
	
	/**
	 * 跳转到起步
	 */
	public void started(){
		setAttr("blog", BlogArticleModel.dao.findByCode("bootstrapq-started"));
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-started.ftl");
	}
	
	/**
	 * 跳转到文档界面
	 */
	public void docs(){
		try {
			String code = getPara();
			if(QStringUtil.notEmpty(code)){
				String blogCode = "bootstrapq-" + code;
				BlogArticleModel blog = BlogArticleModel.dao.findByCode(blogCode);
				if(blog != null){
					setAttr("blog", blog);
					render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-docs.ftl");
					return;
				}
			}

			redirect("/bootstrapQ");
		} catch (Exception e) {
			e.printStackTrace();
			redirect("/bootstrapQ");
		}

	}
	
	/**
	 * 跳转到关于我
	 */
	public void me(){
		setAttr("diary", DiaryArticleModel.dao.findById(8));
		render("/WEB-INF/view/fore/bootstrapQ/bootstrapQ-me.ftl");
	}
	
}
