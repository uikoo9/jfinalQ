package com.uikoo9.manage.pro.model;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.crud.QTable;

/**
 * 版本迭代
 * @author uikoo9
 */
@QTable("t_pro_version")
@SuppressWarnings("serial")
public class ProVersionModel extends Model<ProVersionModel>{
	
	public static final ProVersionModel dao = new ProVersionModel();
	
}
