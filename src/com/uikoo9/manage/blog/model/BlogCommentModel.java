package com.uikoo9.manage.blog.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QTable;

/**
 * BlogCommentModel<br>
 * id						id<br>
 * blog_id					博客id<br>
 * blog_comment_uname		博客评论昵称<br>
 * blog_comment_content		博客评论内容<br>
 * blog_comment_parent_id	博客评论父id<br>
 * cdate					创建时间<br>
 * cuser_id					创建人id<br>
 * cuser_name				创建人姓名<br>
 * @author qiaowenbin
 */
@QTable("t_blog_comment")
@SuppressWarnings("serial")
public class BlogCommentModel extends Model<BlogCommentModel>{
	
	public static final BlogCommentModel dao = new BlogCommentModel();
	
	/**
	 * find all
	 * @return
	 */
	public List<BlogCommentModel> findAll(){
		return findAll(null);
	}
	
	/**
	 * find all by order
	 * @param order
	 * @return
	 */
	public List<BlogCommentModel> findAll(String order){
		StringBuilder sb = new StringBuilder("select * from t_blog_comment ");
		if(QStringUtil.isEmpty(order)){
			return dao.find(sb.append("order by id desc").toString());
		}else{
			return dao.find(sb.append(order).toString());
		}
	}
	
	/**
	 * get child comments
	 * @return
	 */
	public List<BlogCommentModel> comments(){
		return BlogCommentModel.dao.find("select * from t_blog_comment where blog_id=? and blog_comment_parent_id=? order by cdate desc", get("blog_id"), get("id"));
	}
	
}
