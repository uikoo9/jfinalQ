package com.uikoo9.fore.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.uikoo9.manage.ucenter.model.UcenterMenuModel;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.z.QContants;

/**
 * 用户中心-首页controller
 * @author uikoo9
 */
@QControllerUrl("/")
public class IndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/manage/ucenter/ucenter-login.html");
	}
	
	/**
	 * 跳转到版本更新
	 */
	public void version(){
		render("/WEB-INF/view/fore/home/home-version.html");
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void manage(){
		List<UcenterMenuModel> menus = new ArrayList<UcenterMenuModel>();
		
		UcenterUserModel user = getAttr("user");
		if(user != null && user.role() != null && user.role().getInt("id") != null){
			String sql = "SELECT * FROM t_ucenter_menu WHERE id IN (SELECT t.ucenter_menu_id FROM t_ucenter_role_r_menu t WHERE t.ucenter_role_id=?) and ucenter_menu_parent_id=0 and ucenter_menu_type=? order by ucenter_menu_sn";
			menus = UcenterMenuModel.dao.find(sql, user.role().getInt("id"), QContants.YESNO_YES);
		}
		
		setAttr("menus", menus);
		render("/WEB-INF/view/base/common/manage.html");
	}
	
}
