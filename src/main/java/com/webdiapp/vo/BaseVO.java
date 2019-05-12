package com.webdiapp.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date creationTimestamp;
    
    private int creationUser;
    
    private Date lastupdateTimestamp;
    
    private int lastupdateUser;
    
    public BaseVO() {
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public int getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(int creationUser) {
		this.creationUser = creationUser;
	}

	public Date getLastupdateTimestamp() {
		return lastupdateTimestamp;
	}

	public void setLastupdateTimestamp(Date lastupdateTimestamp) {
		this.lastupdateTimestamp = lastupdateTimestamp;
	}

	public int getLastupdateUser() {
		return lastupdateUser;
	}

	public void setLastupdateUser(int lastupdateUser) {
		this.lastupdateUser = lastupdateUser;
	}

}
