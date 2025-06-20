Feature: Login Feature with Excel

  Scenario: Login to Western Digital using Excel Data
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the Log In button
    And I click on the Sign in button
    And I Select account type as "For myself"
    And I enter username and passwords from excel file
    And I click on Sign in button