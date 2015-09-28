package com.uikoo9.manage.ucenter.controller;

import com.jfinal.aop.Duang;
import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.ucenter.model.UcenterRoleModel;
import com.uikoo9.manage.ucenter.model.UcenterRoleRUserModel;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.manage.ucenter.service.RoleService;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.util.plugin.tree.QTree;
import com.uikoo9.util.plugin.tree.QTreeCheck;
import com.uikoo9.z.jfinal.QController;

/**
 * UcenterRoleController
 * @author qiaowenbin
 */
@QControllerUrl("/ucenter/role")
public class UcenterRoleController extends QController{
	
	private RoleService roleService = Duang.duang(RoleService.class);
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		setAttr("qpage", list(UcenterRoleModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-role-index.html");
	}
	
	/**
	 * 跳转到搜索页 
	 */
	public void search(){
		render("/WEB-INF/view/manage/ucenter/ucenter-role-search.html");
	}

	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		setAttr("row", getRow(UcenterRoleModel.class));
		render("/WEB-INF/view/manage/ucenter/ucenter-role-input.html");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String validate = validate();
		if(validate == null){
			renderJson(save(UcenterRoleModel.class));
		}else{
			renderJson(QJsonUtil.error(validate));
		}
	}
	
	/**
	 * 删除一条或多条
	 */
	public void del(){
		renderJson(del(UcenterRoleModel.class, UcenterRoleRUserModel.class, "ucenter_role_id"));
	}
	
	/**
	 * 跳转到设置用户页面
	 */
	public void setUser(){
		Integer roleId = getParaToInt(0);
		setAttr("roleid", roleId);
		UcenterRoleModel role = UcenterRoleModel.dao.findById(roleId);
		setAttr("rls", role.users());
		String sql = "select * from t_ucenter_user uu where uu.id not in (select distinct(rl.ucenter_user_id) from t_ucenter_role_r_user rl) order by uu.ucenter_user_name";
		setAttr("outusers", UcenterUserModel.dao.find(sql));
		
		render("/WEB-INF/view/manage/ucenter/ucenter-role-set-user.html");
	}
	
	/**
	 * 添加用户
	 */
	public void addUser(){
		renderJson(roleService.addUser(getParaToInt("roleid"), getPara("userids"), (UcenterUserModel) getAttr("user")));
	}
	
	/**
	 * 移除用户
	 */
	public void removeUser(){
		renderJson(roleService.removeUser(getPara("rlids")));
	}
	
	/**
	 * 跳转到设置Url页面
	 */
	public void setUrl(){
		final int roleId = getParaToInt();
		
		setAttr("roleid", roleId);
		setAttr("tree", new QTree(0, "/", "根菜单", null, new QTreeCheck(){
			@Override
			public boolean isCheck(int menuId) {
				String sql = "select count(*) from t_ucenter_role_r_menu where ucenter_role_id=? and ucenter_menu_id=?";
				long count = Db.queryLong(sql, roleId, menuId);
				
				return count == 1 ? true : false;
			}
		}));
		
		render("/WEB-INF/view/manage/ucenter/ucenter-role-set-url.html");
	}
	
	/**
	 * 添加或删除Url
	 */
	public void saveUrl(){
		renderJson(roleService.saveUrl(getParaToInt("roleid"), getPara("ids"), (UcenterUserModel) getAttr("user")));
	}
	
}
