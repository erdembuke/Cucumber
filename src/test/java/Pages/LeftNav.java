package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver() , this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    public WebElement setupTab;

    @FindBy(xpath = "//span[text()='Entrance Exams']")
    public WebElement examsTab;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    public WebElement examsMenu;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    public WebElement examSetupTab;

    @FindBy(xpath = "//span[text()='Parameters']")
    public WebElement parametersTab;

    @FindBy(xpath = "(//span[@class='nav-link-title ng-star-inserted'])[1]")
    public WebElement countries;

    @FindBy(xpath = "//span[text()='Citizenships']")
    public WebElement citizenships;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement feesTab;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//span[text()='States']")
    private WebElement states;

    public WebElement getWebElement(String elementName) {

        switch (elementName){
            case "setupTab": return setupTab;
            case "parametersTab": return parametersTab;
            case "countries": return countries;
            case "citizenships": return citizenships;
            case "nationalities": return nationalities;
            case "feesTab": return feesTab;
            case "examSetupTab": return examSetupTab;
            case "examsTab": return examsTab;
            case "examsMenu": return examsMenu;
            case "states": return states;
        }

        return null;
    }
}
