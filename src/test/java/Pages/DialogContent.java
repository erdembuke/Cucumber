package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

// Page Object Model
public class DialogContent extends Parent{
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver() , this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css = "span[class='nav-link-title']")
    public WebElement dashboardMenu;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addBtn;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    public WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    public WebElement codeInput;

    @FindBy(css = "ms-integer-field[formcontrolname='priority']>input")
    public WebElement priorityInput;

    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;

    @FindBy(css = "dynamic-view[class='ng-star-inserted']")
    public WebElement alertBar;

    @FindBy(xpath="//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']/input")
    public WebElement shortInput;

    @FindBy(css="input[data-placeholder='Name']")
    public WebElement searchInput;

    @FindBy(xpath="//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath="(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement deleteDialogBtn;

    @FindBy(xpath = "//span[text()='Active']")
    private WebElement activeToggle;

    @FindBy(xpath = "(//div[contains(@id,'mat-select-value')])[1]")
    private WebElement periodSelect;

    @FindBy(xpath = "(//div[contains(@id,'mat-select-value')])[2]")
    private WebElement gradeSelect;

    @FindBy(xpath = "//span[text()=' 2022-2023 Academic Period ']")
    private WebElement periodSelect2;

    @FindBy(xpath = "//span[text()=' Blake ']")
    private WebElement gradeSelect2;

    @FindBy(xpath = "//tr[contains(@class, 'mat-row')]/td[2]")
    public List<WebElement> nameList;

    public void deleteItem(String searchText) {
        sendKeysFunction(searchInput , searchText);
        clickFunction(searchButton);
        //fuse-progress-bar/*   gözüküyor
        //beklet
        //1. StaleElemetn hatası verdi : erken buldum tez kaybettim
        //wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        //fuse-progress-bar/*    bu 0 olana kadar beklet
        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//fuse-progress-bar/*") , 0));
        clickFunction(deleteImageBtn);
        clickFunction(deleteDialogBtn);

    }

    public WebElement getWebElement(String elementName) {

        switch (elementName) {
            case "addBtn": return addBtn;
            case "saveButton": return saveButton;
            case "nameInput": return nameInput;
            case "codeInput": return codeInput;
            case "priorityInput": return priorityInput;
            case "activeToggle": return activeToggle;
            case "periodSelect": return periodSelect;
            case "periodSelect2": return periodSelect2;
            case "gradeSelect": return gradeSelect;
            case "gradeSelect2": return gradeSelect2;
        }

        return null;
    }
}
