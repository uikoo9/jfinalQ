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
			Integer typeId = getParaToInt(0) == null ? 5 : getParaToInt(0);

			setAttr("diaryTypeId", typeId);
			setAttr("diarys", Db.find("select * from t_diary_article tda where tda.diary_type_id=? order by diary_article_title", typeId));
			
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
			setAttr("prevDiary", getDiary("prev", diary));
			setAttr("nextDiary", getDiary("next", diary));
			
			render("/WEB-INF/view/fore/diary/diary-detail.ftl");
		} catch (Exception e) {
			e.printStackTrace();
			redirect("/diary/list");
		}
	}
	private DiaryArticleModel getDiary(String type, DiaryArticleModel diary){
		DiaryArticleModel theDiary = null;
		try {
			String sql = null;
			if("prev".equals(type)) sql = "select * from t_diary_article where id = (select max(id) from t_diary_article where id<? and diary_type_id=?)";
			if("next".equals(type)) sql = "select * from t_diary_article where id = (select min(id) from t_diary_article where id>? and diary_type_id=?)";
			theDiary = DiaryArticleModel.dao.findFirst(sql, diary.getInt("id"), diary.getInt("diary_type_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return theDiary != null ? theDiary : new DiaryArticleModel().set("id", 0).set("diary_article_title", "没有了~");
	}
	
}
