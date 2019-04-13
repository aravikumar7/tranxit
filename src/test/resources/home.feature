@Home
Feature: To test Home Page

  Scenario Outline: Social media links
    Given user is in Home page
    When user opens the "<social media>" link
    Then the page should open in a new window with title as "<text>"

    Examples:
    |social media|text|
    |Facebook   |https://www.facebook.com/nopCommerce|
    |Twitter     |https://twitter.com/nopCommerce        |
    |YouTube     |https://www.youtube.com/user/nopCommerce   |
    |Google   |https://plus.google.com/100073150079669136049|