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
		
		// set base path
		controller.setAttr("base", QRequestUtil.getHttpPath(controller.getRequest()));
		ai.invoke();
		
		// can visit
//		if(canVisit(ai)){
//			ai.invoke();
//		}else{
//			controller.redirect("/md5");
//		}
	}
	
	/**
	 * 判断是否可以访问系统
	 * @param ai
	 * @return
	 */
	private boolean canVisit(ActionInvocation ai){
		if(notLogin(ai)) return false;
		
		return true;
	}
	
	/**
	 * 校验用户是否登录
	 * @param ai
	 * @return
	 */
	private boolean notLogin(ActionInvocation ai){
		return !ai.getActionKey().startsWith("/md5") && ai.getController().getSessionAttr("user") == null;
	}
	
}
