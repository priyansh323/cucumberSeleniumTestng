@Login
Feature: Login Page


  Scenario: To verify login in Papercoin
    Given User is on Login Page
    When User Enters valid Credentials
    And clicks on Login 
    Then User is logged in 
    
  Scenario: To verify with Invalid login in Papercoin
    Given User is on Login Page
    When User Enters Invalid Credentials
    And clicks on Login 
    Then User is not logged in 
 