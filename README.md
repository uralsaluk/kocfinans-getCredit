# kocfinans-getCredit
Spring Boot project for Application


### Description

This application check the credit applications of customers response if it's accepted or denied

### Dependencies

* JAVA 1.8
* Maven


# Service Dependencies
*  spring-boot-starter-we
*  spring-boot-starter-validation
*	 gson 	
*	 spring-boot-starter
*	 spring-boot-starter-test 
*  spring-boot-starter-actuator 
*  spring-boot-devtools 
*  spring-boot-starter-cache 
*	 mysql-connector-java 
*  spring-boot-starter-data-jpa
*  springfox-swagger2 
*  springfox-swagger-ui 

# Project Details

Service consume the application.yml as config file. <br>
Currently it's working on 8021 port. <br>

Request Url is; <br>

  :8021/kocFinans/checkCredits <br>
Post Method <br>
Example Request Payload <br>

<code>
{
"id": 12345678910,
"fullname": " Ural SALUK",
"income": 8000,
"mobile": "5326966373"
}
  </code>
 <br>
 Example Response Payload
 <code>
 {
    "status": "ONAY"
}
</code>
<br>
* There is another endpoint to monitor logged credit applications <br>
GET method  <br>
  :8021/kocFinans/creditLogs/12345678910
  
  
 
# Coding Details

Process starts from controller.

* Firstly it controls if request payload is correct or not;

<code> 	public ResponseEntity<ServiceResponse> checkCredit(HttpServletRequest req,@RequestHeader Map<String, String> headers, 
			@Valid @RequestBody RequestIN request) { </code>

* Then calls the checkCreditService function which is instanced from  CreditService class (service layer)

<code> ServiceResponse response = creditService.checkCreditService(request); </code>

* At the service layer service starts to the consuming of functions of CreditProcess interface

* Firstly it get credit score with function below
<code> Integer creditScore = creditProcess.getCreditScore(request.getId()); </code>

* Secondly it checks if the credit application accepted or denied from function below;

<code>CreditResult result=creditProcess.calculateCreditLimit(creditScore,request.getIncome()); </code>

* Thirdly it log the data to dabase (application result)
<code> reditProcess.logCreditApplication(result,request) </code>

* Lastly it sends  result of application with sms

<code>	creditProcess.sendSMS(result.getCreditStatus(),result.getCreditLimit()) </code>

* After processes fnished, it returns the response of status to the user.  

<code>	return new ResponseEntity<ServiceResponse>(response,HttpStatus.OK); </code>
  
