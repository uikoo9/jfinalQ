package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.jfinal.ucenter.model.UcenterMenuModel;

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
		String sql = "select count(*) from t_blog_comment t1 where t1.blog_comment_parent_id=0 and not exists(select 1 from t_blog_comment t2 where t2.blog_comment_parent_id=t1.id)";
		setAttr("msgcount", Db.queryLong(sql));
		
		render("/WEB-INF/view/fore/home/home-index.ftl");
	}
	
	/**
	 * 跳转到版本更新
	 */
	public void version(){
		render("/WEB-INF/view/fore/home/home-version.ftl");
	}
	
	/**
	 * 捐助
	 */
	public void donate(){
		render("/WEB-INF/view/fore/home/home-donate.ftl");
	}
	
	/**
	 * 跳转到关于我
	 */
	public void me(){
		setAttr("blog", BlogArticleModel.dao.findByCode("about-me"));
		render("/WEB-INF/view/fore/home/home-me.ftl");
	}

	/**
	 * 跳转到后台管理页面
	 */
	public void manage(){
		setAttr("menus", UcenterMenuModel.dao.findAllByCache());
		render("/com/uikoo9/util/jfinal/view/common/manage.ftl");
	}
	
}
