#Senaryo
#CitizenShip sayfasina gidiniz
#Create islemini dogrulayin
#Daha sonra ayni bilgilerle tekrar Create yapilamadigini dogrulayin

Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully
    And Navigate to citizenship page

  Scenario Outline: Citizenship create fail
    When create a non-existing citizenship name as "<name>" and short name as "<short>"
    Then Success message should be displayed

    When create a existing citizenship name as "<name>" and short name as "<short>"
    Then Fail message should be displayed

    #TODO: do it
    When User delete the "<name>"
    Then Success message should be displayed

    Examples:
      | name | short  |
      | erdembuke333 | erdem  |
      | technostudy331 | techno13 |



