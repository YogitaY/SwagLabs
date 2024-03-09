Feature: Test the Checkout functionality of Swag Labs

  Scenario Outline: Test the valid Checkout
    Given User is on add to cart page
    When User click on checkout butoon
    And User enters FirstName, LastName and Address
    And User click on finish button
    Then User Completed ordering product
