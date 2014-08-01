package com.uikoo9.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志记录工具类
 * @author uikoo9
 * @version 0.0.1.20140430
 */
public class QLogUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger("com.uikoo9.gcode");
	
	public static void info(String msg){
		LOGGER.info(msg);
	}
	public static void debug(String msg){
		LOGGER.debug(msg);
	}
	public static void error(String msg){
		LOGGER.error(msg);
	}
}
