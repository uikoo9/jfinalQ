package com.uikoo9.z.my;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 自定义拦截器，区别于jar中的QInterceptor
 * @author qiaowenbin
 */
public class MyInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation ai) {
		ai.invoke();
	}
	
}
