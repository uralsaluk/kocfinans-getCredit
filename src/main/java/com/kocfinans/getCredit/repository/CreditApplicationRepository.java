package com.kocfinans.getCredit.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CreditApplicationRepository extends JpaRepository<CreditApplicationEntity, Long> {
	
	
	public  ArrayList<CreditApplicationEntity> findBycustomerid(String customerid);
}
