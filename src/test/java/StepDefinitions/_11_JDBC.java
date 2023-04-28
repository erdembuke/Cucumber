package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBC {
    DialogContent dc = new DialogContent();
    @Then("Send the query to the database {string} and control match")
    public void sendTheQueryToTheDatabaseAndControlMatch(String query) {
        // db den gerekli bilgileri al
        ArrayList<ArrayList<String>> dbList = DBUtility.queryResult(query);

        // UI dan gerekli bilgileri al
        List<WebElement> UIList = dc.nameList;


        for (int i = 0; i < dbList.size(); i++) {
            System.out.print(dbList.get(i).get(1).trim());
            System.out.println("\t" + UIList.get(i).getText().trim());
            // ustteki print'lere gerek kalmadi
            Assert.assertEquals(dbList.get(i).get(1).trim() ,
                    UIList.get(i).getText().trim());
        }
    }
}
