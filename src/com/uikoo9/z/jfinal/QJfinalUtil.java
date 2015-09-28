package com.uikoo9.z.jfinal;

import java.io.File;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.annotation.QControllerUrl;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.core.file.QFileUtil;
import com.uikoo9.util.core.file.QPropertiesUtil;
import com.uikoo9.util.core.http.QCookieUtil;
import com.uikoo9.util.function.QCacheUtil;
import com.uikoo9.util.function.QDbUtil;

/**
 * jfinal util
 * @author qiaowenbin
 * @version 0.0.6.20140830
 */
public class QJfinalUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(QJfinalUtil.class);
	
	/**
	 * 初始化controller
	 * 通过controller中的注解，自动配置controller的访问路径
	 * @param me
	 */
	@SuppressWarnings("unchecked")
	public static void initController(Routes me){
		try {
			QFileUtil.getAllFiles(QFileUtil.getJarPath().split("WEB-INF")[0] + "WEB-INF/classes");
			for(String s : QFileUtil.fileList){
				if(s.endsWith("Controller.class")){
					String classPath = s.split("classes")[1].replace(File.separator, ".");
					String className = classPath.substring(1, classPath.length() - 6); 
					
					Class<? extends Controller> theClass = (Class<? extends Controller>) (Class.forName(className));
					if(theClass.isAnnotationPresent(QControllerUrl.class)){
						me.add(theClass.getAnnotation(QControllerUrl.class).value(), theClass);
					}
				}
			}
			QFileUtil.fileList.clear();
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
		}
	}
	
	/**
	 * 初始化数据库信息和数据库映射
	 * @param me
	 * @param path
	 */
	@SuppressWarnings("unchecked")
	public static void initDbAndArp(Plugins me){
		C3p0Plugin c3p0Plugin = new C3p0Plugin(
				QPropertiesUtil.config.getProperty("db.url"), 
				QPropertiesUtil.config.getProperty("db.username"), 
				QPropertiesUtil.config.getProperty("db.password"));
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);

		me.add(c3p0Plugin);
		me.add(arp);
		
		try {
			Connection con = null;
			try{
				con = QDbUtil.getCon(QPropertiesUtil.config);
				
				QFileUtil.getAllFiles(QFileUtil.getJarPath().split("WEB-INF")[0] + "WEB-INF/classes");
				for(String s : QFileUtil.fileList){
					if(s.endsWith("Model.class")){
						String classPath = s.split("classes")[1].replace(File.separator, ".");
						String className = classPath.substring(1, classPath.length() - 6); 
						
						Class<? extends Model<?>>  theClass = (Class<? extends Model<?>> ) (Class.forName(className));
						if(theClass.isAnnotationPresent(QTable.class)){
							arp.addMapping(theClass.getAnnotation(QTable.class).value(), "id", theClass);
						}
					}
				}
			}finally{
				QDbUtil.closeCon(con);
			}
			
			QFileUtil.fileList.clear();
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
		}
	}
	
	/**
	 * 获取当前用户
	 * @param request
	 * @return
	 */
	public static UcenterUserModel user(HttpServletRequest request){
		UcenterUserModel user = null;
		
		String cookieUserId = QCookieUtil.getValue(request, "uikoo9userid");
		if(QStringUtil.notEmpty(cookieUserId)){
			Object valueObject = QCacheUtil.getFromEHCache(cookieUserId);
			if(valueObject != null){
				user = (UcenterUserModel) valueObject;
			}
		}
		
		return user;
	}
	
}
