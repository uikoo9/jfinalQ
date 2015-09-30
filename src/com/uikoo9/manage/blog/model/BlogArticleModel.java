package com.uikoo9.manage.blog.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.core.annotation.QTable;
import com.uikoo9.util.core.data.QStringUtil;

/**
 * BlogArticleModel
 * id 					rid<br>
 * blog_type_id			类型id<br>
 * blog_article_title	文章标题<br>
 * blog_article_content	文章内容<br>
 * blog_article_code	文章code<br>
 * cdate				创建时间<br>
 * cuser_id				创建人id<br>
 * cuser_name			创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_blog_article")
@SuppressWarnings("serial")
public class BlogArticleModel extends Model<BlogArticleModel>{
	
	public static final BlogArticleModel dao = new BlogArticleModel();
	
	/**
	 * find all default
	 * @return
	 */
	public List<BlogArticleModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all with order
	 * @param order
	 * @return
	 */
	public List<BlogArticleModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_blog_article ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by cdate desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * find by code
	 * @return
	 */
	public BlogArticleModel findByCode(String blogCode){
		return BlogArticleModel.dao.findFirst("select * from t_blog_article where blog_article_code=?", blogCode);
	}
	
}