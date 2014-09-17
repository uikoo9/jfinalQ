package com.uikoo9.model;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.crud.QTable;

/**
 * 菜单
 * @author uikoo9
 */
@QTable("t_ucenter_menu")
@SuppressWarnings("serial")
public class UcenterMenuModel extends Model<UcenterMenuModel>{
	
	public static final UcenterMenuModel dao = new UcenterMenuModel();
	
}
