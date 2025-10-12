Feature: Register
  Scenario: Register User
    Given User in homepage
    When User goto SignupLogin Menu
    And User verify on SignupLogin Menu
    And User enter "name" register
    And User enter "email" register
    And User click "signup"
    Then User verify on "Signup Page"
    And User choose gender
    And User enter password signup
    And User choose "days" birth
    And User choose "months" birth
    And User choose "year" birth
    And User enter "first" name
    And User enter "last" name
    And User enter "company"
    And User enter "address"
    And User choose country
    And User enter "state"
    And User enter "city"
    And User enter "zip code"
    And User enter "mobile number"
    And User click "create account" signup
    Then User verify on "Success Register"
    And User click "continue" signup
    Then User validation correct account login "random"
    And User delete account
    And User verify account deleted
    Then User click continue


