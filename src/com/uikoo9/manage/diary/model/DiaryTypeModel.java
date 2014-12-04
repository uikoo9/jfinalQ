package com.uikoo9.manage.diary.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;
import com.uikoo9.util.file.QCacheUtil;

/**
 * DiaryTypeModel<br>
 * id				id<br>
 * diary_type_name	日记类型名称<br>
 * cdate			创建时间<br>
 * cuser_id			创建人id<br>
 * cuser_name		创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_diary_type")
@SuppressWarnings("serial")
public class DiaryTypeModel extends Model<DiaryTypeModel>{
	
	public static final DiaryTypeModel dao = new DiaryTypeModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<DiaryTypeModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<DiaryTypeModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_diary_type ");
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
	public List<DiaryTypeModel> findAllByCache(){
		return findAllByCache(DiaryTypeModel.dao.findAll("order by diary_type_name"));
	}
	
	/**
	 * find all by cache
	 * @param types
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DiaryTypeModel> findAllByCache(List<DiaryTypeModel> types){
		List<DiaryTypeModel> diaryTypes = null;
		
		Object value = QCacheUtil.getFromEHCache("diaryTypes");
		if(value == null){
			diaryTypes = types;
			QCacheUtil.putToEHCache("diaryTypes", diaryTypes);
		}else{
			diaryTypes = (List<DiaryTypeModel>) value;
		}
		
		return diaryTypes;
	}
	
	/**
	 * get articles
	 * @return
	 */
	public List<DiaryTypeModel> articles(){
		return DiaryTypeModel.dao.find("select * from t_diary_article where diary_type_id=? order by diary_article_title", get("id"));
	}
	
}
