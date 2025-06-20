Feature: Western Digital User Sign Up

  Scenario: Create a new personal account Western Digital
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the Log In button
    And I click on the Create an Account button
    And I Select account type as "For myself" and click on continue to registration
    And I Type firstname as "John" and lastname as "CR"
    And I Type email as "sslakmal31@gmail.com"
    And I Type password as "Test@123456789"
    And I Click consent checkbox
    And I click on Join Now button
    Then Then user should landed to Home page and should be able to see the "Welcome, John!"
