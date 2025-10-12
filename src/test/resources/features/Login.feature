Feature: Login
  Scenario: Logout User
    Given User in homepage
    When User goto SignupLogin Menu
    And User verify on SignupLogin Menu
    And User enter email login
    And User enter password login
    And User click "login"
    Then User validation correct account login "exist"