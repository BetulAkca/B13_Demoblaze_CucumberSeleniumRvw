Feature: The user should be able to place order from web site

  Background:
    Given The user navigates to website


  Scenario: Placing a successful order
    When The user clicks on login button and enters "JhonyQ" and "Test1234" credentials
    And The user adds "Samsung galaxy s7" product from "Phones" category
    And The user adds "Sony vaio i5" product from "Laptops" category
    And The user adds "MacBook Pro" product from "Laptops" category
    And The user adds "Apple monitor 24" product from "Monitors" category
    And The user removes "Sony vaio i5" chosen product from Cart page
    And The user places order and captures and log amount
    Then The user verifies purchase amount

  @wip
  Scenario Outline: Placing a successful order with different product
    When The user clicks on login button and enters "<username>" and "<password>" credentials
    And The user adds following products from related category to the cart and return Home page
      | firstColumn | SecondColumn |
      | Phones      | <phone>      |
      | Laptops     | <laptop1>    |
      | Laptops     | <laptop2>    |
      | Monitors    | <monitor>    |
    And The user removes "<laptop1>" chosen product from "Cart" page
    And The user places order and captures and log amount
    Then The user verifies purchase amount
    Examples:
      | username | password | phone             | laptop1      | laptop2     | monitor          |
      | JhonyQ   | Test1234 | Samsung galaxy s7 | Sony vaio i5 | MacBook Pro | Apple monitor 24 |