package com.uikoo9.controller;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.util.QFileUtil;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.crud.QPage;
import com.uikoo9.util.crud.QTable;
import com.uikoo9.util.jfinal.QJfinalUtil;

public class BaseController extends Controller{
	
	/**
	 * 分页
	 * @param modelClass model
	 */
	public void list(Class<? extends Model<?>> modelClass){
		String sql = QJfinalUtil.addWhere(modelClass.getAnnotation(QTable.class).value(), getModel(modelClass, "row"));

		QPage qpage = new QPage();
		Page<Record> page = Db.paginate(getParaToInt("pageNumber"), 10, "select * ", sql);
		qpage.setList(page.getList());
		qpage.setTotalPage(page.getTotalPage());
		qpage.setTotalRow(page.getTotalRow());
		setAttr("qpage", qpage);
		
		if(Boolean.parseBoolean(QFileUtil.CONFIG.getProperty("static"))){
			setAttr("util", QJfinalUtil.getStaticClass("com.uikoo9.util.contants.QContantsUtil"));
		}
	}
	
	/**
	 * 通过id和表名获取一条记录
	 * @param id id
	 * @param tableName 表名
	 * @return id对应的记录
	 */
	public Record get(String id, String tableName){
		return QStringUtil.isEmpty(id) ? null : Db.findById(tableName, id);
	}
	
	/**
	 * 保存和修改一个表
	 * @param paras 从页面传过来的参数
	 * @param tableName 表名
	 * @return 结果
	 */
	public QJson save(Map<String, String[]> paras, String tableName){
		try {
			String id = QJfinalUtil.value(paras, "row.id");
			
			if(QStringUtil.isEmpty(id)){
				Db.save(tableName, setValues(new Record(), paras));
				return new QJson("添加成功！", QJson.TYPE_BS_SUCC);
			}else{
				Db.update(tableName, setValues(Db.findById(tableName, id), paras));
				return new QJson("修改成功！", QJson.TYPE_BS_SUCC);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new QJson("保存失败！", QJson.TYPE_BS_DANG);
		}
	}
	private Record setValues(Record record, Map<String, String[]> paras){
		Set<String> keys = paras.keySet();
		for(String key : keys){
			if(key.startsWith("row.") && !"row.id".equals(key)){
				String value = QJfinalUtil.value(paras, key);
				if(QStringUtil.notEmpty(value)){
					record.set(key.substring(4), value);
				}
			} 
		}
		
		if(record.get("id") == null){
			return setUserInfo(record);
		}else{
			return record;
		}
	}
	private Record setUserInfo(Record record){
		Record user = (Record)getSessionAttr("user");
		record.set("cdate", new Date());
		record.set("cuser_id", user.get("id"));
		record.set("cuser_name", user.get("username"));
		
		return record;
	}
	
	/**
	 * 删除数据
	 * @param ids ids
	 * @param tableName 表名
	 * @return 结果
	 */
	public QJson del(String ids, String tableName){
		try {
			if(QStringUtil.notEmpty(ids)){
				Db.update("delete from " + tableName + " where id in (" + ids + ")");
				return new QJson("删除成功！", QJson.TYPE_BS_SUCC);
			}else{
				return new QJson("请选择要删除的记录！", QJson.TYPE_BS_WARN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new QJson("删除失败！", QJson.TYPE_BS_DANG);
		}
	}
	
}
