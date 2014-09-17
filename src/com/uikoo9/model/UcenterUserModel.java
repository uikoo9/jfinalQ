package com.uikoo9.model;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.crud.QTable;

/**
 * 用户
 * @author uikoo9
 */
@QTable("t_ucenter_user")
@SuppressWarnings("serial")
public class UcenterUserModel extends Model<UcenterUserModel>{

	public static final UcenterUserModel dao = new UcenterUserModel();
	
}
