package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_Login_Steps {
    DialogContent dc = new DialogContent();
    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().navigate().to("https://test.mersys.io/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password correctly and click login button")
    public void enterUsernameAndPasswordCorrectlyAndClickLoginButton() {
//        WebDriverWait wait = new WebDriverWait(GWD.getDriver() , Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(dc.username));
//        dc.username.sendKeys("turkeyts");
//        dc.password.sendKeys("TechnoStudy123");
        dc.sendKeysFunction(dc.username , "turkeyts");
        dc.sendKeysFunction(dc.password , "TechnoStudy123");
        dc.clickFunction(dc.loginButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dc.verifyElementDisplayed(dc.dashboardMenu);
    }
}
