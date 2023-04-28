Feature: Citizenship ApachePOI

  Background:
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully
    And Navigate to citizenship page

    Scenario: Create and delete Citizenship from excel with ApachePOI
      When User Create citizenship with ApachePOI
      Then User Delete citizenship with ApachePOI