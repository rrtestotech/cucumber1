Feature: Admin user management

@Orange
Scenario: Search the system user

Given I am orange HRM home page
When I click on Admin tab
And enter username as "Jagan" and click on search
Then validate the result