package com.uikoo9.fore.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.file.QCacheUtil;
import com.uikoo9.util.file.QEncodeUtil;
import com.uikoo9.util.http.QCookieUtil;
import com.uikoo9.util.jfinal.QJfinalUtil;
import com.uikoo9.z.QContants;

/**
 * Login Service
 * @author qiaowenbin
 */
public class LoginService {

	private LoginService() {}
	public static LoginService getInstance() {
		return SingletonFactory.instance;
	}
	private static class SingletonFactory {
		private static LoginService instance = new LoginService();
	}
	
	/**
	 * 登录
	 * @param paras
	 * @param response
	 * @return
	 */
	public String login(Map<String, String[]> paras, HttpServletResponse response){
		try {
			String username = QJfinalUtil.value(paras, "username");
			String password = QEncodeUtil.md5Encrypt(QJfinalUtil.value(paras, "password"));
			if(isAdmin(username, password, response)) return "admin";
			if(QStringUtil.allNotEmpty(new String[]{username,password})){
				List<Record> users = Db.find("select * from t_ucenter_user where user_name=? and user_key=?", username, password);
				if(users != null && users.size() == 1){
					putInCookie(users.get(0), response);

					String type = users.get(0).getStr("user_type");
					if(type.equals(QContants.C_UCENTER_USER_TYPE_CUSTOM)){
						return "user";
					}else if(type.equals(QContants.C_UCENTER_USER_TYPE_ADMIN)){
						return "admin";
					}else if(type.equals(QContants.C_UCENTER_USER_TYPE_ACCOUNT)){
						return "account";
					}else{
						return "错误的用户类型";
					}
				}else{
					return "用户名或密码错误！";
				}
			}else{
				return "请输入用户名和密码！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "登录失败";
		}
	}
	private boolean isAdmin(String username, String password, HttpServletResponse response){
		if(QStringUtil.isAdmin(username, password)){
			Record user = new Record();
			user.set("id", 0);
			user.set("user_name", username);
			user.set("user_key", password);
			user.set("user_type", QContants.C_UCENTER_USER_TYPE_ADMIN);
			user.set("cdate", new Date());
			user.set("cuser_id", 0);
			user.set("cuser_name", "uikoo9");
			putInCookie(user, response);
			
			return true;
		}else{
			return false;
		}
	}
	private void putInCookie(Record user, HttpServletResponse response){
		String userId = QStringUtil.genUserId(user.getStr("user_name"));
		if(QStringUtil.notEmpty(userId)){
			QCookieUtil.setCookie(response, "uikoo9userid", userId, 1800);
			QCacheUtil.putToEHCache(userId, user);
		}
	}

}