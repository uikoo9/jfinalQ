package com.uikoo9.manage.ucenter.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;

/**
 * UcenterRoleRMenuModel<br>
 * id				id<br>
 * ucenter_role_id	角色id<br>
 * ucenter_menu_id	菜单id<br>
 * ucenter_menu_url	菜单url<br>
 * cdate			创建时间<br>
 * cuser_id			创建人id<br>
 * cuser_name		创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_ucenter_role_r_menu")
@SuppressWarnings("serial")
public class UcenterRoleRMenuModel extends Model<UcenterRoleRMenuModel>{
	
	public static final UcenterRoleRMenuModel dao = new UcenterRoleRMenuModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<UcenterRoleRMenuModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<UcenterRoleRMenuModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_ucenter_role_r_menu ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
}
