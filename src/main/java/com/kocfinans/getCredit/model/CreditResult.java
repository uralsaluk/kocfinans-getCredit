package com.kocfinans.getCredit.model;

public class CreditResult {
	
	public String creditStatus;
	public Integer creditLimit;
	public Integer currentCreditScore;
	
	
	
	
	public CreditResult() {
		super();
	}



	
	public CreditResult(String creditStatus, Integer creditLimit, Integer currentCreditScore) {
		super();
		this.creditStatus = creditStatus;
		this.creditLimit = creditLimit;
		this.currentCreditScore = currentCreditScore;
	}




	public String getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public Integer getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Integer getCurrentCreditScore() {
		return currentCreditScore;
	}




	public void setCurrentCreditScore(Integer currentCreditScore) {
		this.currentCreditScore = currentCreditScore;
	}




	@Override
	public String toString() {
		return "CreditResult [creditStatus=" + creditStatus + ", creditLimit=" + creditLimit + ", currentCreditScore="
				+ currentCreditScore + ", getCreditStatus()=" + getCreditStatus() + ", getCreditLimit()="
				+ getCreditLimit() + ", getCurrentCreditScore()=" + getCurrentCreditScore() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




	
	

}
