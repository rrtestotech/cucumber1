Feature: Ebay Advanced Search

  @A2
  Scenario: Ebay logo on Advanced search Page
    Given I am on ebay adavanced search page
    When i clicked on ebay logo
    Then I am navigated to Ebay home page
	
	@P5
  Scenario: Advanced search an item
    Given I am on ebay adavanced search page
    When I advanced search an item
      | keyword   | exclude     | min | max |
      | iphone 11 | refurbished | 300 | 900 |
