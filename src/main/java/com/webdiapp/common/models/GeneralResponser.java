package com.webdiapp.common.models;

import com.webdiapp.common.constants.GeneralResponseStatus;

import java.io.Serializable;

public class GeneralResponser<T> implements Serializable {

	private static final long serialVersionUID = 8182818811554664967L;
	private String message = "ok";
	private String code = "0";
	private T data;
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
	public void setCode(GeneralResponseStatus codeStatus) {
		this.code = codeStatus.toString();
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
