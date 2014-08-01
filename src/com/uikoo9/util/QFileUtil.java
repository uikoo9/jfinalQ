package com.uikoo9.util;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 文件工具类
 * 1.获取文件后缀
 * 2.修改文件后缀
 * 3.读取配置文件
 * 4.读取jar包路径
 * 5.获取某文件夹下的所有文件的路径
 * 6.删除文件
 * @author uikoo9
 * @version 0.0.3.20140801
 */
public class QFileUtil {
	
	/**
	 * 获取文件名的后缀
	 * @param fileName 文件名
	 * @return null或文件名的后缀
	 */
	public static String getFileExt(String fileName){
		if(QStringUtil.isEmpty(fileName)) return null;
		
		int dot = fileName.lastIndexOf('.');   
		if(dot == -1 || dot + 1 == fileName.length()) return null;
		
		return fileName.substring(dot + 1);
	}
	
	/**
	 * 修改文件后缀
	 * @param fileName 文件名
	 * @param ext 后缀
	 * @return
	 */
	public static String changeFileExt(String fileName, String ext){
		if(QStringUtil.isEmpty(fileName)) return null;
		
		int dot = fileName.lastIndexOf('.');   
		if(dot == -1 || dot + 1 == fileName.length()) return null;
		
		String fileNameStr = fileName.substring(0, dot + 1);
		return fileNameStr + ext;
	}
	
	/**
	 * 读取配置文件
	 * @param in
	 * @return
	 */
	public static Properties readProperties(String path){
		Properties p = new Properties();
		
		try {
			p.load(QFileUtil.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	/**
	 * jar包得到自身的路径
	 * @return
	 */
	public static String getJarPath() {
		String res = null;
		
		try {
			res = URLDecoder.decode(QFileUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static final List<String> fileList = new ArrayList<String>();
	/**
	 * 获取某路径下的所有文件的绝对路径
	 * @param path
	 */
	public static void getAllFiles(String path){
        File dir = new File(path); 
        File[] files = dir.listFiles(); 
        
        if (files != null){
        	fileList.clear();
        	for (int i = 0; i < files.length; i++) { 
        		if (files[i].isDirectory()) { 
        			getAllFiles(files[i].getAbsolutePath()); 
        		} else { 
        			fileList.add(files[i].getAbsolutePath());                    
        		} 
        	} 
        }
	}
	
	/**
	 * 删除文件
	 * @param path
	 */
	public static void delFile(String path){
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
	}
}
