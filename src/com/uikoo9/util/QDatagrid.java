package com.uikoo9.util;

import java.util.List;

/**
 * easyui中datagrid的数据结构
 * @author uikoo9
 * @version 0.0.1.20140430
 */
public class QDatagrid {
	private int total;
	private List<? extends Object> rows;

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<? extends Object> getRows() {
		return rows;
	}
	public void setRows(List<? extends Object> rows) {
		this.rows = rows;
	}
}
