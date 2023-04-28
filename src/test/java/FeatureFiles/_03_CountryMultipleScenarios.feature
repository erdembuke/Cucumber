Feature: Country Multi Scenario
  Background: #BeforeScenario
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully
    And Navigate to country page

  Scenario: Create country
    When create a country
    Then Success message should be displayed

  Scenario: Create country 2
    When create a country name as "erdemUlke22" code as "erd21"
    Then Success message should be displayed