Feature: Check the social media Pages

  Scenario: Validate Linked in page navigation
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Linked In" icon
    Then New tab should open and navigate to "https://www.linkedin.com/company/western-digital" page

  Scenario: Validate Instagram in page navigation
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Instagram" icon
    Then New tab should open and navigate to "https://www.instagram.com/westerndigital/" page

  Scenario: Validate Twitter in page navigation
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Twitter" icon
    Then New tab should open and navigate to "https://x.com/westerndigital" page

  Scenario: Validate Facebook in page navigation
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Facebook" icon
    Then New tab should open and navigate to "https://www.facebook.com/WesternDigitalCorporation" page

  Scenario: Validate Youtube in page navigation
    Given I navigate to "https://www.westerndigital.com/"
    When I click on the "Youtube" icon
    Then New tab should open and navigate to "https://www.youtube.com/channel/UCQpijqbZeCM3zLew0ZwiX4A" page
