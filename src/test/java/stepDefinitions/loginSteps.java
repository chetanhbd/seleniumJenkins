package stepDefinitions;

import com.pages.accounts;
import com.pages.loginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginSteps {
    private loginPage login = new loginPage(DriverFactory.getDriver());

    private accounts account1 = new accounts(DriverFactory.getDriver());

    private static String title;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=my-account#account-creation");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
    title = login.getLoginPageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertTrue(title.contains(string));

    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
    Assert.assertTrue(login.isForgotPasswordLinkExist());

    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
    login.enterUserName(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
    login.enterPassword(string);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        login.clickLogin();
    }

    @Then("account page title should be {string}")
    public void account_page_title_should_be(String string) {
    /*title = account1.getAccountPageTitle();
    Assert.assertTrue(title.contains(string));*/
    }

}
