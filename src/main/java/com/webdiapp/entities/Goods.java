package com.webdiapp.entities;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Goods implements Serializable {

	private static final long serialVersionUID = -4281854134539742511L;

    private int id;

    @Pattern(regexp="^[^><&#]{1,50}$",message="{pattern}")
    @NotNull(message="{notNull}")
    private String name;

    @Min(value=1,message="必须大于或等于1")
    private double price;

    private String picture;
    
    private String surName;
    
    public Goods() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

}