Feature: Check the sub pages

  Scenario: Navigate to Terms of Sale page
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Terms of Sale" button
    Then I should navigate to "https://www.westerndigital.com/legal/terms-and-conditions-of-sale-consumer" page

  Scenario: Navigate to Trademarks page
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Trademarks" button
    Then I should navigate to "https://www.westerndigital.com/legal/trademarks" page

  Scenario: Navigate to Product Compliance page
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Product Compliance" button
    Then I should navigate to "https://www.westerndigital.com/company/corporate-responsibility/environment#product-compliance" page
