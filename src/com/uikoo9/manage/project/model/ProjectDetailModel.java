package com.uikoo9.manage.project.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;
import com.uikoo9.util.file.QCacheUtil;

/**
 * 项目明细
 * id 			id<br>
 * project_name		项目名称<br>
 * project_desc 	项目详情<br>
 * project_url		项目地址<br>
 * project_src		源码地址<br>
 * project_type		项目类型<br>
 * project_sn		项目序号<br>
 * cdate		创建时间<br>
 * cuser_id		创建人id<br>
 * cuser_name	创建人姓名<br>
 * @author uikoo9
 */
@QTable("t_project_detail")
@SuppressWarnings("serial")
public class ProjectDetailModel extends Model<ProjectDetailModel>{
	
	public static final ProjectDetailModel dao = new ProjectDetailModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<ProjectDetailModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<ProjectDetailModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_project_detail ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by cdate desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * find all by cache
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectDetailModel> findAllByCache(){
		List<ProjectDetailModel> proDetails = null;
		
		Object value = QCacheUtil.getFromEHCache("proDetails");
		if(value == null){
			proDetails = ProjectDetailModel.dao.findAll("order by project_sn");
			QCacheUtil.putToEHCache("proDetails", proDetails);
		}else{
			proDetails = (List<ProjectDetailModel>) value;
		}
		
		return proDetails;
	}
	
	/**
	 * get versions
	 * @return
	 */
	public List<ProjectVersionModel> versions(){
		return ProjectVersionModel.dao.find("select * from t_project_version where project_detail_id=? order by id desc", get("id"));
	}
	
}
