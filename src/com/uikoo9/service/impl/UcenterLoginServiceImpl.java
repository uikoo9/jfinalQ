package com.uikoo9.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.QContants;
import com.uikoo9.service.UcenterLoginServiceI;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QJfinalUtil;

@Service
public class UcenterLoginServiceImpl implements UcenterLoginServiceI{
	
	/* (non-Javadoc)
	 * @see com.uikoo9.service.UcenterLoginServiceI#login(java.util.Map, javax.servlet.http.HttpSession)
	 */
	public String login(Map<String, String[]> paras, HttpSession session){
		String username = QJfinalUtil.value(paras, QContants.C_USERNAME);
		String password = QJfinalUtil.value(paras, QContants.C_PASSWORD);
		
		if(QStringUtil.allNotEmpty(new String[]{username,password})){
			List<Record> users = Db.find(QContants.SQL_UCENTER_USER_LOGIN, username, password);
			if(users != null && users.size() == 1){
				session.setAttribute(QContants.C_USER, users.get(0));
				return null;
			}else{
				return QContants.T_LOGIN_FAIL;
			}
		}else{
			return QContants.T_LOGIN_REQ;
		}
	}
	
}
