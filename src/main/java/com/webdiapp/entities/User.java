package com.webdiapp.entities;

public class User extends BaseEntity {

	private static final long serialVersionUID = -8552283633126138930L;

	private Integer id;

    private String username;
    
    public User() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}