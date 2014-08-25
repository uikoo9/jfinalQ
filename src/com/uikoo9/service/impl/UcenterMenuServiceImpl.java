package com.uikoo9.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.service.UcenterMenuServiceI;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.crud.QPage;

@Service
public class UcenterMenuServiceImpl implements UcenterMenuServiceI{
	
	public QPage list(Map<String, String[]> paras, String tableName){
		StringBuilder sql = new StringBuilder("from " + tableName);
		StringBuilder str = new StringBuilder("<strong>");
		Set<String> keys = paras.keySet();
		for(String key : keys){
			String value = paras.get(key)[0];
			if(QStringUtil.notEmpty(value) && !"id".equals(value)){
				sql.append(" and " + key + " like '%" + value + "%'");
				str.append("，" + key + "（" + value + "）");
			}
		}
		
		Page<Record> page = Db.paginate(1, 10, "select * ", sql.toString().replaceFirst("and", "where"));
		QPage qpage = new QPage();
		qpage.setList(page.getList());
		qpage.setPageNumber(0);
		qpage.setPageSize(10);
		qpage.setTotalPage(page.getTotalPage());
		qpage.setTotalRow(page.getTotalRow());
		str.append("，共查询到" + qpage.getTotalRow() + "条记录。</strong>");
		qpage.setStr(str.toString().replaceFirst("，", ""));
		
		return qpage;
	}
}
