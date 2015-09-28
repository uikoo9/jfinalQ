package com.uikoo9.manage.blog.controller;

import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.blog.model.BlogTypeModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.z.jfinal.QController;

/**
 * BlogArticleController
 * @author qiaowenbin
 */
@QControllerUrl("/blog/article")
public class BlogArticleController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", listBySql(getParaMap(), " (select ba.*,bt.blog_type_name tname from t_blog_article ba, t_blog_type bt where ba.blog_type_id=bt.id ) as tba ", "tba"));
		render("/WEB-INF/view/manage/blog/blog-article-index.html");
	}
	
	/**
	 * 跳转到搜索页 
	 */
	public void search(){
		setAttr("blogTypes", BlogTypeModel.dao.findAllByCache());
		
		render("/WEB-INF/view/manage/blog/blog-article-search.html");
	}

	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("blogTypes", BlogTypeModel.dao.findAllByCache());
		setAttr("row", getRow(BlogArticleModel.class));
		
		render("/WEB-INF/view/manage/blog/blog-article-input.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(BlogArticleModel.class));
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(BlogArticleModel.class));
	}
	
}
