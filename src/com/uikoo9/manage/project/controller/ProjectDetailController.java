package com.uikoo9.manage.project.controller;

import com.uikoo9.manage.project.model.ProjectDetailModel;
import com.uikoo9.manage.project.model.ProjectVersionModel;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.crud.QJsonUtil;
import com.uikoo9.util.file.QCacheUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.z.MyContants;

/**
 * 项目明细controller
 * @author uikoo9
 */
@QControllerUrl("/project/detail")
public class ProjectDetailController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(ProjectDetailModel.class));
		render("/WEB-INF/view/manage/project/project-detail-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("protypes", QContantsUtil.list(MyContants.PRO_TYPE));
		setAttr("row", getRow(ProjectDetailModel.class));
		render("/WEB-INF/view/manage/project/project-detail-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(ProjectDetailModel.class);
			if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
				QCacheUtil.putToEHCache("proDetails", ProjectDetailModel.dao.findAll("order by project_sn"));
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
		QJson json = del(ProjectDetailModel.class, ProjectVersionModel.class, "project_detail_id");
		if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
			QCacheUtil.putToEHCache("proDetails", ProjectDetailModel.dao.findAll("order by project_sn"));
		}
		
		renderJson(json);
	}
	
}
