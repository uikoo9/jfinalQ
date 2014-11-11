package com.uikoo9.manage.ac.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * AcDetailModel
 * @author qiaowenbin
 */
@QTable("t_ac_detail")
@SuppressWarnings("serial")
public class AcDetailModel extends Model<AcDetailModel>{
	
	public static final AcDetailModel dao = new AcDetailModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<AcDetailModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<AcDetailModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ac_detail ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
}
