#Senaryo
 # siteye git -> test case -> adim
 # login bilgilerini gir
 # siteye girdigini dogrula

  Feature: Login Functionality

    @SmokeTest
    Scenario: Login with valid username and password

      Given Navigate to Campus
      When  Enter username and password correctly and click login button
      Then  User should login successfully