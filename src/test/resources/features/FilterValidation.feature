Feature: Check the Filters

  Scenario: Check the Product filter on Home page
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Products" button on top navigation
    And I click on "Internal HDDs"
    And I Filter the "WD_BLACK" products by using "Brand" filter
    Then I should see the "WD_BLACK Internal HDD" text on top of the product list