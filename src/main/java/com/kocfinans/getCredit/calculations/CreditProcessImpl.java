package com.kocfinans.getCredit.calculations;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kocfinans.getCredit.config.YAMLConfig;
import com.kocfinans.getCredit.model.CreditResult;
import com.kocfinans.getCredit.model.CreditScoreRequestOUT;
import com.kocfinans.getCredit.model.CreditScoreResponse;
import com.kocfinans.getCredit.model.RequestIN;
import com.kocfinans.getCredit.repository.CreditApplicationEntity;
import com.kocfinans.getCredit.repository.CreditApplicationRepository;

@Component
public class CreditProcessImpl implements CreditProcess {
	
	@Autowired
	YAMLConfig yaml;
	
	@Autowired
	CreditApplicationRepository creditApplicationRepo;

	@Override
	public Integer getCreditScore(String id) {
		
		/*Let say there is a rest service and we are requeting that service to get credit point of customer*/
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		CreditScoreRequestOUT getScoreRequest= new CreditScoreRequestOUT(id.toString());
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Bearer " + yaml.getCreditPointService.getGetCreditPointToken());// using  service auth bearer from yaml config
		httpHeaders.add("X-CCAsset-Language", "tr");
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	
		HttpEntity<String> entity = new HttpEntity<>(	gson.toJson(getScoreRequest),httpHeaders);
	/*	ResponseEntity<CreditScoreResponse> rsp = restTemplate.exchange(yaml.getCreditPointService.getUrl()
				,
				HttpMethod.POST,
				entity, CreditScoreResponse.class);*/
	
		Random rand = new Random();
		Integer randomCreditScore = rand.nextInt(1500);

		//rsp.getBody().setCreditScore(randomCreditScore);
		//return rsp.getBody().getCreditScore();
		
		return randomCreditScore;
		
	}

	@Override
	public CreditResult calculateCreditLimit(Integer creditScore, Integer customerIncome) {
		
		CreditResult response=new CreditResult();
		
		if(creditScore<500) {
			response.setCurrentCreditScore(creditScore);
			response.setCreditStatus("RED");
		
		}else if (creditScore>=500&&creditScore<1000) {
			if(customerIncome<5000) {
				response.setCreditLimit(10000);
			}else {
				response.setCreditLimit(customerIncome*yaml.getConstantLimitMultiplier());
			}
			response.setCurrentCreditScore(creditScore);
			response.setCreditStatus("ONAY");
		}else if(creditScore>=1000) {
			response.setCreditLimit(customerIncome*yaml.getConstantLimitMultiplier());
			response.setCurrentCreditScore(creditScore);
			response.setCreditStatus("ONAY");
			
		}
		
		return response;
		
	}

	@Override
	public void logCreditApplication(CreditResult result,RequestIN request) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS+0000");
		String date=formatter.format(System.currentTimeMillis());  
		String uniqueID = UUID.randomUUID().toString();
		CreditApplicationEntity applicationLog=new CreditApplicationEntity(
				request.getId(),
				result.getCreditLimit(),
				request.getFullname(),
				request.getMobile(),
				uniqueID,
				result.getCreditStatus(),
				result.getCurrentCreditScore(),
				date
				);
			
		creditApplicationRepo.save(applicationLog);
		
	}

	@Override
	public void sendSMS(String result, Integer creditLimit) {
	
		  if(result.equalsIgnoreCase("onay")) {
			  
			  String message= "Kredi başvurunuz onaylanmıştır. Kredi limitiniz "+creditLimit+ "TL dir"  ;
			  
			  System.out.println(message);
			 
			  
			  
			  
		  }else {
			  
			   String message= "Kredi başvurunuz reddedilmiştir.";
			   
			   System.out.println(message);
			
		  }
		
	}

}
