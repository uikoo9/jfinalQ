package com.uikoo9.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface LoginServiceI{
	
	/**
	 * 登录
	 * @param paras
	 * @param session
	 * @return
	 */
	public String login(Map<String, String[]> paras, HttpSession session);
	
}
