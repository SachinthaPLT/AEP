Feature: Western Digital User Sign In

  Scenario: Log in to Western Digital
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the Log In button
    And I click on the Sign in button
    And I Select account type as "For myself"
    And I Type email as "sslakmal31@gmail.com" in sign in page
    And I Type password as "Test@12345678910$" in sign in page
    And I click on Sign in button
    Then Then user should landed to Home page and should be able to see the "Welcome, Sachintha!"

