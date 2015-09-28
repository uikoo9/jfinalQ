package com.uikoo9.z.jfinal;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QArrayUtil;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.function.QDbUtil;
import com.uikoo9.util.plugin.crud.QColumnInfo;
import com.uikoo9.util.plugin.crud.QPage;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;

/**
 * 基础controller，封装一些常用方法
 * @author qiaowenbin
 * @version 0.1.0.20150914
 * @history
 * 	0.1.0.20150914<br>
 * 	0.0.4.20141208<br>
 * 	0.0.3.20140918<br>
 */
public class QController extends Controller{
	
	private static final Logger logger = LoggerFactory.getLogger(QController.class);
	
	/**
	 * 分页查询记录列表
	 * @param modelClass
	 * @return
	 */
	public QPage list(Class<? extends Model<?>> modelClass){
		Integer pageNumber = getParaToInt("pageNumber") == null ? 1 : getParaToInt("pageNumber");
		Integer pageSize = getParaToInt("pageSize") == null ? 10 : getParaToInt("pageSize");
		
		String sql = addWhere(modelClass.getAnnotation(QTable.class).value(), getModel(modelClass, "row"));
		
		QPage qpage = new QPage();
		Page<Record> page = Db.paginate(pageNumber, pageSize, "select * ", sql);
		qpage.setList(page.getList());
		qpage.setPageNumber(pageNumber);
		qpage.setPageSize(pageSize);
		qpage.setTotalPage(page.getTotalPage());
		qpage.setTotalRow(page.getTotalRow());
		qpage.setStr("select * " + sql);
		
		return qpage;
	}
	
	/**
	 * 查询分页
	 * @param paras 参数
	 * @param tableName 表名
	 * @param name 别名
	 * @return 查询列表
	 */
	public QPage listBySql(Map<String, String[]> paras, String tableName, String name){
		StringBuilder sb = new StringBuilder("from " + tableName);
		Set<String> keys = paras.keySet();
		for(String key : keys){
			String value = value(paras, key);
			if(key.startsWith("row.") && !"row.id".equals(key) && QStringUtil.notEmpty(value)){
				if(name == null){
					sb.append(" and " + key.substring(4) + " like '%" + value + "%'");
				}else{
					String colname = key.substring(4);
					if(colname.endsWith("_id")){
						sb.append(" and " + name + "." + key.substring(4) + " =" + value);
					}else{
						sb.append(" and " + name + "." + key.substring(4) + " like '%" + value + "%'");
					}
				}
			}
		}
		if(name == null){
			sb.append(" order by id desc");
		}else{
			sb.append(" order by " + name + ".id desc");
		}
		String sql = sb.toString().replaceFirst("and", "where");
		
		Integer pageNumber = getParaToInt("pageNumber") == null ? 1 : getParaToInt("pageNumber");
		Integer pageSize = getParaToInt("pageSize") == null ? 10 : getParaToInt("pageSize");
		
		QPage qpage = new QPage();
		Page<Record> page = Db.paginate(pageNumber, pageSize, "select * ", sql);
		qpage.setList(page.getList());
		qpage.setPageNumber(pageNumber);
		qpage.setPageSize(pageSize);
		qpage.setTotalPage(page.getTotalPage());
		qpage.setTotalRow(page.getTotalRow());
		qpage.setStr("select * " + sql);
		
		return qpage;
	}
	
	/**
	 * 通过id获取一条记录
	 * @param modelClass
	 * @return
	 */
	public Record getRow(Class<? extends Model<?>> modelClass){
		String id = getPara("id");
		return QStringUtil.isEmpty(id) ? null : Db.findById(modelClass.getAnnotation(QTable.class).value(), id);
	}
	
	/**
	 * 保存前进行校验
	 * @return
	 */
	public String validate(){
		return null;
	}
	
	/**
	 * 保存前修改属性
	 * @param record
	 * @return
	 */
	public Record initRecord(Record record){
		return record;
	}
	
