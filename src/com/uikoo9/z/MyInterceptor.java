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
		return null;
	}
	
}
