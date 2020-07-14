Feature: Check login modules
  This feature file checks user authentication via login

  Scenario: test invalid username and password
    When I go to login page
    And I submit incorrect username and password
    Then I should receive an invalid message

  Scenario: test reset button
    When I return back on login page
    And I enter incorrect username and password
    Then I click reset and return back to login page

  Scenario: test valid username and password
    When I return back to login page
    And I submit correct username and password
    Then I should go to homepage