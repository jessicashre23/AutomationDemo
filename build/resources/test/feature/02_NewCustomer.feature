Feature: Add new customer
  this feature file enters new customer form and fills it

  Scenario: test reset button on customer add form
    Given I am on homepage
    When I click on new customer menu
    And I fill up fields in the customer form
    Then I click on reset button

  Scenario: fill up new customer form
    When I am back add customer form page
    And I fill up all the fields in the form
    Then I click on submit