Feature: Login to HRM Application 

  @ValidCredentials_1	
  Scenario: Testing Login functionalty with valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/"
    And User Enters username as "Admin" and Password as "admin123"
    And Click on Login
    Then Page Title should be "OrangeHRM"
    When User click on profile link
    And click on Logout link
    Then close the browser
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    
   @ValidCredentials_2
   Scenario Outline: Login with valid credentials
    Given User is on HRMLogin page
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to login sucessfully and new page open

	Examples:
			| username | password |
			| Admin    | admin123 |
		
