Feature: Ebay Home Page Scenarios

  @Bhar
  Scenario: Adavanced Search link
    Given I am on Ebay Home page
    When I click on Advanced link
    Then I navigate to Advance search page

  @S1 @setCookies
  Scenario: Search item count
    Given I am on Ebay Home page
    When i search for "iPhone 11"
    Then i validate atleast 10 search items present


 @S10
  Scenario Outline: Search item count
    Given I am on Ebay Home page
    When i search for "<item>"
    Then i validate atleast 10 search items present
    Examples:
    |item|
    |iphone 11|
    |egg|
    
  @S2
  Scenario: Search item count
    Given I am on Ebay Home page
    When i search for "egg"
    Then i validate atleast 10 search items present

  @S4
  Scenario: Search item in category
    Given I am on Ebay Home page
    When i search for "soap" in "2984" category

  @S30
  Scenario Outline: Home Page links
    Given I am on Ebay Home page
    When I click on "<link>"
    Then validate that the page navigate to "<url>" and titile contains "<title>"

    Examples: 
      | link        | url                                              | title                         |
      | Fashion     | https://www.ebay.com/b/Fashion/bn_7000259856     | Fashion products for sale     |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124 | Electronics products for sale |
