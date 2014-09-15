package com.uikoo9;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.uikoo9.util.contants.QContantsUtil;

/**
 * 通用变量
 * @author uikoo9
 */
public class VInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		
		// set global variable
		controller.setAttr("protypes", QContantsUtil.list(QContants.C_PRO_TYPE));
		
		ai.invoke();
	}

}
