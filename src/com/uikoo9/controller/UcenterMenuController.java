package com.uikoo9.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * 首页跳转controller
 * @author uikoo9
 */
@QActionMap("/menu")
public class UcenterMenuController extends Controller{
	
	private final String TableName = "ucenter_menu";
	
	/**
	 * 跳转到首页 
	 */
	public void index(){
		StringBuilder sb = new StringBuilder("select * from " + TableName);
		StringBuilder querystr = new StringBuilder("<strong>");

		String text = getPara("text");
		if(QStringUtil.notEmpty(text)){
			querystr.append("，text("+text+")");
			sb.append(" and text like '%" + text + "%'");
		}
		String url = getPara("url");
		if(QStringUtil.notEmpty(url)){
			querystr.append("，url("+url+")");
			sb.append(" and url like '%" + url + "%'");
		}
		
		List<Record> rows = Db.find(sb.toString().replaceFirst("and", "where")); 
		querystr.append("，共查询到"+rows.size()+"条记录。</strong>");
		
		setAttr("rows", rows);
		setAttr("querystr", querystr.toString().replaceFirst("，", ""));
		
		render("/WEB-INF/view/menu-index.ftl");
	}
	
	/**
	 * 跳转到保存修改页 
	 */
	public void savep(){
		String id = getPara("id");
		if(QStringUtil.notEmpty(id)) setAttr("row", Db.findById(TableName, id));
		
		render("/WEB-INF/view/menu-input.ftl");
	}
	
	/**
	 * 保存或修改
	 */
	public void save(){
		String id = getPara("id");
		String text = getPara("text");
		String url = getPara("url");
		
		if(QStringUtil.isEmpty(id)){
			Record menu = new Record();
			menu.set("text", text);
			menu.set("url", url);
			Db.save(TableName, menu);
			
			renderJson(new QJson("添加成功！"));
		}else{
			Record menu = Db.findById(TableName, id);
			menu.set("text", text);
			menu.set("url", url);
			Db.update(TableName, menu);

			renderJson(new QJson("修改成功！"));
		}
	}
	
	public void del(){
		String ids = getPara("ids");
		if(QStringUtil.notEmpty(ids)){
			for(String id : ids.split(",")){
				Db.deleteById(TableName, id);
			}
			
			renderJson(new QJson("删除成功！"));
		}else{
			renderJson(new QJson("请选择要删除的记录！"));
		}
	}
	
}
