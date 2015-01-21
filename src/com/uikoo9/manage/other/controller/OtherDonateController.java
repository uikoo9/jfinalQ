package com.uikoo9.manage.other.controller;

import com.uikoo9.manage.other.model.OtherDonateModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.function.QCacheUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;

/**
 * OtherDonateController
 * @author qiaowenbin
 */
@QControllerUrl("/other/donate")
public class OtherDonateController extends QController{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(OtherDonateModel.class));
		render("/WEB-INF/view/manage/other/other-donate-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(OtherDonateModel.class));
		render("/WEB-INF/view/manage/other/other-donate-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(OtherDonateModel.class);
			if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
				QCacheUtil.putToEHCache("donates", OtherDonateModel.dao.findAll("order by other_donate_money desc"));
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
		QJson json = del(OtherDonateModel.class);
		if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
			QCacheUtil.putToEHCache("donates", OtherDonateModel.dao.findAll("order by other_donate_money desc"));
		}
		
		renderJson(json);
	}
	
}
