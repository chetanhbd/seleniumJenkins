package stepDefinitions;

import com.pages.accounts;
import com.pages.loginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.List;
import java.util.Map;

public class accountSteps {
   private loginPage loginpage1 = new loginPage(DriverFactory.getDriver());
   private accounts accounts1 ;
    @Given("user has already logged into the application")
    public void user_has_already_logged_into_the_application(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps();
        String username1 = credentials.get(0).get("username");
        String password1 = credentials.get(0).get("password");
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-accoun");
        accounts1 = loginpage1.loginFunction(username1, password1);

    }

    @When("user is on accounts page")
    public void user_is_on_accounts_page() throws InterruptedException {

        String title = accounts1.getAccountPageTitle();
        System.out.println(title);

    }

    @Then("my account information should be displayed")
    public void my_account_information_should_be_displayed(DataTable dataTable) {
    List<String> expectedList = dataTable.asList();
    List<String> actualList = accounts1.accountList();
        Assert.assertTrue(expectedList.containsAll(actualList));

    }

    @Then("account count should be {int}")
    public void account_count_should_be(Integer int1) {
        Assert.assertTrue(int1==accounts1.accountCount());

    }
}
