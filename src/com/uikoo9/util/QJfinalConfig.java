package com.uikoo9.util;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.uikoo9.controller.ProMd5Controller;

/**
 * jfinal config
 * @author uikoo9
 */
public class QJfinalConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(false);
	}

	@Override
	public void configHandler(Handlers me) {}

	@Override
	public void configPlugin(Plugins me) {}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new QInterceptor());
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", ProMd5Controller.class);
	}

}
