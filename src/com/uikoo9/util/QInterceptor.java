package com.uikoo9.util;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

/**
 * session拦截器，校验是否登录
 * @author uikoo9
 * @version 0.0.2.20140603
 */
public class QInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		controller.setAttr("base", QRequestUtil.getHttpPath(controller.getRequest()));
		
		ai.invoke();
	}
	
}
