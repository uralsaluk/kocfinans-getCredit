package com.kocfinans.getCredit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("project-constants")
public class YAMLConfig {
	
	public Integer constantLimitMultiplier;
	
	public GetCreditPointService getCreditPointService;

	public GetCreditPointService getGetCreditPointService() {
		return getCreditPointService;
	}

	public void setGetCreditPointService(GetCreditPointService getCreditPointService) {
		this.getCreditPointService = getCreditPointService;
	}

	
	
	
	public Integer getConstantLimitMultiplier() {
		return constantLimitMultiplier;
	}

	public void setConstantLimitMultiplier(Integer constantLimitMultiplier) {
		this.constantLimitMultiplier = constantLimitMultiplier;
	}

	@Override
	public String toString() {
		return "YAMLConfig [getCreditPointService=" + getCreditPointService + ", getGetCreditPointService()="
				+ getGetCreditPointService() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	

}
