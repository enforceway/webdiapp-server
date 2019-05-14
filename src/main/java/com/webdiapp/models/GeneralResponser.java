package com.webdiapp.models;

import java.io.Serializable;

public class GeneralResponser implements Serializable {

	private static final long serialVersionUID = 8182818811554664967L;
	private String message = "ok";
	private String code = "0";
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
