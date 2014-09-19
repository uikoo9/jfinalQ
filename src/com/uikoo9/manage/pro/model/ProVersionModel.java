package com.uikoo9.manage.pro.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * 版本迭代
 * @author uikoo9
 */
@QTable("t_pro_version")
@SuppressWarnings("serial")
public class ProVersionModel extends Model<ProVersionModel>{
	
	public static final ProVersionModel dao = new ProVersionModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<ProVersionModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<ProVersionModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_pro_version ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
}
