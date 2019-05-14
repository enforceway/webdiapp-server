package com.webdiapp.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date creationTimestamp;
    
    private Integer creationUser;
    
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

	public Integdr getCreationUser() {
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

	public void setLastupdateUser(int lastupdateUser) {
		this.lastupdateUser = lastupdateUser;
	}

}
