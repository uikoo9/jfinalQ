package com.uikoo9.util.jfinal;

import java.io.File;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.spring.SpringPlugin;
import com.uikoo9.util.QDatagrid;
import com.uikoo9.util.QDbUtil;
import com.uikoo9.util.QFileUtil;
import com.uikoo9.util.QPage;
import com.uikoo9.util.QStringUtil;

/**
 * jfinal util
 * @author uikoo9
 * @version 0.0.2.20140522
 */
public class QJfinalUtil {
	
	/**
	 * 初始化spring
	 * @param me
	 * @param path
	 */
	public static void initSpring(Plugins me, String path){
		me.add(new SpringPlugin(new ClassPathXmlApplicationContext(path)));
	}
	
	/**
	 * 初始化数据库信息和数据库映射
	 * @param me
	 * @param path
	 */
	@SuppressWarnings("unchecked")
	public static void initDbAndArp(Plugins me, String path){
		Properties properties = QFileUtil.readProperties(path);
		C3p0Plugin c3p0Plugin = new C3p0Plugin(properties.getProperty("dbUrl"), properties.getProperty("dbUsername"), properties.getProperty("dbPassword"));
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);

		me.add(c3p0Plugin);
		me.add(arp);
		
		try {
			Connection con = null;
			try{
				con = QDbUtil.getCon(properties);
				
				QFileUtil.getAllFiles(QFileUtil.getJarPath().split("classes")[0] + "classes");
				for(String s : QFileUtil.fileList){
					s = s.replace(File.separator, ".");
					if(s.contains("com.uikoo9.web") && s.contains("model")){
						String[] ss = s.split("\\.");
						String clazzName = ss[ss.length - 2];
						String tableName = QDbUtil.getTableNameFromClazzName(clazzName);
						String pkName = QDbUtil.getPkName(con, tableName);
						
						String classPath = s.split("classes")[1];
						String className = classPath.substring(1, classPath.length() - 6); 
						
						Class<? extends Model<?>>  theClass = (Class<? extends Model<?>> ) (Class.forName(className));
						arp.addMapping(tableName, pkName, theClass);
					}
				}
			}finally{
				QDbUtil.closeCon(con);
			}
			
			QFileUtil.fileList.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 初始化controller
	 * 通过controller中的注解，自动配置controller的访问路径
	 * @param me
	 */
	@SuppressWarnings("unchecked")
	public static void initController(Routes me){
		try {
			QFileUtil.getAllFiles(QFileUtil.getJarPath().split("classes")[0] + "classes");
			for(String s : QFileUtil.fileList){
				System.out.println(s);
				if(s.endsWith("Controller.class")){
					String classPath = s.split("classes")[1].replace(File.separator, ".");
					String className = classPath.substring(1, classPath.length() - 6); 
					
					Class<? extends Controller> theClass = (Class<? extends Controller>) (Class.forName(className));
					if(theClass.isAnnotationPresent(QActionMap.class)){
						me.add(theClass.getAnnotation(QActionMap.class).value(), theClass);
					}
				}
			}
			
			QFileUtil.fileList.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * get page info
	 * @param map
	 * @return
	 */
	public static QPage getQPage(Map<String, String[]> map) {
		QPage qPage = new QPage();
		qPage.setPage(QStringUtil.toInt(((String[]) map.get("page"))[0]));
		qPage.setRows(QStringUtil.toInt(((String[]) map.get("rows"))[0]));

		return qPage;
	}

	/**
	 * add where by model
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static String addWhere(String sql, Model<?> obj) {
		StringBuilder sb = new StringBuilder(sql);
		for (String col : obj.getAttrNames()) {
			Object value = obj.get(col);
			if (value != null) {
				String type = QStringUtil.lastString(value.getClass().toString(), "\\.");
				if ("String".equals(type) && QStringUtil.notEmpty((String) value)) {
					sb.append(" and " + col + " like '%" + value + "%' ");
				}

				if ("Integer".equals(type) && value != null){
					sb.append(" and " + col + "=" + value);
				}
			}

		}

		return sb.toString().replaceFirst("and", " where");
	}
	
	/**
	 * return datagrid from record
	 * @param page
	 * @return
	 */
	public static QDatagrid toDatagrid(Page<Record> record) {
		QDatagrid datagrid = new QDatagrid();
		datagrid.setRows(record.getList());
		datagrid.setTotal(record.getTotalRow());

		return datagrid;
	}
	
}
