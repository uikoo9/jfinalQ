package com.uikoo9.manage.other.controller;

import java.util.List;

import com.uikoo9.manage.other.model.OtherMenuModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.core.data.QArrayUtil;
import com.uikoo9.util.jfinal.QController;
import com.uikoo9.util.jfinal.ucenter.model.UcenterUserModel;
import com.uikoo9.util.plugin.contants.QContants;
import com.uikoo9.util.plugin.contants.QContantsUtil;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.util.plugin.tree.QTree;

/**
 * OtherMenuController
 * @author qiaowenbin
 */
@QControllerUrl("/other/menu")
public class OtherMenuController extends QController{
	
	/**
	 * 跳转到菜单管理页面
	 */
	public void index(){
		setAttr("tree", new QTree(0, "/", "根菜单", "t_other_menu", null));
		render("/WEB-INF/view/manage/other/other-menu-index.ftl");
	}
	
	/**
	 * 生成树
	 */
	public void tree(){
		renderJson(QJsonUtil.suc(new QTree(0, "/", "根菜单", "t_other_menu", null)));
	}
	
	/**
	 * 跳转到添加子菜单页面
	 */
	public void add(){
		setAttr("yesnos", QContantsUtil.list(QContants.YESNO));
		setAttr("ucenter_menu_parent_id", getParaToInt(0));
		render("/WEB-INF/view/manage/other/other-menu-add.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("yesnos", QContantsUtil.list(QContants.YESNO));
		setAttr("row", getRow(OtherMenuModel.class));
		render("/WEB-INF/view/manage/other/other-menu-edit.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			UcenterUserModel user = getAttr("user");
			if(user == null){
				user = new UcenterUserModel();
				user.set("id", 0);
				user.set("ucenter_user_name", "menudemo");
				setAttr("user", user);
			}
			
			renderJson(save(OtherMenuModel.class));
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
			renderJson(QJsonUtil.suc("删除成功！"));
		} catch (Exception e) {
			e.printStackTrace();
			renderJson(QJsonUtil.error("删除失败！"));
		}
	}
	private void delChildren(Integer id){
		OtherMenuModel menu = OtherMenuModel.dao.findById(id);
		
		List<OtherMenuModel> menus = menu.submenus();
		if(QArrayUtil.notEmpty(menus)){
			for(OtherMenuModel sub : menus){
				delChildren(sub.getInt("id"));
			}
		}
		
		menu.delete();
	}
	
}
