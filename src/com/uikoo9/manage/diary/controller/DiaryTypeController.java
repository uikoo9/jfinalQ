package com.uikoo9.manage.diary.controller;

import com.uikoo9.manage.diary.model.DiaryArticleModel;
import com.uikoo9.manage.diary.model.DiaryTypeModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.function.QCacheUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;

/**
 * DiaryTypeController
 * @author qiaowenbin
 */
@QControllerUrl("/diary/type")
public class DiaryTypeController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(DiaryTypeModel.class));
		render("/WEB-INF/view/manage/diary/diary-type-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(DiaryTypeModel.class));
		render("/WEB-INF/view/manage/diary/diary-type-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(DiaryTypeModel.class);
			if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
				QCacheUtil.putToEHCache("diaryTypes", DiaryTypeModel.dao.findAll("order by diary_type_name"));
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
		QJson json = del(DiaryTypeModel.class, DiaryArticleModel.class, "diary_type_id");
		if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
			QCacheUtil.putToEHCache("diaryTypes", DiaryTypeModel.dao.findAll("order by diary_type_name"));
		}
		
		renderJson(json);
	}
	
}
