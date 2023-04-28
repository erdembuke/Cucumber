package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _06_DataTableSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable items) {
       List<String> strButtons = items.asList(String.class);

       for (String btn : strButtons) {
           WebElement element = ln.getWebElement(btn);
           ln.clickFunction(element);
       }
    }

    @And("Click on the element in Dialog Content")
    public void clickOnTheElementInDialog(DataTable items) {
        List<String> list = items.asList(String.class);

        for (String btn : list) {
            WebElement element = dc.getWebElement(btn);
            dc.clickFunction(element);
        }
    }

    @And("User sending the keys in Dialog Content")
    public void userSendingTheKeysInDialogContent(DataTable items) {
        List<List<String>> lists = items.asLists(String.class);

        for (int i = 0; i < lists.size(); i++) {
            WebElement element = dc.getWebElement(lists.get(i).get(0));
            dc.sendKeysFunction(element , lists.get(i).get(1));
        }
    }

    @And("User delete item from Dialog Content")
    public void userDeleteItemFromDialogContent(DataTable items) {
        List<String> list = items.asList(String.class);

        for (String itemTxt : list) {
            dc.deleteItem(itemTxt);
        }
    }
}
