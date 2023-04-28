package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _05_DataTableOrnek {

    @When("write username {string}")
    public void writeUsername(String userName) {
        System.out.println("userName = " + userName);
    }

    @And("write username and password {string} {string}")
    public void writeUsernameAndPassword(String userName , String password) {
        System.out.println("userName and password = " + userName + " " +  password);
    }


    @And("write username as DataTable")
    public void writeUsernameAsDataTable(DataTable items) {
        List<String> itemsList = items.asList(String.class);

        for (String a : itemsList) {
            System.out.println(a);
        }
    }

    @And("write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable items) {
        List<List<String>> listElements =  items.asLists(String.class);

        for (int i = 0; i < listElements.size(); i++) {
            System.out.println(listElements.get(i).get(0) + " "
            + listElements.get(i).get(1));

        }


    }
}
