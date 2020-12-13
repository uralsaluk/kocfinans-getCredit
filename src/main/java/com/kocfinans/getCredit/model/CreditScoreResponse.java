package com.kocfinans.getCredit.model;

public class CreditScoreResponse {
	
	public Integer creditScore;

	public CreditScoreResponse(Integer creditScore) {
		super();
		this.creditScore = creditScore;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "creditScoreResponse [creditScore=" + creditScore + ", getCreditScore()=" + getCreditScore()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
