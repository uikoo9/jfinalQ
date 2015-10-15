package com.uikoo9.manage.ucenter.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.uikoo9.manage.ucenter.model.UcenterMenuModel;
import com.uikoo9.manage.ucenter.model.UcenterRoleRMenuModel;
import com.uikoo9.manage.ucenter.model.UcenterRoleRUserModel;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.plugin.json.QJson;
import com.uikoo9.util.plugin.json.QJsonUtil;

/**
 * Role Service
 * @author qiaowenbin
 */
public class RoleService {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

	/**
	 * 为角色添加一个用户
	 * @param roleId
	 * @param userIds
	 * @param loginUser
	 * @return
	 */
	public QJson addUser(Integer roleId, String userIds, UcenterUserModel loginUser){
		try {
			for(String uid : userIds.split(",")){
				UcenterUserModel user = UcenterUserModel.dao.findById(uid);
				new UcenterRoleRUserModel()
					.set("ucenter_role_id", roleId)
					.set("ucenter_user_id", user.get("id"))
					.set("ucenter_user_name", user.get("ucenter_user_name"))
					.set("cdate", new Date())
					.set("cuser_id", loginUser.get("id"))
					.set("cuser_name", loginUser.get("ucenter_user_name"))
					.save();
			}
			
			return QJsonUtil.suc();
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("添加用户失败 !");
		}
	}
	
	/**
	 * 从角色移除用户
	 * @param rlids
	 * @return
	 */
	public QJson removeUser(String rlids){
		try {
			for(String rlid : rlids.split(",")){
				UcenterRoleRUserModel.dao.deleteById(rlid);
			}
			
			return QJsonUtil.suc();
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("移除用户失败 !");
		}
	}
	
	/**
	 * 为角色添加或删除url
	 * @param roleId
	 * @param ids
	 * @param loginUser
	 * @return
	 */
	public QJson saveUrl(Integer roleId, String ids, UcenterUserModel loginUser){
		try {
			Db.update("delete from t_ucenter_role_r_menu where ucenter_role_id=?", roleId);
			
			if(QStringUtil.notEmpty(ids)){
				for(String id : ids.split(",")){
					if(!"0".equals(id)){
						new UcenterRoleRMenuModel()
							.set("ucenter_role_id", roleId)
							.set("ucenter_menu_id", id)
							.set("ucenter_menu_url", UcenterMenuModel.dao.findById(id).getStr("ucenter_menu_url"))
							.set("cdate", new Date())
							.set("cuser_id", loginUser.get("id"))
							.set("cuser_name", loginUser.get("ucenter_user_name"))
							.save();
					}
				}
			}

			return QJsonUtil.suc();
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
			return QJsonUtil.error("添加Url失败 !");
		}
	}
	
}