package com.uikoo9.fore.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.ac.model.AcDetailModel;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QJson;

/**
 * Account Service
 * @author qiaowenbin
 */
public class AccountService {

	private AccountService() {}
	public static AccountService getInstance() {
		return SingletonFactory.instance;
	}
	private static class SingletonFactory {
		private static AccountService instance = new AccountService();
	}
	
	/**
	 * 获取账户汇总列表
	 * @return
	 */
	public List<Record> getAccountSum(){
		String sql = "SELECT SUM(ad.detail_shouzhi) asum, aa.account_name aname FROM t_ac_detail ad, t_ac_account aa WHERE ad.account_id=aa.id GROUP BY ad.account_id ORDER BY asum DESC";
		return Db.find(sql);
	}
	
	public QJson zhuan(HttpServletRequest request){
		try {
			String shouzhi = request.getParameter("shouzhi");
			String remark = request.getParameter("remark");
			Record user = (Record) request.getAttribute("user");
			
			if(QStringUtil.isEmpty(shouzhi)){
				return new QJson("请填写收支明细！", QJson.TYPE_BS_DANG);
			}
			if(user == null){
				return new QJson("未找到用户信息！", QJson.TYPE_BS_DANG);
			}
			
			AcDetailModel zhuanchu = new AcDetailModel();
			zhuanchu.set("account_id", Integer.parseInt(request.getParameter("accountId1")));
			zhuanchu.set("detail_shouzhi", "-" + shouzhi);
			zhuanchu.set("detail_remark", remark);
			zhuanchu.set("cdate", new Date());
			zhuanchu.set("cuser_id", user.get("id"));
			zhuanchu.set("cuser_name", user.get("user_name"));
			zhuanchu.save();
			
			AcDetailModel zhuanru = new AcDetailModel();
			zhuanru.set("account_id", Integer.parseInt(request.getParameter("accountId2")));
			zhuanru.set("detail_shouzhi", shouzhi);
			zhuanru.set("detail_remark", remark);
			zhuanru.set("cdate", new Date());
			zhuanru.set("cuser_id", user.get("id"));
			zhuanru.set("cuser_name", user.get("user_name"));
			zhuanru.save();
			
			return new QJson("转账成功！", QJson.TYPE_BS_SUCC);
		} catch (Exception e) {
			e.printStackTrace();
			return new QJson("转账失败！", QJson.TYPE_BS_DANG);
		}
	}
	
	/**
	 * 获取转账明细列表
	 * @return
	 */
	public List<Record> getAccountDetails(){
		String sql = "select ad.*,aa.account_name aname from t_ac_detail ad, t_ac_account aa where ad.account_id=aa.id order by ad.cdate desc";
		return Db.find(sql);
	}
	
}