package com.uikoo9.service;

import java.util.Map;

import com.uikoo9.util.crud.QPage;

public interface UcenterMenuServiceI {
	public QPage list(Map<String, String[]> paras, String tableName);
}
