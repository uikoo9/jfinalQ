package com.uikoo9.z;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.plugin.json.QJsonUtil;

/**
 * 自定义拦截器，区别于jar中的QInterceptor
 * @author qiaowenbin
 */
public class MyInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		String res = checkAuth(ai); 
		if(res == null){
			ai.invoke();
		}else{
			ai.getController().renderJson(QJsonUtil.error(res + "，体验所有功能请下载源码！"));
		}
	}
	
	/**
	 * 屏蔽掉演示系统的一些权限，自己使用的时候可以修改或去掉
	 * @param ai
	 * @return
	 */
	private String checkAuth(ActionInvocation ai){
		String url = ai.getActionKey();
		Controller cl = ai.getController();
		
		// 禁止修改密码
		if("/login/modifyPwd".equals(url)){
			return "禁止修改密码";
		}
		
		// 禁止修改默认博客
		if("/blog/edit".equals(url) && "32".equals(cl.getPara())){
			return "禁止修改默认博客";
		}
		
		// 禁止修改，删除默认博客分类
		if("/blog/type/save".equals(url) && "10".equals(cl.getPara("row.id"))){
			return "禁止修改默认博客分类";
		}
		if("/blog/type/del".equals(url)){
			String ids = cl.getPara("ids");
			if(QStringUtil.notEmpty(ids)){
				for(String id : ids.split(",")){
					if("10".equals(id)){
						return "禁止删除默认博客分类";
					}
				}
			}
		}
		
		// 禁止修改，删除默认博客
		if("/blog/article/save".equals(url) && "32".equals(cl.getPara("row.id"))){
			return "禁止修改默认博客";
		}
		if("/blog/article/del".equals(url)){
			String ids = cl.getPara("ids");
			if(QStringUtil.notEmpty(ids)){
				for(String id : ids.split(",")){
					if("32".equals(id)){
						return "禁止删除默认博客";
					}
				}
			}
		}
		
		// 禁止修改，删除默认评论
		if("/blog/comment/save".equals(url) && ("17".equals(cl.getPara("row.id")) || "18".equals(cl.getPara("row.id")))){
			return "禁止修改默认博客评论";
		}
		if("/blog/comment/del".equals(url)){
			String ids = cl.getPara("ids");
			if(QStringUtil.notEmpty(ids)){
				for(String id : ids.split(",")){
					if("17".equals(id) || "18".equals(id)){
						return "禁止删除默认博客评论";
					}
				}
			}
		}
		
		// 禁止修改，删除默认用户
		if("/ucenter/user/save".equals(url) && ("2".equals(cl.getPara("row.id")) || "4".equals(cl.getPara("row.id")))){
			return "禁止修改默认用户";
		}
		if("/ucenter/user/del".equals(url)){
			String ids = cl.getPara("ids");
			if(QStringUtil.notEmpty(ids)){
				for(String id : ids.split(",")){
					if("2".equals(id) || "4".equals(id)){
						return "禁止删除默认用户";
					}
				}
			}
		}
		
		// 禁止修改，删除默认角色
		if("/ucenter/role/save".equals(url) && ("4".equals(cl.getPara("row.id")))){
			return "禁止修改默认角色";
		}
		if("/ucenter/role/del".equals(url)){
			String ids = cl.getPara("ids");
			if(QStringUtil.notEmpty(ids)){
				for(String id : ids.split(",")){
					if("4".equals(id)){
						return "禁止删除默认角色";
					}
				}
			}
		}
		
		// 默认角色禁止分配用户
		if("/ucenter/role/addUser".equals(url) && ("4".equals(cl.getPara("roleid")))){
			return "禁止为默认角色分配用户";
		}
		if("/ucenter/role/removeUser".equals(url) && ("4".equals(cl.getPara("roleid")))){
			return "禁止为默认角色移除用户";
		}
		if("/ucenter/role/saveUrl".equals(url) && ("4".equals(cl.getPara("roleid")))){
			return "禁止为默认角色分配权限";
		}
		
		// 禁止删除，修改和添加菜单
		if("/ucenter/menu/del".equals(url)){
			return "禁止删除菜单";
		}
		if("/ucenter/menu/save".equals(url)){
			return "禁止修改和添加菜单";
		}
		
		return null;
	}
	
}
