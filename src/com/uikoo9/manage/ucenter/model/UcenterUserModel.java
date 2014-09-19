package com.uikoo9.manage.ucenter.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
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
	 * find all default
	 * @return
	 */
	public List<UcenterUserModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<UcenterUserModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ucenter_user ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
}
