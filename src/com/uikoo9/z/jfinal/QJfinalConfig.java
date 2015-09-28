package com.uikoo9.z.jfinal;

import com.baidu.ueditor.util.QQiNiuUtil;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.uikoo9.util.core.file.QPropertiesUtil;
import com.uikoo9.util.external.QCron4jUtil;
import com.uikoo9.util.external.QWeixinUtil;
import com.uikoo9.z.my.MyInterceptor;

/**
 * jfinal config
 * @author qiaowenbin
 * @version 0.1.0.20150914
 */
public class QJfinalConfig extends JFinalConfig{
	
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(QPropertiesUtil.getBoolean("jfinal.dev_mode"));
	}

	@Override
	public void configRoute(Routes me) {
		// 初始化所有的Controller
		QJfinalUtil.initController(me);
	}

	@Override
	public void configPlugin(Plugins me) {
		// 初始化所有的Model
		QJfinalUtil.initDbAndArp(me);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// 默认全局拦截器
		me.add(new QInterceptor());
		
		// 自定义全局拦截器
		me.add(new MyInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {}
	
	@Override
	public void afterJFinalStart() {
		// 每小时自动更新七牛云的token
		QQiNiuUtil.genUptoken();
		
		// 初始化所有的定时任务
		QCron4jUtil.initTasks();
		
		// 初始化微信线程
		QWeixinUtil.runWeixinThread();
	}

}