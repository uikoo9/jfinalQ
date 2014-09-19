package com.uikoo9.common.dto;

import java.util.List;

import com.uikoo9.manage.pro.model.ProDetailModel;

/**
 * 页面顶部使用的项目明细菜单
 * @author uikoo9
 */
public class ProMenuDTO {
	private String value;
	private String text;
	private List<ProDetailModel> pros;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<ProDetailModel> getPros() {
		return pros;
	}
	public void setPros(List<ProDetailModel> pros) {
		this.pros = pros;
	}
	
}
