package com.uikoo9.manage.ucenter.model;

import java.util.List;

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
	
	/**
	 * find all
	 * @return
	 */
	public List<UcenterUserModel> findAll(){
		return dao.find("select * from t_ucenter_user order by id desc");
	}
}
