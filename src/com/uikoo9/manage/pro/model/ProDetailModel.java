package com.uikoo9.manage.pro.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;
import com.uikoo9.util.file.QCacheUtil;

/**
 * 项目明细
 * @author uikoo9
 */
@QTable("t_pro_detail")
@SuppressWarnings("serial")
public class ProDetailModel extends Model<ProDetailModel>{
	
	public static final ProDetailModel dao = new ProDetailModel();
	
	/**
	 * get versions
	 * @return
	 */
	public List<ProVersionModel> versions(){
		return ProVersionModel.dao.find("select * from t_pro_version where pro_detail_id=? order by id desc", get("id"));
	}
	
	/**
	 * find all default
	 * @return
	 */
	public List<ProDetailModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<ProDetailModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_pro_detail ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * find all by cache
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProDetailModel> findAllByCache(){
		List<ProDetailModel> proDetails = null;
		
		Object value = QCacheUtil.getFromEHCache("proDetails");
		if(value == null){
			proDetails = ProDetailModel.dao.findAll("order by pro_sn");
			QCacheUtil.putToEHCache("proDetails", proDetails);
		}else{
			proDetails = (List<ProDetailModel>) value;
		}
		
		return proDetails;
	}
	
	/**
	 * reload all to cache
	 */
	public void reloadAllToCache(){
		QCacheUtil.putToEHCache("proDetails", ProDetailModel.dao.findAll("order by pro_sn"));
	}
	
}
