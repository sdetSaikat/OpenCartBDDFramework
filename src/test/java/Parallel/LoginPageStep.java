package parallel;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginPageStep {
    private final LoginPage loginPage;
    String actTitle;
    String loginPageURL;
    boolean forgotLinkFlag;
    String accPageTitle;

    public LoginPageStep(Hooks hooks) {
        this.loginPage = hooks.getLoginPage();
    }

    @Given("the user is on the login page")
    public void user_on_loginPage() {

    }

    @When("the user fetches the page title")
    public void getLoginPageTitle() {
        actTitle = loginPage.getLoginPageTitle();
    }


    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        Assert.assertEquals(actTitle, expectedTitle);
    }

    @Then("the page title should not be empty")
    public void thePageTitleShouldNotBeEmpty() {

        Assert.assertFalse(actTitle.isEmpty());
    }

    @When("the user checks the page URL")
    public void theUserChecksThePageURL() {
        loginPageURL=loginPage.getLoginPageURL();
    }


    @Then("the URL should contain {string}")
    public void theURLShouldContain(String fractionUrl) {
        Assert.assertTrue(loginPageURL.contains(fractionUrl));
    }

    @When("the user checks the forgot password link")
    public void theUserChecksTheForgotPasswordLink() {
        forgotLinkFlag =loginPage.checkForgotPwdLinkExist();
    }

    @Then("the forgot password link should be displayed")
    public void theForgotPasswordLinkShouldBeDisplayed() {
        Assert.assertTrue(forgotLinkFlag);
    }

    @When("the user logs in with username {string} and password {string}")
    public void userLogsIn(String email,String password){
        AccountsPage accPage=loginPage.doLogin(email,password);
        accPageTitle= accPage.getAccPageTitle();

    }

    @Then("the user should be redirected to the accounts page with title {string}")
    public void accPageTitleCheck(String expectedAccPageTitle){
        Assert.assertEquals(accPageTitle,expectedAccPageTitle);
    }
}
