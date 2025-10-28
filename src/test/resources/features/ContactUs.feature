Feature: Contact Us
  Scenario: Contact Us form
    Given User in homepage
    When User goto "ContactUs" Menu
    And User verify on Contact Us Menu
    And User enter "name" Contact Us
    And User enter "email" Contact Us
    And User enter "subject" Contact Us
    And User enter "message" Contact Us
    And User click submit
    And User click accept alert
    And User verify submit success
    And User click home button
    Then User in homepage