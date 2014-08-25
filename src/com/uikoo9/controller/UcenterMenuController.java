package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 首页跳转controller
 * @author uikoo9
 */
@QActionMap("/menu")
public class UcenterMenuController extends Controller{
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		render("/WEB-INF/view/menu-index.ftl");
	}
	
	/**
	 * ucenter menu list
	 */
	public void list(){
		setAttr("rows", Db.find("select * from ucenter_menu"));
		
		render("/WEB-INF/view/menu-list.ftl");
	}
	
	public void savep(){
		render("/WEB-INF/view/menu-save.ftl");
	}
	
	public void save(){
		String id = getPara("id");
		String text = getPara("text");
		String url = getPara("url");
		
		if(QStringUtil.isEmpty(id)){
			Record menu = new Record();
			menu.set("text", text);
			menu.set("url", url);
			
			Db.save("ucenter_menu", menu);
			renderJson(new QJson("test"));
		}
	}
	
}
