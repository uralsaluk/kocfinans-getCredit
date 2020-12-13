package com.kocfinans.getCredit.service;

import javax.xml.transform.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kocfinans.getCredit.calculations.CreditProcess;
import com.kocfinans.getCredit.model.CreditResult;
import com.kocfinans.getCredit.model.RequestIN;
import com.kocfinans.getCredit.model.ServiceResponse;

@Service
public class CreditService {
	
	@Autowired
	CreditProcess creditProcess;

	public ServiceResponse checkCreditService(RequestIN request) {
		
		ServiceResponse serviceResp=new ServiceResponse();
		
		
		
		try {
		Integer creditScore = creditProcess.getCreditScore(request.getId()); // tc kimlik noya ait kredi notu alınır
		
		
		
		CreditResult result=creditProcess.calculateCreditLimit(creditScore,request.getIncome());    // kredi sonucu tespit edilir.
		
		serviceResp.setStatus(result.getCreditStatus());//kredi sonucuna göre servisin vereceği response set edilir.
		
		
		creditProcess.logCreditApplication(result,request);  // kredi başvurusu database kayıt edilir.
		
		
		
		creditProcess.sendSMS(result.getCreditStatus(),result.getCreditLimit());  // müşteriye bilgilendirme sms i atılır
		
		
		
		}catch(Exception e)
		{
			// do smth
			return null;
		}
		
		return serviceResp;
		
		
	
		
	}
	
}
