package com.kocfinans.getCredit.config;

public class GetCreditPointService {
	
	private String url;
	private String getCreditPointToken;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGetCreditPointToken() {
		return getCreditPointToken;
	}
	public void setGetCreditPointToken(String getCreditPointToken) {
		this.getCreditPointToken = getCreditPointToken;
	}
	@Override
	public String toString() {
		return "GetCreditPointService [url=" + url + ", getCreditPointToken=" + getCreditPointToken + ", getUrl()="
				+ getUrl() + ", getGetCreditPointToken()=" + getGetCreditPointToken() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
