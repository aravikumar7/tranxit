@Search
Feature: To validate Search functionality

  Scenario Outline: Search for valid products
    When user Search option is available
    And user clicks on search Text box
    And enters "<product name>"
    When user clicks on Search button
    Then user should be taken to the result page with the "<product name>" and picture

    Examples:
      | product name                               |
      | Apple iCam                                 |
      | adidas Consortium Campus 80s Running Shoes |
      | Pride and Prejudice                        |
