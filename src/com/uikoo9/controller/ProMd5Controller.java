package com.uikoo9.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.QEncodeUtil;
import com.uikoo9.util.QJson;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.jfinal.QActionMap;

/**
 * project md5 controller
 * @author uikoo9
 */
@QActionMap("/md5")
public class ProMd5Controller extends Controller{
	
	/**
	 * 跳转到md5首页
	 */
	public void index(){
		render("/WEB-INF/view/pro-md5.ftl");
	}
	
	/**
	 * 将code md5加密
	 */
	public void md5(){
		String code = getPara("code");
		QJson qjson = new QJson(false, "md5 error!");
		
		if(QStringUtil.notEmpty(code)){
			try {
				qjson.setMsg(QEncodeUtil.md5Encrypt(code));
				qjson.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		renderJson(qjson);
	}
	
}
