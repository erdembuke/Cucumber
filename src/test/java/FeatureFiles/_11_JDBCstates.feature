Feature: Testing JDBC States

  Background:
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully

  Scenario: States testing with JDBC
    And Click on the element in LeftNav
      | setupTab      |
      | parametersTab |
      | states        |
    Then Send the query to the database "select * from States" and control match