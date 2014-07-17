package com.uikoo9.util;

/**
 * json model
 * @author uikoo9
 * @version 0.0.1.20140601
 */
public class QJson {
	
	private boolean success;
	private String msg;

	public QJson() {
		super();
	}
	public QJson(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	public QJson(String msg) {
		this.success = true;
		this.msg = msg;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
