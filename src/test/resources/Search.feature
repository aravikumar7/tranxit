@Search
Feature: To validate Search functionality

  Scenario Outline: Search for valid products
    Given user is in Home page
    When user clicks Log in link
    And the "Given user is in Home page" message appears
    And user enters "<user id>" and "<password>" and clicks log in button
    When user Search option is available
    And user clicks on search Text box
    And enters "<product name>"
    When user clicks on Search button
    Then user should be taken to the result page with the "<product name>" and picture
    When user clicks on Logout
    Then he should be successfully logged out

    Examples:
      | user id          | password | product name                               |
      | demos1@demos.com | 1234567  | Apple iCam                                 |
      | demos1@demos.com | 1234567  | adidas Consortium Campus 80s Running Shoes |
      | demos1@demos.com | 1234567  | Pride and Prejudice                        |