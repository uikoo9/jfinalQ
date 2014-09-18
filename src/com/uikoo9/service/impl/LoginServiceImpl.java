package com.uikoo9.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.service.LoginServiceI;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QJfinalUtil;

@Service
public class LoginServiceImpl implements LoginServiceI{
	
	/* (non-Javadoc)
	 * @see com.uikoo9.service.UcenterLoginServiceI#login(java.util.Map, javax.servlet.http.HttpSession)
	 */
	public String login(Map<String, String[]> paras, HttpSession session){
		String username = QJfinalUtil.value(paras, "username");
		String password = QJfinalUtil.value(paras, "password");
		
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
	
}
