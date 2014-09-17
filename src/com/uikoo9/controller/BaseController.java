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
import com.uikoo9.util.jfinal.QJfinalUtil;

public class BaseController extends Controller{
	
	public void test(Class<? extends Model<?>> modelClass){
		System.out.println(modelClass);
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
	
	/**
	 * 查询分页
	 * @param paras 参数
	 * @param tableName 表名
	 * @return 查询列表
	 */
	public QPage list(Map<String, String[]> paras, String tableName){
		StringBuilder sql = new StringBuilder("from " + tableName);
		StringBuilder str = new StringBuilder("<strong>");
		Set<String> keys = paras.keySet();
		for(String key : keys){
			String value = QJfinalUtil.value(paras, key);
			if(key.startsWith("row.") && !"row.id".equals(key) && QStringUtil.notEmpty(value)){
				sql.append(" and " + key.substring(4) + " like '%" + value + "%'");
				str.append("，" + key.substring(4) + "（" + value + "）");
			}
		}
		
		
		QPage qpage = new QPage();
		String pageNumber = QJfinalUtil.value(paras, "pageNumber");
		qpage.setPageNumber(QStringUtil.isEmpty(pageNumber) ? 1 : Integer.parseInt(pageNumber));
		qpage.setPageSize(10);
		
		Page<Record> page = Db.paginate(qpage.getPageNumber(), qpage.getPageSize(), "select * ", sql.toString().replaceFirst("and", "where"));
		qpage.setList(page.getList());
		qpage.setTotalPage(page.getTotalPage());
		qpage.setTotalRow(page.getTotalRow());
		str.append("，共查询到" + qpage.getTotalRow() + "条记录。</strong>");
		qpage.setStr(str.toString().replaceFirst("，", ""));
		
		if(Boolean.parseBoolean(QFileUtil.CONFIG.getProperty("static"))){
			setAttr("util", QJfinalUtil.getStaticClass("com.uikoo9.util.contants.QContantsUtil"));
		}
		
		return qpage;
	}
}
