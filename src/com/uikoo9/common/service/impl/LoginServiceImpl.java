package com.uikoo9.common.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.common.service.LoginServiceI;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QJfinalUtil;
import com.uikoo9.z.QContants;

@Service
public class LoginServiceImpl implements LoginServiceI{
	
	/* (non-Javadoc)
	 * @see com.uikoo9.service.UcenterLoginServiceI#login(java.util.Map, javax.servlet.http.HttpSession)
	 */
	public String login(Map<String, String[]> paras, HttpSession session){
		String username = QJfinalUtil.value(paras, "username");
		String password = QJfinalUtil.value(paras, "password");
		
		if(isAdmin(username, password, session)) return "suc";
		if(QStringUtil.allNotEmpty(new String[]{username,password})){
			List<Record> users = Db.find("select * from t_ucenter_user where user_name=? and user_key=?", username, password);
			if(users != null && users.size() == 1){
				session.setAttribute("user", users.get(0));
				return "suc";
			}else{
				return "用户名或密码错误！";
			}
		}else{
			return "请输入用户名和密码！";
		}
	}
	private boolean isAdmin(String username, String password, HttpSession session){
		if(QStringUtil.isAdmin(username, password)){
			Record user = new Record();
			user.set("id", 0);
			user.set("user_name", username);
			user.set("user_key", password);
			user.set("user_type", QContants.C_UCENTER_USER_TYPE_ADMIN);
			user.set("cdate", new Date());
			user.set("cuser_id", 0);
			user.set("cuser_name", "uikoo9");
			session.setAttribute("user", user);
			
			return true;
		}else{
			return false;
		}
	}
	
}
