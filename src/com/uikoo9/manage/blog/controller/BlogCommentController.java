package com.uikoo9.manage.blog.controller;

import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.blog.model.BlogCommentModel;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * BlogCommentController
 * @author qiaowenbin
 */
@QControllerUrl("/blog/comment")
public class BlogCommentController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(BlogCommentModel.class));
		render("/WEB-INF/view/manage/blog/blog-comment-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(BlogCommentModel.class));
		render("/WEB-INF/view/manage/blog/blog-comment-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			Record user = getAttr("user");
			if(user == null){
				user = new Record();
				user.set("id", 0);
				user.set("user_name", "blogcomment");
				setAttr("user", user);
			}
			
			renderJson(save(BlogCommentModel.class));
		}else{
			renderJson(new QJson(validate, QJson.TYPE_BS_DANG));
		}
	}
	
	@Override
	public Record initRecord(Record record) {
		removeAttr("user");
		if(QStringUtil.isEmpty(record.getStr("blog_comment_parent_id"))){
			record.set("blog_comment_parent_id", 0);
		}
		
		return record;
	}

	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(BlogCommentModel.class));
	}
	
}
