package com.uikoo9.z.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.uikoo9.manage.pro.model.ProDetailModel;

/**
 * 注入项目列表
 * @author uikoo9
 */
public class ProDetailsInterceptor implements Interceptor{
	
	@Override
	public void intercept(ActionInvocation ai) {
		ai.getController().setAttr("prosDetails", ProDetailModel.dao.findAll());
		ai.invoke();
	}
	
}
