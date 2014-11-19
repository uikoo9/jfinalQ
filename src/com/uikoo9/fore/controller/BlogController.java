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
		
		try {
			Integer typeId = getParaToInt(0);
			if(typeId != null){
				setAttr("blogTypeId", typeId);
				setAttr("blogs", Db.find("select * from t_blog_article tba where tba.type_id=?", typeId));
			}else{
				setAttr("blogs", BlogArticleModel.dao.findAll("order by cdate desc"));
			}
			
			render("/WEB-INF/view/fore/blog-index.ftl");
		} catch (Exception e) {
			e.printStackTrace();
			
			redirect("/blog/fore");
		}
	}
	
	/**
	 * 跳转到博客详情页面
	 */
	public void detail(){
		try {
			Integer blogId = getParaToInt(0);
			if(blogId != null){
				setAttr("blog", BlogArticleModel.dao.findById(blogId));
				render("/WEB-INF/view/fore/blog-detail.ftl");
			}else{
				redirect("/blog/fore");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirect("/blog/fore");
		}
	}
	
}
