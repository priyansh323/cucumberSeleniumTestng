@dashboard
Feature: Dashboard Page
  
  Scenario: To verify user view updated Total Value
    Given User is on Dashboard 
	  When User do successful Trade
    And navigate to dashboard
    Then User view Updated Total Value


