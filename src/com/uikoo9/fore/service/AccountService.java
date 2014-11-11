package com.uikoo9.fore.service;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

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
	
	public List<Record> getAccountDetails(){
		String sql = "select ad.*,aa.account_name aname from t_ac_detail ad, t_ac_account aa where ad.account_id=aa.id order by ad.cdate desc";
		return Db.find(sql);
	}
	
}