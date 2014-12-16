package com.uikoo9.manage.bill.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;
import com.uikoo9.util.file.QCacheUtil;

/**
 * AcAccountModel<br>
 * id 			id<br>
 * bill_account_name 账户名称<br>
 * bill_account_desc 账户描述<br>
 * cdate		创建时间<br>
 * cuser_id		创建人id<br>
 * cuser_name	创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_bill_account")
@SuppressWarnings("serial")
public class BillAccountModel extends Model<BillAccountModel>{
	
	public static final BillAccountModel dao = new BillAccountModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<BillAccountModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<BillAccountModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_bill_account ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by cdate desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * find all by cache
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BillAccountModel> findAllByCache(){
		List<BillAccountModel> accounts = null;
		
		Object value = QCacheUtil.getFromEHCache("accounts");
		if(value == null){
			accounts = BillAccountModel.dao.findAll("order by bill_account_name");
			QCacheUtil.putToEHCache("accounts", accounts);
		}else{
			accounts = (List<BillAccountModel>) value;
		}
		
		return accounts;
	}
	
	/**
	 * get details
	 * @return
	 */
	public List<BillDetailModel> details(){
		return BillDetailModel.dao.find("select * from t_bill_detail where bill_account_id=? order by id desc", get("id"));
	}
	
}
