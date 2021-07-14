

Feature: Add new product

  Scenario: Creating a vendor
    When create a vendor for the new product
    When user add a product
    Then user is able to verify the new product on the vendor


    Scenario: Adding a product to the existing vendor
      When user get a existing vendor
      And user is able to add a new product
      Then  user is able to verify product is added on vendor
