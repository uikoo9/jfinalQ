package com.uikoo9.manage.ucenter.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.core.annotation.QControllerUrl;

/**
 * 错误路由
 * @author qiaowenbin
 */
@QControllerUrl("/error")
public class UcenterErrorController extends Controller{
	
	/**
	 * 没有权限
	 */
	public void auth(){
		render("/WEB-INF/view/base/common/error.html");
	}
	
}
