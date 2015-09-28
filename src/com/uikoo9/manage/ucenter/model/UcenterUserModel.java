package com.uikoo9.manage.ucenter.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;

/**
 * UcenterUserModel<br>
 * id							id<br>
 * ucenter_user_name			用户名<br>
 * ucenter_user_nickname		用户昵称<br>
 * ucenter_user_key				用户密码<br>
 * ucenter_user_type			用户类型<br>
 * ucenter_user_mail			用户邮箱<br>
 * ucenter_user_mail_confirm	用户邮箱确认<br>
 * cdate						创建时间<br>
 * cuser_id						创建人id<br>
 * cuser_name					创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_ucenter_user")
@SuppressWarnings("serial")
public class UcenterUserModel extends Model<UcenterUserModel>{

	public static final UcenterUserModel dao = new UcenterUserModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<UcenterUserModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<UcenterUserModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ucenter_user ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * 获取用户对应的角色
	 * @return
	 */
	public UcenterRoleModel role(){
		return UcenterRoleModel.dao.findFirst("select ur.* from t_ucenter_role ur, t_ucenter_role_r_user rl where ur.id=rl.ucenter_role_id and rl.ucenter_user_id=?", get("id"));
	}
}
