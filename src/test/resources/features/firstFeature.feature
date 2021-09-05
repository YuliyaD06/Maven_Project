Feature: TestRail API Test

  Scenario: Check Project was added
    Given I start execution
    When I add 1 and 2
    Then I verify that result equals 3

  Scenario: Check Suite was added
    Given I start execution
    When I subtract 2 and 1
    Then I verify that result equals 1