package com.uikoo9.manage.blog.controller;

import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.blog.model.BlogTypeModel;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.file.QCacheUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

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
		render("/WEB-INF/view/manage/blog/blog-type-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(BlogTypeModel.class));
		
		render("/WEB-INF/view/manage/blog/blog-type-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(BlogTypeModel.class);
			if(QJson.TYPE_BS_SUCC.equals(json.getType())){
				QCacheUtil.putToEHCache("blogTypes", BlogTypeModel.dao.findAll("order by type_name"));
			}
			
			renderJson(json);
		}else{
			renderJson(new QJson(validate, QJson.TYPE_BS_DANG));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		QJson json = del(BlogTypeModel.class, BlogArticleModel.class, "type_id");
		if(QJson.TYPE_BS_SUCC.equals(json.getType())){
			QCacheUtil.putToEHCache("blogTypes", BlogTypeModel.dao.findAll("order by type_name"));
		}
		
		renderJson(json);
	}
	
}
