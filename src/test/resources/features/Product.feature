Feature: Product
#  Scenario: Verify All Products and product detail page
#    Given User in homepage
#    When User goto "Products" Menu
#    And User on product page
#    And User can see the product
#    And User click view product
#    And User can see detail product
#    Then User verify detail product "product1"

  Scenario: Search product
    Given User in homepage
    When User goto "Products" Menu
    And User on product page
    And User can see the product
    And User enter name product on search field
    And User click search
    And User can see the product
    Then User can see related product




