package com.uikoo9.manage.ac.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;
import com.uikoo9.util.file.QCacheUtil;

/**
 * AcAccountModel
 * @author qiaowenbin
 */
@QTable("t_ac_account")
@SuppressWarnings("serial")
public class AcAccountModel extends Model<AcAccountModel>{
	
	public static final AcAccountModel dao = new AcAccountModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<AcAccountModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<AcAccountModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ac_account ");
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
	public List<AcAccountModel> findAllByCache(){
		List<AcAccountModel> accounts = null;
		
		Object value = QCacheUtil.getFromEHCache("accounts");
		if(value == null){
			accounts = AcAccountModel.dao.findAll("order by account_name");
			QCacheUtil.putToEHCache("accounts", accounts);
		}else{
			accounts = (List<AcAccountModel>) value;
		}
		
		return accounts;
	}	
	
	/**
	 * get details
	 * @return
	 */
	public List<AcDetailModel> details(){
		return AcDetailModel.dao.find("select * from t_ac_detail where account_id=? order by id desc", get("id"));
	}
	
}
