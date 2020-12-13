package com.kocfinans.getCredit.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CREDITLOGS")
public class CreditApplicationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name="CUSTOMERID")
	private String customerid;
	@Column(name="CREDITLIMIT")
	private Integer creditlimit;
	@Column(name="FULLNAME")
	private String fullname;
	@Column(name="MOBILE")
	private String mobile;
	@Column(name="PROCESSUID")
	private String processid;
	@Column(name="STATUS")
	private String status;
	@Column(name="CURRENTCREDITSCORE")
	private Integer currentCreditScore;
	@Column(name="DATE")
	private String date;
	public CreditApplicationEntity() {
		super();
	}

	
	
	



	public CreditApplicationEntity( String customerid, Integer creditlimit, String fullname, String mobile,
			String processid, String status, Integer currentCreditScore, String date) {
		super();
		this.customerid = customerid;
		this.creditlimit = creditlimit;
		this.fullname = fullname;
		this.mobile = mobile;
		this.processid = processid;
		this.status = status;
		this.currentCreditScore = currentCreditScore;
		this.date = date;
	}







	public Integer getCurrentCreditScore() {
		return currentCreditScore;
	}







	public void setCurrentCreditScore(Integer currentCreditScore) {
		this.currentCreditScore = currentCreditScore;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCustomerid() {
		return customerid;
	}



	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public Integer getCreditlimit() {
		return creditlimit;
	}
	public void setCreditlimit(Integer creditlimit) {
		this.creditlimit = creditlimit;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getProcessid() {
		return processid;
	}
	public void setProcessid(String processid) {
		this.processid = processid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CreditApplicationEntity [id=" + id + ", customerid=" + customerid + ", creditlimit=" + creditlimit
				+ ", fullname=" + fullname + ", processid=" + processid + ", status=" + status + ", date=" + date
				+ ", getId()=" + getId() + ", getCustomerid()=" + getCustomerid() + ", getCreditlimit()="
				+ getCreditlimit() + ", getFullname()=" + getFullname() + ", getProcessid()=" + getProcessid()
				+ ", getStatus()=" + getStatus() + ", getDate()=" + getDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}


	



