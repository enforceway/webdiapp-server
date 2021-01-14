package com.webdiapp.common.vo;

import java.io.Serializable;
import java.util.Date;
import com.webdiapp.common.entities.BaseEntity;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date creationTimestamp;
    
    private Integer creationUser;
    
    private Date lastupdateTimestamp;
    
    private Integer lastupdateUser;
    
    public BaseVO() {
	}

	public void setCommonFields(BaseEntity baseEntity) {
        this.setCreationTimestamp(baseEntity.getCreationTimestamp());
        this.setCreationUser(baseEntity.getCreationUser());
        this.setLastupdateTimestamp(baseEntity.getLastupdateTimestamp());
        this.setLastupdateUser(baseEntity.getLastupdateUser());
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
