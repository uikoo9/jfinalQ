package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.manage.diary.model.DiaryTypeModel;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/diary")
public class DiaryController extends Controller{
	
	/**
	 * 跳转到看日记页面
	 */
	public void list(){
		setAttr("diaryTypes", DiaryTypeModel.dao.findAllByCache());
		
		try {
			Integer typeId = getParaToInt(0);
			if(typeId != null){
				setAttr("diaryTypeId", typeId);
				setAttr("diarys", Db.find("select * from t_diary_article tda where tda.diary_type_id=? order by cdate desc", typeId));
			}else{
				setAttr("diarys", DiaryArticleModel.dao.findAll());
			}
			
			render("/WEB-INF/view/fore/diary/diary-list.ftl");
		} catch (Exception e) {
			redirect("/diary/list");
		}
	}
	
	/**
	 * 跳转到编辑日记页面
	 */
	public void edit(){
		setAttr("diaryTypes", DiaryTypeModel.dao.findAllByCache());
		if(getParaToInt(0) != null){
			setAttr("diary", DiaryArticleModel.dao.findById(getParaToInt(0)));
		}
		
		render("/WEB-INF/view/fore/diary/diary-edit.ftl");
	}
	
	/**
	 * 跳转到日记详情页面
	 */
	public void detail(){
		try {
			DiaryArticleModel diary = DiaryArticleModel.dao.findById(getParaToInt(0));
			diary.set("diary_article_readtimes", ((Integer)diary.get("diary_article_readtimes") + 1)).update();
			
			setAttr("diary", diary);
			render("/WEB-INF/view/fore/diary/diary-detail.ftl");
		} catch (Exception e) {
			e.printStackTrace();
			redirect("/diary/list");
		}
	}
	
}
