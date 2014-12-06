package com.uikoo9.fore.controller;

import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.blog.model.BlogTypeModel;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/home")
public class HomeController extends QController{
	
	/**
	 * 未登录跳转
	 */
	public void index(){
		render("/WEB-INF/view/fore/home/home-index.ftl");
	}
	
	/**
	 * 跳转到项目展示页面
	 */
	public void project(){
		setAttr("proDetails", ProDetailModel.dao.findAllByCache());
		render("/WEB-INF/view/fore/home/home-project.ftl");
	}
	
	/**
	 * 跳转到博客首页 
	 */
	public void blogs(){
		setAttr("blogTypes", BlogTypeModel.dao.findAllByCache());
		
		try {
			Integer typeId = getParaToInt(0);
			if(typeId != null){
				setAttr("blogTypeId", typeId);
				setAttr("blogs", Db.find("select * from t_blog_article tba where tba.type_id=? order by cdate desc", typeId));
			}else{
				setAttr("blogs", BlogArticleModel.dao.find("select * from t_blog_article tba order by cdate desc"));
			}
			
			render("/WEB-INF/view/fore/blog/blog-index.ftl");
		} catch (Exception e) {
			redirect("/home/blogs");
		}
	}
	
	/**
	 * 跳转到博客详情页面
	 */
	public void blog(){
		try {
			String blogCode = getPara();
			if(QStringUtil.notEmpty(blogCode)){
				BlogArticleModel blog = BlogArticleModel.dao.findFirst("select * from t_blog_article where article_code=?", blogCode);
				blog.set("article_times", ((Integer)blog.get("article_times") + 1)).update();
				setAttr("blog", blog);
				
				render("/WEB-INF/view/fore/blog/blog-detail.ftl");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		redirect("/home/blogs");
	}
	
	/**
	 * 跳转到版本更新
	 */
	public void version(){
		render("/WEB-INF/view/fore/home/home-version.ftl");
	}
	
}
