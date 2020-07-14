Feature: edit and delete existing customer
  this feature brings up the form to edit existing customer

  Scenario: edit customer
    When I click on edit customer
    And I enter Customer ID and submit
    Then Form appears where I edit and submit

  Scenario: Delete existing customer
    When I click on delete customer
    And I submit customer ID
    Then I accept confirmation to delete customer