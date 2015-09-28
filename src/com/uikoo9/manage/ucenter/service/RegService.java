package com.uikoo9.manage.ucenter.service;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.ucenter.model.UcenterRoleRUserModel;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.data.QDateUtil;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.core.file.QPropertiesUtil;
import com.uikoo9.util.function.QEncodeUtil;
import com.uikoo9.util.function.QMailUtil;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.z.QContants;
import com.uikoo9.z.jfinal.QController;

/**
 * Reg Service
 * @author qiaowenbin
 */
public class RegService {
	
	private static final Logger logger = LoggerFactory.getLogger(RegService.class);
	private final String from = QPropertiesUtil.config.getProperty("mail.user.from");
	
	public QJson reg(Map<String, String[]> paras){
		try {
			String usermail = QController.value(paras, "usermail");
			String password = QEncodeUtil.md5Encrypt(QController.value(paras, "password"));
			
			if(QStringUtil.isEmpty(usermail)){
				return QJsonUtil.error("请输入注册邮箱！");
			}
			if(!QStringUtil.isEmail(usermail)){
				return QJsonUtil.error("请输入正确的邮箱！");
			}
			if(checkMail(usermail)){
				return QJsonUtil.error("该邮箱已注册！");
			}
			if(QStringUtil.isEmpty(password)){
				return QJsonUtil.error("请输入登录密码！");
			}
			if(!sendMail(usermail)){
				return QJsonUtil.error("注册确认邮件发送失败！");
			}
			
			saveUser(usermail, password);
			
			return QJsonUtil.suc("注册成功，请前往注册邮箱确认！");
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("注册失败！");
		}
	}
	private boolean checkMail(String usermail){
		String sql = "select count(*) from t_ucenter_user where ucenter_user_mail=?";
		long count = Db.queryLong(sql, usermail);
		
		return count != 0 ? true : false;
	}
	private boolean sendMail(String usermail){
		try {
			String title = "uikoo9.com-注册确认";
			String token = QEncodeUtil.md5Encrypt(usermail + QDateUtil.format(new Date(), "yyyyMMdd"));
			String url = "http://uikoo9.com/reg/regConfirm?mail=" + usermail + "&token=" + QEncodeUtil.urlEncode(token);
			
			StringBuilder sb = new StringBuilder();
			sb.append("欢迎使用“uikoo9.com”<br/><br/>");
			sb.append("请点击确认链接：<a href=\"" + url + "\" target=\"_blank\">" + url + "</a><br/><br/>");
			sb.append("确认链接有效期：1天<br/><br/>");
			sb.append("系统邮件，请勿回复");
			
			return QMailUtil.sendHtmlMail(from, usermail, title, sb.toString());
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return false;
		}
	}
	private void saveUser(String usermail, String password){
		UcenterUserModel user = new UcenterUserModel();
		user.set("ucenter_user_name", usermail);
		user.set("ucenter_user_nickname", usermail);
		user.set("ucenter_user_key", password);
		user.set("ucenter_user_type", QContants.USER_TYPE_CUSTOM);
		user.set("ucenter_user_mail", usermail);
		user.set("ucenter_user_mail_confirm", QContants.YESNO_NO);
		user.set("cdate", new Date());
		user.set("cuser_id", 0);
		user.set("cuser_name", "userreg");
		user.save();
	}
	
	/**
	 * 用户注册确认
	 * @param paras
	 * @return
	 */
	public String regConfirm(Map<String, String[]> paras){
		try {
			String mail  = QController.value(paras, "mail");
			String token = QController.value(paras, "token");
			if(QStringUtil.anyoneEmpty(mail, token)) return "注册失败，请尝试重新点击确认链接！";
			
			String confirmToken = QEncodeUtil.md5Encrypt(mail + QDateUtil.format(new Date(), "yyyyMMdd"));
			if(!token.equals(confirmToken)) return "注册失败，非法的token，请尝试重新点击确认链接！";
			
			Record user = Db.findFirst("select * from t_ucenter_user where ucenter_user_mail=?", mail);
			if(user == null) return "注册失败，未找到该注册邮箱！";
			
			if(QContants.YESNO_YES.equals(user.getStr("ucenter_user_mail_confirm"))){
				return "该邮箱已注册，请<a href=\"http://uikoo9.com/\">登录</a>！";
			}else{
				user.set("ucenter_user_mail_confirm", QContants.YESNO_YES);
				Db.update("t_ucenter_user", user);
				
				new UcenterRoleRUserModel()
					.set("ucenter_role_id", 8)
					.set("ucenter_user_id", user.get("id"))
					.set("ucenter_user_name", user.get("ucenter_user_name"))
					.set("cdate", new Date())
					.set("cuser_id", user.get("cuser_id"))
					.set("cuser_name", user.get("cuser_name"))
					.save();
				
				return "邮箱确认成功，请<a href=\"http://uikoo9.com/\">登录</a>！";
			}
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return "注册确认异常，请尝试重新点击确认链接！";
		}
	}
	
}