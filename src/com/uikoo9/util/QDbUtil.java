package com.uikoo9.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 数据库工具类
 * 1.打开连接
 * 2.关闭连接
 * 3.更新数据
 * 4.查询数据
 * 5.通过表名获取表的主键
 * 6.通过表名获取表的列信息,包括列名和列类型
 * 7.获取和clazzName对应的表名
 * 8.将数据库类型转为java类型
 * @author uikoo9
 * @version 0.0.3.20140522
 */
public class QDbUtil {
	
	/**
	 * 获取数据库连接
	 * @param path 数据库配置文件地址
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon(String path) throws Exception{
		Properties properties = new Properties();
		properties.load(QDbUtil.class.getResourceAsStream(path));
		
		return getCon(properties);
	}
	
	/**
	 * 获取数据库连接
	 * @param dbDriver jdbc驱动
	 * @param dbUrl 数据库地址
	 * @param dbUsername 用户名
	 * @param dbPassword 密码
	 * @return 数据库连接
	 * @throws Exception 异常
	 */
	public static Connection getCon(Properties properties) throws Exception{
		String dbDriver = properties.getProperty("dbDriver");
		String dbUrl = properties.getProperty("dbUrl");
		String dbUsername = properties.getProperty("dbUsername");
		String dbPassword = properties.getProperty("dbPassword");
		
		Class.forName(dbDriver);
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}
	
	/**
	 * 关闭连接
	 * @param con 连接
	 * @throws Exception 异常
	 */
	public static void closeCon(Connection con) throws Exception{
		if(con != null) con.close();
	}
	
	/**
	 * 执行sql的封装
	 * @param con 数据库连接
	 * @param sql sql
	 * @param params 参数
	 * @return 结果
	 * @throws SQLException 异常
	 */
	public static int update(Connection con, String sql, Object... params) throws SQLException{
		PreparedStatement ps = con.prepareStatement(sql);
		
		int index = 1;
		for(Object object : params){
			ps.setObject(index++, object);
		}
		
		return ps.executeUpdate();
	}
	
	/**
	 * 执行sql的封装
	 * @param con
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int update(Connection con, String sql, List<Object> params) throws SQLException{
		PreparedStatement ps = con.prepareStatement(sql);
		
		int index = 1;
		for(Object object : params){
			ps.setObject(index++, object);
		}
		
		return ps.executeUpdate();
	}
	
	/**
	 * 通过sql得到查询结果
	 * @param con 数据库连接
	 * @param page 分页信息
	 * @param sql sql语句
	 * @return 结果集
	 * @throws Exception 异常
	 */
	public static ResultSet query(Connection con, String sql, QPage page) throws Exception{
		StringBuilder sb = new StringBuilder(sql);
		
		// 添加分页信息
		if(page != null){
			sb.append(" limit " + page.getStart() + "," + page.getRows());
		}
		
		return con.prepareStatement(sb.toString()).executeQuery();
	}
	
	/**
	 * 对count方法的封装
	 * @param con
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static int count(Connection con, String sql) throws Exception{
		ResultSet rs = con.prepareStatement(sql).executeQuery();

		return rs.next() ? rs.getInt(1) : 0;
	}
	
	/**
	 * 通过表名获取表的主键
	 * @param con
	 * @param tableName
	 * @return
	 */
	public static String getPkName(Connection con, String tableName) throws Exception{
		ResultSet pkrs = con.getMetaData().getPrimaryKeys(null, null, tableName);
		return pkrs.next() ? pkrs.getString("COLUMN_NAME") : null;
	}
	
	/**
	 * 通过表名获取表的列信息，包括列名，列类型，列注释
	 * @param con
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, String>> getCols(Connection con, String tableName) throws Exception{
		List<Map<String, String>> cols = new ArrayList<Map<String,String>>();
		
		String pkName = getPkName(con, tableName);
		ResultSet colrs = con.getMetaData().getColumns(null, "%", tableName, "%");
		while(colrs.next()){
			if(QStringUtil.notEmpty(pkName) && !pkName.equals(colrs.getString("COLUMN_NAME"))){
				Map<String, String> col = new HashMap<String, String>();
				col.put("colname", colrs.getString("COLUMN_NAME"));
				col.put("coltype", colrs.getString("TYPE_NAME"));
				col.put("remarks", colrs.getString("REMARKS"));
				
				cols.add(col);
			}
		}
		
		return cols;
	}
	
	/**
	 * 获取和clazzName对应的表名
	 * @param clazzName
	 * @return
	 */
	public static String getTableNameFromClazzName(String clazzName){
		StringBuilder sb = new StringBuilder("t");
		
		List<String> names = QStringUtil.tuoFeng(clazzName);
		for(String s: names){
			sb.append("_" + s.toLowerCase());
		}
		
		return sb.toString();
	}
	
	/**
	 * 通过表名获取对应的class名
	 * @param tableName
	 * @return
	 */
	public static String getClassNameFromTableName(String tableName){
		StringBuilder sb = new StringBuilder();
		if(QStringUtil.notEmpty(tableName)){
			String[] ss = tableName.split("_");
			for(int i=1; i<ss.length; i++){
				sb.append(QStringUtil.firstUpper(ss[i].toLowerCase()));
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 将mysql的数据类型转换为java的数据类型
	 * @param mysqlType
	 * @return
	 */
	public static String mysqlToJava(String mysqlType){
		if(QStringUtil.notEmpty(mysqlType)){
			if(mysqlType.equals("VARCHAR")){
				return "String";
			}
			if(mysqlType.equals("CHAR")){
				return "String";
			}
			if(mysqlType.equals("BLOB")){
				return "byte[]";
			}
			if(mysqlType.equals("TEXT")){
				return "String";
			}
			if(mysqlType.equals("INT")){
				return "Integer";
			}
			if(mysqlType.equals("BIGINT")){
				return "BigInteger";
			}
			if(mysqlType.equals("FLOAT")){
				return "Float";
			}
			if(mysqlType.equals("DOUBLE")){
				return "Double";
			}
			if(mysqlType.equals("DATE")){
				return "Date";
			}
			if(mysqlType.equals("TIME")){
				return "Time";
			}
			if(mysqlType.equals("DATETIME")){
				return "Timestamp";
			}
			if(mysqlType.equals("TIMESTAMP")){
				return "Timestamp";
			}
			
			return null;
		}else{
			return null;
		}
	}
	
}
