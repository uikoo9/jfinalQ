package com.uikoo9.manage.bill.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * AcDetailModel
 * id 				id<br>
 * accuont_id		账户id<br>
 * bill_detail_shouzhi 	收支明细<br>
 * bill_detail_remark	收支备注<br>
 * cdate			创建时间<br>
 * cuser_id			创建人id<br>
 * cuser_name		创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_bill_detail")
@SuppressWarnings("serial")
public class BillDetailModel extends Model<BillDetailModel>{
	
	public static final BillDetailModel dao = new BillDetailModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<BillDetailModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<BillDetailModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_bill_detail ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by cdate desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
}
