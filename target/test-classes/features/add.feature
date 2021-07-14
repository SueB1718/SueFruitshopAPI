
Feature: Add new product

  Scenario:
    When create a vendor for the product
    When user add a new product
    Then user is able to verify the new product

  @test
  Scenario: user is able to update a name and price of the product
    When user update the name and price of the product
    Then user is able to verify the updated name and a price
    Then list the product

