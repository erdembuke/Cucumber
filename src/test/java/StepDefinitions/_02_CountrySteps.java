package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {
        LeftNav ln = new LeftNav();
        DialogContent dc = new DialogContent();
        @And("Navigate to country page")
        public void navigateToCountryPage() {
            ln.clickFunction(ln.setupTab);
            ln.clickFunction(ln.parametersTab);
            ln.clickFunction(ln.countries);
        }

        @When("create a country")
        public void createCountry() {
            String countryName = RandomStringUtils.randomAlphanumeric(8); // harf üretiyo
            String countryCode = RandomStringUtils.randomNumeric(4);

            dc.clickFunction(dc.addBtn);
            dc.sendKeysFunction(dc.nameInput , countryName);
            dc.sendKeysFunction(dc.codeInput , countryCode);
            dc.clickFunction(dc.saveButton);
        }


        @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
            ln.verifyContainsTextFunction(dc.successMessage , "success");
        }


    @When("create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String country, String code) {
            dc.clickFunction(dc.addBtn);
            dc.sendKeysFunction(dc.nameInput , country);
            dc.sendKeysFunction(dc.codeInput , code);
            dc.clickFunction(dc.saveButton);

    }
}


