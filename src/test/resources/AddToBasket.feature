@AddToBasket
Feature: To add and delete products to Basket

  Scenario Outline: Login into Home page
    Given user is in Home page
    When user clicks Log in link
    And the "Given user is in Home page" message appears
    And user enters "<user id>" and "<password>" and clicks log in button
    Then he should be successfully logged in
    Examples:
      | user id          | password |
      | demos1@demos.com | 1234567  |

@AddToCart
  Scenario Outline: Search for valid products and add it to Basket
    Given user Search option is available
    When user clicks on search Text box
    And enters "<product name>"
    When user clicks on Search button
    Then user should be taken to the result page with the "<product name>" and picture
    When user clicks on "AddToCart" link
    Then the product should be added to Cart with proper "<count>"

    Examples:
      | product name                               | count |
      | Flower Girl Bracelet                       | (1)   |
      | Pride and Prejudice                        | (2)   |
      | adidas Consortium Campus 80s Running Shoes | (2)   |

@UpdateShoppingCart
  Scenario Outline: To Update quantities in Basket
    When user clicks on "Shopping Cart" button
    And selects qty
    And Updates product's "<products>" quantity "<quantity>"
    And Clicks on "Update Shopping Cart"
    Then Quantity for "<products>" should get updated as given in "<quantity>"
    Examples:
      | products             | quantity |
      | Flower Girl Bracelet | 10       |
      | Pride and Prejudice  | 5        |

@DeleteShoppingCart
  Scenario: To delete quantities in Basket
    When user clicks on "Shopping Cart" button and selects Remove
    And Clicks on "Update Shopping Cart"
    Then the message "Your Shopping Cart is empty!" should appear