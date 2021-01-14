package com.webdiapp.questionaire.entities;

import com.webdiapp.common.entities.BaseEntity;

import java.util.Date;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

public class Questionaire extends BaseEntity {

	private static final long serialVersionUID = -8552283633126138930L;

	private Integer id;

	private Integer statusId;

	private Date activeDateStart;

	private Date activeDateEnd;

	private String title;
	
	public Questionaire() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Date getActiveDateStart() {
		return activeDateStart;
	}

	public void setActiveDateStart(Date activeDateStart) {
		this.activeDateStart = activeDateStart;
	}

	public Date getActiveDateEnd() {
		return activeDateEnd;
	}

	public void setActiveDateEnd(Date activeDateEnd) {
		this.activeDateEnd = activeDateEnd;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
