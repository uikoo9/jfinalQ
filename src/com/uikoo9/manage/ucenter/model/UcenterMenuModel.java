package com.uikoo9.manage.ucenter.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * 菜单
 * @author uikoo9
 */
@QTable("t_ucenter_menu")
@SuppressWarnings("serial")
public class UcenterMenuModel extends Model<UcenterMenuModel>{
	
	public static final UcenterMenuModel dao = new UcenterMenuModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<UcenterMenuModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<UcenterMenuModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ucenter_menu ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
}
