package com.webdiapp.models;

import java.io.Serializable;

public class GeneralResponser<T> implements Serializable {

	private static final long serialVersionUID = 8182818811554664967L;
	private int status;
	private String message;
	private String code;
	private T data;

	public GeneralResponser() {
	}

	public GeneralResponser(GeneralSponserBuilder<T> builder) {
		this.setCode(builder.code);
		this.setMessage(builder.message);
		this.setData(builder.data);
		this.setStatus(builder.status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static class GeneralSponserBuilder<T> {
		private int status; // 1:成功, 0:失败
		private String message = "ok"; // 失败时的信息提示
		private String code = ""; // 失败时的失败类型
		private T data; // 成功时的数据返回
		public GeneralSponserBuilder() {
			this.status = 1;
			this.message = "ok";
			this.code = "";
			this.data = null;
		}

		public GeneralResponser<T> build() {
			return new GeneralResponser<T>(this);
		}

		public GeneralResponser<T> build(int s) {
			GeneralResponser<T> resp = new GeneralResponser<T>();
			resp.status = s;
			resp.code = "";
			resp.message = "ok";
			resp.data = null;
			return resp;
		}

		public GeneralResponser<T> build(int s, String c) {
			GeneralResponser<T> resp = new GeneralResponser<T>();
			resp.status = s;
			resp.code = c;
			resp.message = "ok";
			resp.data = null;
			return resp;
		}

		public GeneralResponser<T> build(int s, String c, String m) {
			GeneralResponser<T> resp = new GeneralResponser<T>();
			resp.status = s;
			resp.code = c;
			resp.message = m;
			resp.data = null;
			return resp;
		}

		public GeneralResponser<T> build(int s, String c, String m, T d) {
			GeneralResponser<T> resp = new GeneralResponser<T>();
			resp.status = s;
			resp.code = c;
			resp.message = m;
			resp.data = d;
			return resp;
		}

		public GeneralSponserBuilder<T> status(int s) {
			this.status = s;
			return this;
		}

		public GeneralSponserBuilder<T> message(String m) {
			this.message = m;
			return this;
		}

		public GeneralSponserBuilder<T> code(String c) {
			this.code = c;
			return this;
		}

		public GeneralSponserBuilder<T> data(T d) {
			this.data = d;
			return this;
		}

	}

//	public static void main(String[] args) {
//		GeneralResponser<String>
//		new GeneralResponser.GeneralSponserBuilder<String>().status(1).message("Failed: 连接超时").code("F1009");
//	}

}
