package com.uikoo9.z;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
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
			ai.getController().renderJson(QJsonUtil.error(res));
		}
	}
	
	/**
	 * 屏蔽掉演示系统的一些权限，自己使用的时候可以修改或去掉
	 * @param ai
	 * @return
	 */
	private String checkAuth(ActionInvocation ai){
		String url = ai.getActionKey();
		String para = ai.getController().getPara();
		
		// 禁止修改密码
		if("/login/modifyPwd".equals(url)){
			return "禁止修改密码，体验所有功能请下载源码！";
		}
		
		// 禁止修改默认博客
		if("/blog/edit".equals(url) && "32".equals(para)){
			return "禁止修改默认博客，体验所有功能请下载源码！";
		}
		
		System.out.println(url);
		
		return null;
	}
	
}
