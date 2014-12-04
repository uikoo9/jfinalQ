package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/diary")
public class DiaryController extends Controller{
	/**
	 * 跳转到写日记页面
	 */
	public void add(){
		render("/WEB-INF/view/fore/diary/diary-add.ftl");
	}
	
	/**
	 * 跳转到看日记页面
	 */
	public void list(){
		setAttr("diarys", BlogArticleModel.dao.find("select * from t_blog_article where type_id=7 order by cdate desc"));
		render("/WEB-INF/view/fore/diary/diary-list.ftl");
	}
	
	/**
	 * 跳转到日记详情页面
	 */
	public void detail(){
		setAttr("diary", BlogArticleModel.dao.findById(getParaToInt(0)));
		render("/WEB-INF/view/fore/diary/diary-detail.ftl");
	}
}
