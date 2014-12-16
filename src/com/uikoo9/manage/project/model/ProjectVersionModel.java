package com.uikoo9.manage.project.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * 版本迭代
 * id 				id<br>
 * project_detail_id	项目id<br>
 * project_version_code 		版本代号<br>
 * project_version_desc			版本详情<br>
 * cdate			创建时间<br>
 * cuser_id			创建人id<br>
 * cuser_name		创建人姓名<br>
 * @author uikoo9
 */
@QTable("t_project_version")
@SuppressWarnings("serial")
public class ProjectVersionModel extends Model<ProjectVersionModel>{
	
	public static final ProjectVersionModel dao = new ProjectVersionModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<ProjectVersionModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<ProjectVersionModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_project_version ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by cdate desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
}
