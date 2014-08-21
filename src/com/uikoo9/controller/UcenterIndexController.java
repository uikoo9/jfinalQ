package com.uikoo9.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.uikoo9.util.crud.QMenu;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 首页跳转controller
 * @author uikoo9
 */
@QActionMap("/")
public class UcenterIndexController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/pro-index.ftl");
	}
	
	/**
	 * 跳转到后台管理页面
	 */
	public void man(){
		List<QMenu> menus = new ArrayList<QMenu>();
		for(int i=1; i<6; i++){
			QMenu menu = new QMenu("menu" + i, "data" + i);
			menus.add(menu);
		}
		setAttr("menus", menus);
		
		render("/WEB-INF/view/man-index.ftl");
	}
	
}
