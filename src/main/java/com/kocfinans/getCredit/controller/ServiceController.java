package com.kocfinans.getCredit.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kocfinans.getCredit.model.RequestIN;
import com.kocfinans.getCredit.model.ServiceResponse;
import com.kocfinans.getCredit.repository.CreditApplicationEntity;
import com.kocfinans.getCredit.repository.CreditApplicationRepository;
import com.kocfinans.getCredit.service.CreditService;

@RestController
@RequestMapping("/kocFinans")
public class ServiceController {
	
	@Autowired
	CreditService creditService;
	
	@Autowired
	CreditApplicationRepository creditApplicationRepo;
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*" ,allowCredentials = "true",exposedHeaders="X-CSRF-TOKEN" )
	@RequestMapping(value = "checkCredits",method= {RequestMethod.POST,RequestMethod.OPTIONS})
	public ResponseEntity<ServiceResponse> checkCredit(HttpServletRequest req,@RequestHeader Map<String, String> headers, 
			@Valid @RequestBody RequestIN request) {
		
		
		ServiceResponse response = creditService.checkCreditService(request);
		
		
		if (response==null)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
					"Error xxx");
			
		}
		
		return new ResponseEntity<ServiceResponse>(response,HttpStatus.OK);
		
	}
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*" ,allowCredentials = "true",exposedHeaders="X-CSRF-TOKEN" )
	@RequestMapping(value = "creditLogs/{customerid}",method= {RequestMethod.GET,RequestMethod.OPTIONS})
	public ResponseEntity<ArrayList<CreditApplicationEntity>> checkCredit(@PathVariable (required=true) String customerid) {
		
		System.out.println(customerid);
		
		ArrayList <CreditApplicationEntity> responseList =creditApplicationRepo.findBycustomerid( customerid);
		
		return new ResponseEntity<ArrayList<CreditApplicationEntity>>(responseList,HttpStatus.OK);
	
	}
}
