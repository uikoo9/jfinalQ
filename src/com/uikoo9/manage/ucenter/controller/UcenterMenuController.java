package com.uikoo9.manage.ucenter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uikoo9.manage.ucenter.model.UcenterMenuModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.core.data.QArrayUtil;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.function.QCacheUtil;
import com.uikoo9.util.plugin.contants.QContantsUtil;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.util.plugin.tree.QTree;
import com.uikoo9.z.QContants;
import com.uikoo9.z.jfinal.QController;

/**
 * 用户中心-菜单controller
 * @author uikoo9
 */
@QControllerUrl("/ucenter/menu")
public class UcenterMenuController extends QController{
	
	private static final Logger logger = LoggerFactory.getLogger(UcenterMenuController.class);
	
	/**
	 * 跳转到菜单管理页面
	 */
	public void index(){
		setAttr("tree", new QTree(0, "/", "根菜单", null, null));
		render("/WEB-INF/view/manage/ucenter/ucenter-menu-index.html");
	}
	
	/**
	 * 生成树
	 */
	public void tree(){
		renderJson(QJsonUtil.suc(new QTree(0, "/", "根菜单", null, null)));
	}
	
	/**
	 * 跳转到添加子菜单页面
	 */
	public void add(){
		setAttr("yesnos", QContantsUtil.list(QContants.YESNO));
		setAttr("ucenter_menu_parent_id", getParaToInt(0));
		render("/WEB-INF/view/manage/ucenter/ucenter-menu-add.html");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("yesnos", QContantsUtil.list(QContants.YESNO));
		setAttr("row", getRow(UcenterMenuModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-menu-edit.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			QJson json = save(UcenterMenuModel.class);
			if(QJsonUtil.TYPE_BS_SUCC.equals(json.getType())){
				QCacheUtil.putToEHCache("menus", UcenterMenuModel.dao.findAllByCache());
			}
			
			renderJson(json);
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除菜单，包括子菜单
	 */
	public void del(){
		try {
			delChildren(getParaToInt());
			QCacheUtil.putToEHCache("menus", UcenterMenuModel.dao.findAllByCache());
			renderJson(QJsonUtil.suc("删除成功！"));
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			renderJson(QJsonUtil.error("删除失败！"));
		}
	}
	private void delChildren(Integer id){
		UcenterMenuModel menu = UcenterMenuModel.dao.findById(id);
		
		List<UcenterMenuModel> menus = menu.submenus();
		if(QArrayUtil.notEmpty(menus)){
			for(UcenterMenuModel sub : menus){
				delChildren(sub.getInt("id"));
			}
		}
		
		menu.delete();
	}
	
}
