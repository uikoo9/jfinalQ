package com.uikoo9.manage.project.controller;

import com.uikoo9.manage.project.model.ProjectDetailModel;
import com.uikoo9.manage.project.model.ProjectVersionModel;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;

/**
 * 项目明细controller
 * @author uikoo9
 */
@QControllerUrl("/project/version")
public class ProjectVersionController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", listBySql(getParaMap(), " (select pv.*,pd.project_name pname from t_project_version pv, t_project_detail pd where pv.project_detail_id=pd.id ) as pdv ", "pdv"));
		render("/WEB-INF/view/manage/project/project-version-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("proDetails", ProjectDetailModel.dao.findAllByCache());
		setAttr("row", getRow(ProjectVersionModel.class));
		render("/WEB-INF/view/manage/project/project-version-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(ProjectVersionModel.class));
		}else{
			renderJson(new QJson(validate, QJson.TYPE_BS_DANG));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(ProjectVersionModel.class));
	}
	
}