	/**
	 * 保存和修改一个表
	 * @param modelClass model
	 * @return
	 */
	public QJson save(Class<? extends Model<?>> modelClass){
		try {
			String tableName = modelClass.getAnnotation(QTable.class).value();
			
			String res = requireAndUniqueValidate(tableName);
			if(res != null){
				return QJsonUtil.error(res);
			}else{
				Map<String, String[]> paras = getParaMap();
				
				String id = value(paras, "row.id");
				if(QStringUtil.isEmpty(id)){
					Record record = initRecord(setValues(new Record(), paras));
					Db.save(tableName, record);
					return QJsonUtil.suc("添加成功！", record);
				}else{
					Record record = initRecord(setValues(Db.findById(tableName, id), paras));
					Db.update(tableName, record);
					return QJsonUtil.suc("修改成功！", record);
				}
			}
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("保存失败！");
		}
	}
	private String requireAndUniqueValidate(String tableName) throws SQLException, Exception{
		Map<String, QColumnInfo> columnMap = QDbUtil.getColumnInfoMap(DbKit.getConfig().getConnection(), tableName);
		Map<String, String[]> paras = getParaMap();
		
		// not null
		for(String key : paras.keySet()){
			if(key.startsWith("row") && !key.equals("row.id")){
				QColumnInfo col = columnMap.get(key.substring(4));
				if(!col.getIsNull() && QStringUtil.isEmpty(value(paras, key))){
					return "请输入" + col.getRemarks() + "！";
				}
			}
		}

		// unique
		for(String key : paras.keySet()){
			if(key.startsWith("row") && !key.equals("row.id")){
				QColumnInfo col = columnMap.get(key.substring(4));
				if(col.getIsUnique()){
					String sql = "select * from " + tableName + " where " + key.substring(4) + "=?";
					
					Integer id = getParaToInt("row.id");
					List<Record> records = 
							id == null ? Db.find(sql, value(paras, key)) : Db.find(sql + " and id!=?", value(paras, key), id);
					if(QArrayUtil.notEmpty(records)) return col.getRemarks() + "已经存在！";
				}
			}
		}
		
		return null;
	}
	private Record setValues(Record record, Map<String, String[]> paras){
		Set<String> keys = paras.keySet();
		for(String key : keys){
			if(key.startsWith("row.") && !"row.id".equals(key)){
				String value = value(paras, key);
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
		UcenterUserModel user = getAttr("user");
		record.set("cdate", new Date());
		record.set("cuser_id", user.get("id"));
		record.set("cuser_name", user.get("ucenter_user_name"));
		
		return record;
	}
	
	/**
	 * 删除数据
	 * @param ids ids
	 * @param tableName 表名
	 * @return 结果
	 */
	public QJson del(Class<? extends Model<?>> modelClass){
		return del(modelClass, null, null);
	}
	
	/**
	 * 删除数据（级联）
	 * @param pClass
	 * @param cClass
	 * @param pid
	 * @return
	 */
	public QJson del(Class<? extends Model<?>> pClass, Class<? extends Model<?>> cClass, String pid){
		try {
			String pTable = pClass.getAnnotation(QTable.class).value();
			String ids = getPara("ids");
			
			if(QStringUtil.notEmpty(ids)){
				if(cClass != null && QStringUtil.notEmpty(pid)){
					String cTable = cClass.getAnnotation(QTable.class).value();
					Db.update("delete from " + cTable + " where " + pid + " in (" + ids + ")");
				}
				
				Db.update("delete from " + pTable + " where id in (" + ids + ")");
				return QJsonUtil.suc("删除成功！");
			}else{
				return QJsonUtil.error("请选择要删除的记录！");
			}
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("删除失败！");
		}
	}
	
	/**
	 * add where by model
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static String addWhere(String tableName, Model<?> obj) {
		StringBuilder sb = new StringBuilder("from " + tableName);
		for (String col : obj.getAttrNames()) {
			Object value = obj.get(col);
			if (value != null) {
				String type = QStringUtil.splitAndReturnLastString(value.getClass().toString(), "\\.");
				if ("String".equals(type) && QStringUtil.notEmpty((String) value)) {
					sb.append(" and " + col + " like '%" + value + "%' ");
				}

				if ("Integer".equals(type) && value != null){
					sb.append(" and " + col + "=" + value);
				}
			}
		}
		sb.append(" order by id desc");

		return sb.toString().replaceFirst("and", " where");
	}
	
	/**
	 * 获取paras的值
	 * @param paras
	 * @param key
	 * @return
	 */
	public static String value(Map<String, String[]> paras, String key){
		if(paras != null && QStringUtil.notEmpty(key) && paras.get(key) != null){
			return paras.get(key)[0];
		}else{
			return null;
		}
	}
	
}