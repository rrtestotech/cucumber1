Feature: Rahul feature

  @A1
  Scenario: Rahul Scenario
  Given I am on "https://rahulshettyacademy.com/AutomationPractice/" url
  When click on home page
  And click on RadioButton one
  And click on RadioButton two
  And click on option1
  
  
  @A2
  Scenario: Rahul dropdown
  Given I am on "https://rahulshettyacademy.com/AutomationPractice/" url
  And select "option1" from dropDown example
  
  
  
  @Basic
  Scenario: Practice basic webdriver commands
  Given I am on "https://shop.demoqa.com/" url
  