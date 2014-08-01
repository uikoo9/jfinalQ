package com.uikoo9.util;

/**
 * 分页bean
 * @author uikoo9
 * @version 0.0.2.20140514
 */
public class QPage {

	private int page;
	private int rows;
	private String ids;
	
	public QPage() {
		super();
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart(){
		return (page - 1) * rows;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
}
