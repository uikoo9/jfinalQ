package com.uikoo9.manage.ucenter.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;

/**
 * UcenterRoleRUserModel<br>
 * id					id<br>
 * ucenter_role_id		角色id<br>
 * ucenter_user_id		用户id<br>
 * ucenter_user_name	用户姓名<br>
 * cdate				创建时间<br>
 * cuser_id				创建人id<br>
 * cuser_name			创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_ucenter_role_r_user")
@SuppressWarnings("serial")
public class UcenterRoleRUserModel extends Model<UcenterRoleRUserModel>{
	
	public static final UcenterRoleRUserModel dao = new UcenterRoleRUserModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<UcenterRoleRUserModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<UcenterRoleRUserModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ucenter_role_r_user ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
}
