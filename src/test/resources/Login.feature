@Account
Feature: To test Account features

  @Registration
  Scenario Outline: To test Registration Functionality
    Given user is in Home page
    When user clicks on the "Register" link
    Then he should be taken to registration page
    When he selects "<Gender>","<Date of Birth>","<Newsletter>" and inputs "<First Name>","<Last Name>","<email>","<Company Name>","<User Name>","<Password>","<confirm password>"
    And Clicks Submit button
    Then "Your registration completed" message should appear

    Examples:
      | Gender | Date of Birth  | Newsletter | First Name | Last Name | email            | Company Name | User Name | Password | confirm password |
      | Male   | 1-January-2000 | Yes        | demos       | 4         | demos5@demos.com | Demos        | demo3     | 1234567  | 1234567          |

  @Login
  Scenario Outline: To test Login Functionality
    Given user is in Home page
    When user clicks Log in link
    And the "Given user is in Home page" message appears
    And user enters "<user id>" and "<password>" and clicks log in button
    Then he should be successfully logged in
    When user clicks on Logout
    Then he should be successfully logged out

    Examples:
      | user id          | password |
      | demos1@demos.com | 1234567  |

  @ChangePassword
    Scenario Outline: To Change password of a User
    Given user is in Home page
    When user clicks Log in link
    And the "Given user is in Home page" message appears
    And user enters "<user id>" and "<password>" and clicks log in button
    Then he should be successfully logged in
    When user clicks on MY ACCOUNT link after logging in
    And updates Company Name to "<Company Name>"
    And Clicks Save button
    Then Company name should get updated as "<Company Name>"
    When user clicks on Logout
    Then he should be successfully logged out
    Examples:

      | user id          | password |Company Name|
      | demos1@demos.com | 1234567  |Demos2      |
