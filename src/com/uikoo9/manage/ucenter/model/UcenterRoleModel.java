package com.uikoo9.manage.ucenter.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * UcenterRoleModel<br>
 * id	id<br>
 * ucenter_role_name	角色名称<br>
 * ucenter_role_user_ids	角色用户<br>
 * ucenter_role_urls	角色地址<br>
 * cdate	创建时间<br>
 * cuser_id	创建人id<br>
 * cuser_name	创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_ucenter_role")
@SuppressWarnings("serial")
public class UcenterRoleModel extends Model<UcenterRoleModel>{
	
	public static final UcenterRoleModel dao = new UcenterRoleModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<UcenterRoleModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<UcenterRoleModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ucenter_role ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
}
