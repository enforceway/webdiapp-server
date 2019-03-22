package com.webdiapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date creationTimestamp;
    
    private int creationUser;
    
    private String creationUsername;
    
    private Date lastupdateTimestamp;
    
    private int lastupdateUser;
    
    private String lastupdateUsername;
    
    private String userYn;
    
    public BaseEntity() {
//    	new 
//    	this.setCreationTimestamp(curr);
//    	this.setLastupdateTimestamp(curr);
	}
    
    public void setUser(HttpServletRequest request) {
    	
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

	public String getCreationUsername() {
		return creationUsername;
	}

	public void setCreationUsername(String creationUsername) {
		this.creationUsername = creationUsername;
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

	public String getLastupdateUsername() {
		return lastupdateUsername;
	}

	public void setLastupdateUsername(String lastupdateUsername) {
		this.lastupdateUsername = lastupdateUsername;
	}

	public String getUserYn() {
		return userYn;
	}

	public void setUserYn(String userYn) {
		this.userYn = userYn;
	}

}
