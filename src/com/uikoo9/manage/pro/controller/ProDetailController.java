package com.uikoo9.manage.pro.controller;

import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.manage.pro.model.ProVersionModel;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.QControllerUrl;
import com.uikoo9.z.MyContants;

/**
 * 项目明细controller
 * @author uikoo9
 */
@QControllerUrl("/pro/detail")
public class ProDetailController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(ProDetailModel.class));
		render("/WEB-INF/view/manage/pro/pro-detail-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("protypes", QContantsUtil.list(MyContants.PRO_TYPE));
		setAttr("row", getRow(ProDetailModel.class));
		
		render("/WEB-INF/view/manage/pro/pro-detail-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(ProDetailModel.class);
			if(QJson.TYPE_BS_SUCC.equals(json.getType())){
				ProDetailModel.dao.reloadAllToCache();
			}
			
			renderJson(json);
		}else{
			renderJson(new QJson(validate, QJson.TYPE_BS_DANG));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(ProDetailModel.class, ProVersionModel.class, "pro_detail_id"));
	}
	
}
