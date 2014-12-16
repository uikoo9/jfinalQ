package com.uikoo9.z.dto;

import java.io.Serializable;
import java.util.List;

import com.uikoo9.manage.project.model.ProjectDetailModel;

/**
 * 页面顶部使用的项目明细菜单
 * @author uikoo9
 */
@SuppressWarnings("serial")
public class ProMenuDTO implements Serializable{
	private String value;
	private String text;
	private List<ProjectDetailModel> pros;
	
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
	public List<ProjectDetailModel> getPros() {
		return pros;
	}
	public void setPros(List<ProjectDetailModel> pros) {
		this.pros = pros;
	}
	
}
