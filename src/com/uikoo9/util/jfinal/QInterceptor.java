package com.uikoo9.util.jfinal;

import java.util.Properties;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.uikoo9.util.QFileUtil;
import com.uikoo9.util.QRequestUtil;
import com.uikoo9.util.QStringUtil;

/**
 * 拦截器
 * @author uikoo9
 * @version 0.0.4.20140803
 */
public class QInterceptor implements Interceptor{
	
	private static Properties properties = QFileUtil.readProperties("/config.properties");

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		
		// set base path
		controller.setAttr(properties.getProperty("basePath"), QRequestUtil.getHttpPath(controller.getRequest()));
		
		// can visit
		if(canVisit(ai) || isLogin(ai)){
			ai.invoke();
		}else{
			controller.redirect(properties.getProperty("indexPage"));
		}
	}
	
	/**
	 * 判断是否可以访问系统
	 * @param ai
	 * @return
	 */
	private boolean canVisit(ActionInvocation ai){
		String paths = properties.getProperty("canVisitPaths");
		
		if(QStringUtil.notEmpty(paths)){
			String[] ss = paths.split(",");
			for(String path : ss){
				if(ai.getActionKey().equals(path)) return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 校验用户是否登录
	 * @param ai
	 * @return
	 */
	private boolean isLogin(ActionInvocation ai){
		return ai.getController().getSessionAttr(properties.getProperty("isLoginUser")) != null;
	}
	
}
