package com.uikoo9.manage.blog.controller;

import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.blog.model.BlogCommentModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.external.QStaticUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.ucenter.model.UcenterUserModel;
import com.uikoo9.util.plugin.json.QJsonUtil;

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
		render("/WEB-INF/view/manage/blog/blog-comment-index.html");
	}
	
	/**
	 * 跳转到搜索页 
	 */
	public void search(){
		render("/WEB-INF/view/manage/blog/blog-comment-search.html");
	}

	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(BlogCommentModel.class));
		render("/WEB-INF/view/manage/blog/blog-comment-input.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			UcenterUserModel user = QStaticUtil.user(getRequest());
			if(user == null){
				renderJson(QJsonUtil.error("notlogin"));
			}else{
				renderJson(save(BlogCommentModel.class));
			}
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	@Override
	public Record initRecord(Record record) {
		UcenterUserModel user = QStaticUtil.user(getRequest());
		if(user != null){
			record.set("blog_comment_uname", user.getStr("ucenter_user_name"));
		}
		
		if(QStringUtil.isEmpty(record.getStr("blog_comment_parent_id"))){
			record.set("blog_comment_parent_id", 0);
		}
		
		String content = record.getStr("blog_comment_content");
		if(QStringUtil.notEmpty(content)){
			record.set("blog_comment_content", QStringUtil.filterHtml(content));
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
