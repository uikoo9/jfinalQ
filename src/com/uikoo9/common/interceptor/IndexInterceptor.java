package com.uikoo9.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.uikoo9.QContants;
import com.uikoo9.util.contants.QContantsUtil;

public class IndexInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		
		// protypes
		controller.setAttr("protypes", QContantsUtil.list(QContants.C_PRO_TYPE));
		
		ai.invoke();
	}

}