Feature: Logout of site
  this feature log out the user

  Scenario: log out of the site
    When I am in homepage
    And I click on logout
    Then I get logout message