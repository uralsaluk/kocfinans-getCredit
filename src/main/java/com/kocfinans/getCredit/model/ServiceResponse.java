package com.kocfinans.getCredit.model;

public class ServiceResponse {
	
	private String status;

	public ServiceResponse() {
		super();
	}

	public ServiceResponse(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServiceResponse [status=" + status + ", getStatus()=" + getStatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
