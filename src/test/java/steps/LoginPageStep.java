package steps;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ScenarioContext;


public class LoginPageStep {
    private final LoginPage loginPage;

    String loginPageURL;
    boolean forgotLinkFlag;
    String accPageTitle;
    ScenarioContext scenarioContext;

    public LoginPageStep(Hooks hooks, ScenarioContext scenarioContext) {
        this.loginPage = hooks.getLoginPage();
        this.scenarioContext = scenarioContext;
    }

    @Given("the user is on the login page")
    public void user_on_loginPage() {

    }

    @When("the user fetches the page title")
    public void getLoginPageTitle() {

        String actTitle = loginPage.getLoginPageTitle();
        scenarioContext.setContext("actTitle",actTitle);
    }


    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        Assert.assertEquals(scenarioContext.getContext("actTitle").toString(), expectedTitle);
    }

    @Then("the page title should not be empty")
    public void thePageTitleShouldNotBeEmpty() {

        Assert.assertFalse(scenarioContext.getContext("actTitle").toString().isEmpty());
    }

    @When("the user checks the page URL")
    public void theUserChecksThePageURL() {

        String loginPageURL=loginPage.getLoginPageURL();
        scenarioContext.setContext("loginPageURL",loginPageURL);
    }


    @Then("the URL should contain {string}")
    public void theURLShouldContain(String fractionUrl) {
        Assert.assertTrue(scenarioContext.getContext("loginPageURL").toString().contains(fractionUrl));
    }

    @When("the user checks the forgot password link")
    public void theUserChecksTheForgotPasswordLink() {

        boolean forgotLinkFlag =loginPage.checkForgotPwdLinkExist();
        scenarioContext.setContext("forgotLinkFlag",forgotLinkFlag);
    }

    @Then("the forgot password link should be displayed")
    public void theForgotPasswordLinkShouldBeDisplayed() {
        Assert.assertTrue((Boolean) scenarioContext.getContext("forgotLinkFlag"));
    }

    @When("the user logs in with username {string} and password {string}")
    public void userLogsIn(String email,String password){
        AccountsPage accPage=loginPage.doLogin(email,password);
        String accPageTitle = accPage.getAccPageTitle();
        scenarioContext.setContext("accPageTitle",accPageTitle);

    }

    @Then("the user should be redirected to the accounts page with title {string}")
    public void accPageTitleCheck(String expectedAccPageTitle){
        Assert.assertEquals(scenarioContext.getContext("accPageTitle").toString(),expectedAccPageTitle);
    }
}
