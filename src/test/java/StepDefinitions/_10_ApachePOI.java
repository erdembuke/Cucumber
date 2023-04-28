package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _10_ApachePOI {
    DialogContent dc = new DialogContent();
    @When("User Create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String >> datas =
                ExcelUtility.getInfoUntilColumn("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for (ArrayList<String> satir : datas) {
            dc.clickFunction(dc.addBtn);
            dc.sendKeysFunction(dc.nameInput,satir.get(0));
            dc.sendKeysFunction(dc.shortInput,satir.get(1));
            dc.clickFunction(dc.saveButton);
        }


    }

    @Then("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> data =
                ExcelUtility.getInfoUntilColumn("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for (ArrayList<String> datas : data) {
            dc.deleteItem(datas.get(0));
        }
    }
}
