package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.manage.blog.model.BlogArticleModel;
import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/diary")
public class DiaryController extends Controller{
	
	/**
	 * 跳转到编辑日记页面
	 */
	public void edit(){
		Integer diaryId = getParaToInt(0);
		if(diaryId != null){
			setAttr("diary", BlogArticleModel.dao.findById(diaryId));
		}
		
		render("/WEB-INF/view/fore/diary/diary-edit.ftl");
	}
	
	/**
	 * 跳转到看日记页面
	 */
	public void list(){
		setAttr("diarys", DiaryArticleModel.dao.findAll());
		render("/WEB-INF/view/fore/diary/diary-list.ftl");
	}
	
	/**
	 * 跳转到日记详情页面
	 */
	public void detail(){
		try {
			DiaryArticleModel diary = DiaryArticleModel.dao.findById(getParaToInt(0));
			diary.set("article_times", ((Integer)diary.get("article_times") + 1)).update();
			
			setAttr("diary", diary);
			render("/WEB-INF/view/fore/diary/diary-detail.ftl");
		} catch (Exception e) {
			e.printStackTrace();
			redirect("/diary/list");
		}
	}
	
}
