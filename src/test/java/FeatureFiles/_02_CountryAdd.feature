# Senaryo
  # login ol
  # setup -> parameters -> country ' a tikla
  # ulke gir

  Feature: Country Functionality

    @SmokeTest
    Scenario: Create Country
      Given Navigate to Campus
      When Enter username and password correctly and click login button
      Then  User should login successfully
      And Navigate to country page
      When create a country
      Then Success message should be displayed