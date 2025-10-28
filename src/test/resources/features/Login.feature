Feature: Login
  Scenario: Logout User
    Given User in homepage
    When User goto "SignupLogin" Menu
    And User verify on SignupLogin Menu
    And User enter email login "valid"
    And User enter password login "valid"
    And User click "login"
    Then User validation correct account login "exist"

  Scenario: Login User with incorrect email and password
    Given User in homepage
    When User goto "SignupLogin" Menu
    And User verify on SignupLogin Menu
    And User enter email login "random"
    And User enter password login "random"
    And User click "login"
    Then User validation invalid "login"


