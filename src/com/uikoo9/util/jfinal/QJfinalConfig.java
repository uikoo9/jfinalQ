package com.uikoo9.util.jfinal;

import java.util.Properties;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.spring.IocInterceptor;
import com.uikoo9.util.QFileUtil;

/**
 * jfinal config
 * @author uikoo9
 * @version 0.0.2.20140803
 */
public class QJfinalConfig extends JFinalConfig{

	private static Properties properties = QFileUtil.readProperties("/config.properties");
	
	@Override
	public void configConstant(Constants me) {
		QJfinalUtil.initConfig(me, "/config.properties");
	}

	@Override
	public void configHandler(Handlers me) {}

	@Override
	public void configInterceptor(Interceptors me) {
		if(Boolean.parseBoolean(properties.getProperty("initSpring"))) me.add(new IocInterceptor());
		me.add(new QInterceptor());
	}

	@Override
	public void configPlugin(Plugins me) {
		if(Boolean.parseBoolean(properties.getProperty("initSpring"))) QJfinalUtil.initSpring(me, "spring.xml");
		if(Boolean.parseBoolean(properties.getProperty("initDb"))) QJfinalUtil.initDbAndArp(me, "/db.properties");
	}

	@Override
	public void configRoute(Routes me) {
		if(Boolean.parseBoolean(properties.getProperty("initController"))) QJfinalUtil.initController(me);
	}

}
