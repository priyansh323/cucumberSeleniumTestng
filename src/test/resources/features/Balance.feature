@Balance
Feature: Account Balance
  
  Scenario: To verify User view account balance
    Given User is on Dashboard
    Then User can view Account Balance

  Scenario: To verify User view updated balance after trade
    Given User is on Dashboard
    When User do successful trade
    Then User can view updated Balance