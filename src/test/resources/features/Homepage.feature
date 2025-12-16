Feature: Homepage
  Scenario: Verify Subscription in home page
    Given User in homepage
    When User scroll down to footer
    And User verify text "SUBSCRIPTION"
    And User enter email address
    And User click arrow button
    Then User verify "Subscription Message" display