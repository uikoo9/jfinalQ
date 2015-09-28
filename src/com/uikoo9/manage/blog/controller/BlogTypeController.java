package com.uikoo9.manage.blog.controller;

import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.blog.model.BlogTypeModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.function.QCacheUtil;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.z.jfinal.QController;

/**
 * BlogTypeController
 * @author qiaowenbin
 */
@QControllerUrl("/blog/type")
public class BlogTypeController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(BlogTypeModel.class));
		render("/WEB-INF/view/manage/blog/blog-type-index.html");
	}
	
	/**
	 * 跳转到搜索页 
	 */
	public void search(){
		render("/WEB-INF/view/manage/blog/blog-type-search.html");
	}

	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(BlogTypeModel.class));
		
		render("/WEB-INF/view/manage/blog/blog-type-input.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(BlogTypeModel.class);
			if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
				QCacheUtil.putToEHCache("blogTypes", BlogTypeModel.dao.findAll());
			}
			
			renderJson(json);
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		QJson json = del(BlogTypeModel.class, BlogArticleModel.class, "blog_type_id");
		if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
			QCacheUtil.putToEHCache("blogTypes", BlogTypeModel.dao.findAll());
		}
		
		renderJson(json);
	}
	
}
