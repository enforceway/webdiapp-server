package com.webdiapp.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS",timezone = "GMT+8")
	private Date creationTimestamp;
    
    private Integer creationUser;
    
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS",timezone = "GMT+8")
    private Date lastupdateTimestamp;
    
    private Integer lastupdateUser;
    
    public BaseVO() {
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Integer getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(Integer creationUser) {
		this.creationUser = creationUser;
	}

	public Date getLastupdateTimestamp() {
		return lastupdateTimestamp;
	}

	public void setLastupdateTimestamp(Date lastupdateTimestamp) {
		this.lastupdateTimestamp = lastupdateTimestamp;
	}

	public Integer getLastupdateUser() {
		return lastupdateUser;
	}

	public void setLastupdateUser(Integer lastupdateUser) {
		this.lastupdateUser = lastupdateUser;
	}

}
