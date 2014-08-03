package com.uikoo9.util.jfinal;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.uikoo9.util.QRequestUtil;

/**
 * 拦截器
 * @author uikoo9
 * @version 0.0.3.20140801
 */
public class QInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		controller.setAttr("base", QRequestUtil.getHttpPath(controller.getRequest()));
		
		ai.invoke();
	}
	
}
