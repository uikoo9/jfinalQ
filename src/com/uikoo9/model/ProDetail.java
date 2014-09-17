package com.uikoo9.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.crud.QTable;

/**
 * 项目明细
 * @author uikoo9
 */
@QTable("t_pro_detail")
@SuppressWarnings("serial")
public class ProDetail extends Model<ProDetail>{
	
	public static final ProDetail dao = new ProDetail();
	
	public List<ProVersion> versions(){
		return ProVersion.dao.find("select * from t_pro_version where pro_id=?", get("id"));
	}
	
}
