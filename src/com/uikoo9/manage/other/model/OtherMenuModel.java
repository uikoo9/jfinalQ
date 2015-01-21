package com.uikoo9.manage.other.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;

/**
 * OtherMenuModel<br>
 * id	id<br>
 * ucenter_menu_title	菜单名称<br>
 * ucenter_menu_url	菜单地址<br>
 * ucenter_menu_sn	菜单序号<br>
 * ucenter_menu_type	菜单类型<br>
 * ucenter_menu_parent_id	菜单父id<br>
 * cdate	创建时间<br>
 * cuser_name	创建人姓名<br>
 * cuser_id	创建人id<br>
 * @author qiaowenbin
 */
@QTable("t_other_menu")
@SuppressWarnings("serial")
public class OtherMenuModel extends Model<OtherMenuModel>{
	
	public static final OtherMenuModel dao = new OtherMenuModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<OtherMenuModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<OtherMenuModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_other_menu ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * get submenus
	 * @return
	 */
	public List<OtherMenuModel> submenus(){
		return OtherMenuModel.dao.find("select * from t_other_menu where ucenter_menu_parent_id=? order by ucenter_menu_sn", get("id"));
	}
	
}
