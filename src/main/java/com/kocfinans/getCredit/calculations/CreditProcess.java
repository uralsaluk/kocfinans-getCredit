package com.kocfinans.getCredit.calculations;

import com.kocfinans.getCredit.model.CreditResult;
import com.kocfinans.getCredit.model.RequestIN;

public interface CreditProcess {
	
	public Integer getCreditScore(String id);
	
	public CreditResult calculateCreditLimit(Integer creditScore,Integer customerIncome);
	
	public void logCreditApplication(CreditResult result,RequestIN request);
	
	public void sendSMS(String result,Integer creditLimit);

}
