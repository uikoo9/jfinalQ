package com.uikoo9.manage.ucenter.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.data.QArrayUtil;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.core.http.QCookieUtil;
import com.uikoo9.util.function.QCacheUtil;
import com.uikoo9.util.function.QEncodeUtil;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;
import com.uikoo9.z.jfinal.QController;

/**
 * Login Service
 * @author qiaowenbin
 */
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	/**
	 * 登录
	 * @param paras
	 * @param response
	 * @return
	 */
	public QJson login(Map<String, String[]> paras, HttpServletResponse response){
		try {
			String username = QController.value(paras, "usermail");
			String password = QEncodeUtil.md5Encrypt(QController.value(paras, "password"));
			if(QStringUtil.allNotEmpty(new String[]{username,password})){
				List<UcenterUserModel> nameUsers = UcenterUserModel.dao.find("select * from t_ucenter_user where ucenter_user_name=?", username);
				if(QArrayUtil.isEmpty(nameUsers)) return QJsonUtil.error("该用户名不存在！");
				
				List<UcenterUserModel> checkUsers = UcenterUserModel.dao.find("select * from t_ucenter_user where ucenter_user_name=? and ucenter_user_key=?", username, password);
				if(checkUsers == null || checkUsers.size() != 1) return QJsonUtil.error("用户名或密码错误！");
				
				UcenterUserModel user = checkUsers.get(0);
				putInCookie(user, response);
				if("admin".equals(user.getStr("ucenter_user_name"))){
					return QJsonUtil.suc("/manage");
				}else{
					return QJsonUtil.suc(user.role().getStr("ucenter_role_login_url"));
				}
			}else{
				return QJsonUtil.error("请输入用户名和密码！");
			}
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("登录失败！");
		}
	}
	private void putInCookie(UcenterUserModel user, HttpServletResponse response){
		String userId = genUserId(user.getStr("ucenter_user_name"));
		if(QStringUtil.notEmpty(userId)){
			QCookieUtil.setCookie(response, "uikoo9userid", userId, 24*60*60);
			QCacheUtil.putToEHCache(userId, user);
		}
	}
	private String genUserId(String username){
		try {
			return QEncodeUtil.md5Encrypt("qiaowenbin" + username);
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
		}
		
		return null;
	}
	
	/**
	 * 退出登录
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response){
		String url = null;
		try {
			UcenterUserModel user = (UcenterUserModel) request.getAttribute("user");
			url = user.role().getStr("ucenter_role_login_url"); 
			
			String cookieUserId = QCookieUtil.getValue(request, "uikoo9userid");
			if(QStringUtil.notEmpty(cookieUserId)){
				QCacheUtil.removeEHCache(cookieUserId);
				QCookieUtil.removeCookie(response, "uikoo9userid");
			}
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
		}
		
		return url;
	}
	
	/**
	 * 修改昵称
	 * @param paras
	 * @param session
	 * @return
	 */
	public QJson modifyNickname(Map<String, String[]> paras, HttpServletRequest request){
		try {
			String nickname = QController.value(paras, "nickname");
			if(checkNickname(nickname)){
				return QJsonUtil.error("改昵称已经存在，换一个吧~");
			}
			
			int id = ((UcenterUserModel) request.getAttribute("user")).getInt("id");
			Db.update("update t_ucenter_user set ucenter_user_nickname=? where id=?", nickname, id);
			
			return QJsonUtil.suc("修改昵称成功，请重新登录!");
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("修改昵称失败!");
		}
	}
	private boolean checkNickname(String nickname){
		String sql = "select count(*) from t_ucenter_user where ucenter_user_nickname=?";
		long count = Db.queryLong(sql, nickname);
		
		return count != 0 ? true : false;
	}
	
	/**
	 * 修改密码
	 * @param paras
	 * @param session
	 * @return
	 */
	public QJson modifyPwd(Map<String, String[]> paras, HttpServletRequest request){
		try {
			String newpwd = QEncodeUtil.md5Encrypt(QController.value(paras, "password"));
			int id = ((UcenterUserModel) request.getAttribute("user")).getInt("id");
			Db.update("update t_ucenter_user set ucenter_user_key=? where id=?", newpwd, id);

			return QJsonUtil.suc("修改密码成功，请重新登录!");
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("修改密码失败!");
		}
	}
	
}