package com.uikoo9.manage.other.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.function.QCacheUtil;

/**
 * OtherDonateModel<br>
 * id	id<br>
 * other_donate_name	捐助人姓名<br>
 * other_donate_money	捐助金额<br>
 * other_donate_type	捐助类型<br>
 * other_donate_message	捐助寄语<br>
 * cdate				创建时间<br>
 * cuser_id				创建人id<br>
 * cuser_name			创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_other_donate")
@SuppressWarnings("serial")
public class OtherDonateModel extends Model<OtherDonateModel>{
	
	public static final OtherDonateModel dao = new OtherDonateModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<OtherDonateModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<OtherDonateModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_other_donate ");
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
	public List<OtherDonateModel> findAllByCache(){
		List<OtherDonateModel> donates = null;
		
		Object donatesObject = QCacheUtil.getFromEHCache("donates");
		if(donatesObject == null){
			donates = dao.findAll("order by other_donate_money desc");
			QCacheUtil.putToEHCache("donates", donates);
		}else{
			donates = (List<OtherDonateModel>) donatesObject;
		}
		
		return donates;
	}
	
}
