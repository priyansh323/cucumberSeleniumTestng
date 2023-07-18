@Register
Feature: Register Page
 

 Scenario: To verify Registration in Papercoin
    Given User is on register Page
    When User Enters valid Details
    And clicks on register 
    Then User is registered

  Scenario Outline: To verify with Invalid details Registration in Papercoin
    Given User is on register Page
    When User Enters Invalid "<username>" and "<email>"
    And clicks on register 
    Then User is not registered
    
  Scenario: To verify User get dollars after Registration in Papercoin
    Given User is on register Page
    When User Enters valid Details
    And clicks on register 
    Then User is registered and got dollars
    
  Examples: 
      | username              | email              | condition                             |
      | User12345             | user12345@mail.com | already used username & correct email |
      | User                  | user12345@mail.com | wrong username & correct email        |
      | User12345678901234567 | user12345@mail.com | wrong username &correct email         |
      | User12345             | usermail.com       | correct username & wrong email        |
    
