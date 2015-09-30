package com.uikoo9.manage.blog.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.function.QCacheUtil;

/**
 * BlogTypeModel
 * id 			id<br>
 * blog_type_name	类型名称<br>
 * cdate		创建时间<br>
 * cuser_id		创建人id<br>
 * cuser_name	创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_blog_type")
@SuppressWarnings("serial")
public class BlogTypeModel extends Model<BlogTypeModel>{
	
	public static final BlogTypeModel dao = new BlogTypeModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<BlogTypeModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<BlogTypeModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_blog_type ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by blog_type_name").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * find all by cache
	 * @param types
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BlogTypeModel> findAllByCache(){
		List<BlogTypeModel> blogTypes = null;
		
		Object value = QCacheUtil.getFromEHCache("blogTypes");
		if(value == null){
			blogTypes = BlogTypeModel.dao.findAll();
			QCacheUtil.putToEHCache("blogTypes", blogTypes);
		}else{
			blogTypes = (List<BlogTypeModel>) value;
		}
		
		return blogTypes;
	}
	
	/**
	 * get articles
	 * @return
	 */
	public List<BlogArticleModel> articles(){
		return BlogArticleModel.dao.find("select * from t_blog_article where blog_type_id=? order by blog_article_title", get("id"));
	}
	
}
