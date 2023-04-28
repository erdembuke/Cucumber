package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to citizenship page")
    public void navigateToCitizenshipPage() {
        ln.clickFunction(ln.setupTab);
        ln.clickFunction(ln.parametersTab);
        ln.clickFunction(ln.citizenships);

    }

    @When("create a non-existing citizenship name as {string} and short name as {string}")
    public void createANonExistingCitizenshipNameAsAndShortNameAs(String name, String shortName) {
        dc.clickFunction(dc.addBtn);
        dc.sendKeysFunction(dc.nameInput , name);
        dc.sendKeysFunction(dc.shortInput , shortName);
        dc.clickFunction(dc.saveButton);
    }

    @When("create a existing citizenship name as {string} and short name as {string}")
    public void createAExistingCitizenshipNameAsAndShortNameAs(String name, String shortName) {
        dc.clickFunction(dc.addBtn);
        dc.sendKeysFunction(dc.nameInput , name);
        dc.sendKeysFunction(dc.shortInput , shortName);
        dc.clickFunction(dc.saveButton);
    }

    @Then("Fail message should be displayed")
    public void failMessageShouldBeDisplayed() {
        ln.verifyContainsTextFunction(dc.alertBar , "already exist");
    }


    @When("User delete the {string}")
    public void userDeleteThe(String text) {
        dc.deleteItem(text);
    }
}
