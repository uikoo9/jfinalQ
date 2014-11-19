package com.uikoo9.fore.controller;

import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.blog.model.BlogTypeModel;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/blog/fore")
public class BlogController extends QController{
	
	/**
	 * 跳转到博客首页 
	 */
	public void index(){
		setAttr("blogTypes", BlogTypeModel.dao.findAllByCache());
		
		Integer typeId = getParaToInt(0);
		if(typeId == null){
			setAttr("blogs", BlogArticleModel.dao.findAll("order by cdate desc"));
		}else{
			setAttr("blogs", Db.find("select * from t_blog_article tba where tba.type_id=?", typeId));
		}
		
		render("/WEB-INF/view/fore/blog-index.ftl");
	}
	
}
