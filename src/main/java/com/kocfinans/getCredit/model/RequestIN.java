package com.kocfinans.getCredit.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class RequestIN {
	
	@Length(min=11,max=11)
	private String id;
	@NotNull(message="Name cannot be null")
	private String fullname;
	@NotNull(message="Name cannot be null")
	private Integer income;
	@Length(min=10,max=10)
	private String mobile;
	
	public RequestIN() {
		super();
	}



	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	@Override
	public String toString() {
		return "RequestIN [id=" + id + ", fullname=" + fullname + ", income=" + income + ", mobile=" + mobile
				+ ", getId()=" + getId() + ", getFullname()=" + getFullname() + ", getIncome()=" + getIncome()
				+ ", getMobile()=" + getMobile() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	





}
