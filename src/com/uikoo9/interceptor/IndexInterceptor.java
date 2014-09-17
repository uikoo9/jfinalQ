package com.uikoo9.interceptor;

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
		controller.setAttr(QContants.V_PROTYPES, QContantsUtil.list(QContants.C_PRO_TYPE));
		
		ai.invoke();
	}

}
