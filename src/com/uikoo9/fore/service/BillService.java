package com.uikoo9.fore.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.bill.model.BillDetailModel;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;
import com.uikoo9.util.crud.QJsonUtil;
import com.uikoo9.util.ucenter.model.UcenterUserModel;

/**
 * Account Service
 * @author qiaowenbin
 */
public class BillService {

	private BillService() {}
	public static BillService getInstance() {
		return SingletonFactory.instance;
	}
	private static class SingletonFactory {
		private static BillService instance = new BillService();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(BillService.class);
	
	/**
	 * 获取账户汇总列表
	 * @return
	 */
	public List<Record> getAccountSum(){
		String sql = "SELECT SUM(ad.bill_detail_shouzhi) asum, aa.bill_account_name aname FROM t_bill_detail ad, t_bill_account aa WHERE ad.bill_account_id=aa.id GROUP BY ad.bill_account_id ORDER BY asum DESC";
		return Db.find(sql);
	}
	
	public QJson zhuan(HttpServletRequest request){
		try {
			String shouzhi = request.getParameter("shouzhi");
			String remark = request.getParameter("remark");
			UcenterUserModel user = (UcenterUserModel) request.getAttribute("user");
			
			if(QStringUtil.isEmpty(shouzhi)){
				return QJsonUtil.error("请填写收支明细！");
			}
			if(user == null){
				return QJsonUtil.error("未找到用户信息！");
			}
			
			BillDetailModel zhuanchu = new BillDetailModel();
			zhuanchu.set("bill_account_id", Integer.parseInt(request.getParameter("accountId1")));
			zhuanchu.set("bill_detail_shouzhi", "-" + shouzhi);
			zhuanchu.set("bill_detail_remark", remark);
			zhuanchu.set("cdate", new Date());
			zhuanchu.set("cuser_id", user.get("id"));
			zhuanchu.set("cuser_name", user.get("ucenter_user_name"));
			zhuanchu.save();
			
			BillDetailModel zhuanru = new BillDetailModel();
			zhuanru.set("bill_account_id", Integer.parseInt(request.getParameter("accountId2")));
			zhuanru.set("bill_detail_shouzhi", shouzhi);
			zhuanru.set("bill_detail_remark", remark);
			zhuanru.set("cdate", new Date());
			zhuanru.set("cuser_id", user.get("id"));
			zhuanru.set("cuser_name", user.get("ucenter_user_name"));
			zhuanru.save();
			
			return QJsonUtil.suc("转账成功！");
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("转账失败！");
		}
	}
	
	/**
	 * 获取转账明细列表
	 * @return
	 */
	public List<Record> getAccountDetails(){
		String sql = "select ad.*,aa.bill_account_name aname from t_bill_detail ad, t_bill_account aa where ad.bill_account_id=aa.id order by ad.cdate desc";
		return Db.find(sql);
	}
	
}