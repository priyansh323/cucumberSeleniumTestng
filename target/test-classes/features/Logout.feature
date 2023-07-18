@logout
Feature: Logout Page

  Scenario: To verify Logout in Papercoin
    Given User is on Dashboard
    When User clicks logout
    Then User is logged out successfully


