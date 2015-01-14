package com.uikoo9.manage.diary.controller;

import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.manage.diary.model.DiaryTypeModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.plugin.json.QJsonUtil;

/**
 * DiaryArticleController
 * @author qiaowenbin
 */
@QControllerUrl("/diary/article")
public class DiaryArticleController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", listBySql(getParaMap(), " (select tda.*,tdt.diary_type_name tname from t_diary_article tda, t_diary_type tdt where tda.diary_type_id=tdt.id ) as ba ", "ba"));
		render("/WEB-INF/view/manage/diary/diary-article-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("diaryTypes", DiaryTypeModel.dao.findAllByCache());
		setAttr("row", getRow(DiaryArticleModel.class));
		render("/WEB-INF/view/manage/diary/diary-article-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(DiaryArticleModel.class));
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(DiaryArticleModel.class));
	}
	
}
