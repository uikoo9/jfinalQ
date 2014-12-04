package com.uikoo9.manage.diary.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * DiaryArticleModel<br>
 * id						id<br>
 * diary_type_id			日记类型<br>
 * diary_article_title		日记标题<br>
 * diary_article_content	日记内容<br>
 * diary_article_readtimes	日记阅读次数<br>
 * cdate					创建时间<br>
 * cuser_id					创建人id<br>
 * cuser_name				创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_diary_article")
@SuppressWarnings("serial")
public class DiaryArticleModel extends Model<DiaryArticleModel>{
	
	public static final DiaryArticleModel dao = new DiaryArticleModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<DiaryArticleModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<DiaryArticleModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_diary_article ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
}
