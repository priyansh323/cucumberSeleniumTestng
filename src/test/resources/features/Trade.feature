@trade
Feature: Trade Page

  Scenario: To verify user able to Trade coins
    Given User is on Dashboard
    And clicks on coin
    When User enter amount 
    And clicks on buy or sell 
    Then Trade is successful
  
  Scenario: To verify user not able to buy coins with Insufficient Balance
    Given User is on Dashboard
    And clicks on BTC coin
    When User enter amount 
    And clicks on buy 
    Then Pop up with Insufficient Funds comes
   
   Scenario: To verify user not able to sell coins more than Portfolio coins
    Given User is on Dashboard
    And clicks on  random coin
    When User enter amount 
    And clicks on sell 
    Then Pop up with Insufficient Funds comes
    
   Scenario Outline: To verify user not able to buy coins with Invalid Amounts
    Given User is on Dashboard
    And clicks on coin
    When User enter "<amount>" 
    And clicks on buy
    Then Pop up with Nice Try comes

   Scenario: To verify that coin conversion rate is correct
    Given User is on Dashboard
    And clicks on coin
    When User enter amount 
    Then converted rate is correct
  
 Examples: 
      | amount | 
      | 0      |
      |        |
     