package parallel;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Properties;

public class AccPageStep {

    private final LoginPage loginPage;
    private  AccountsPage accPage;
    Properties prop;
    List<String> accPageheaderList;
    SearchResultsPage serPage;
    int productCount;
    boolean logoutFlag;

    public AccPageStep(Hooks hooks){
        this.loginPage=hooks.getLoginPage();
        this.prop =hooks.getProperties();
    }

    @Given("when user is on the account page")
    public void when_user_is_on_the_account_page() {
        accPage =loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }
    @When("user finds the list header of the account page")
    public void user_finds_the_list_header_of_the_account_page() {
        accPageheaderList = accPage.getAccPageHeaders();
    }
    @Then("user should be able find the below headers on the acc page")
    public void user_should_be_able_find_the_below_headers_on_the_acc_page(DataTable expectedHeaderList) {
        List<String> expectedList = expectedHeaderList.asList();
        Assert.assertEquals(accPageheaderList,expectedList);
    }



    @When("user search for the {string}")
    public void userSearchForThe(String productName) {
        serPage= accPage.doSearch(productName);
        productCount=serPage.getSearchResultsCount();
    }

    @Then("user should be able to find {int} products")
    public void userShouldBeAbleToFindResultCountProducts(int resultsCount) {
    Assert.assertEquals(productCount,resultsCount);
    }

    @When("user looks for logout link")
    public void userLooksForLogoutLink() {
        logoutFlag=accPage.isLogoutLinkExist();
    }

    @Then("user should be able to find the logout link")
    public void userShouldBeAbleToFindTheLogoutLink() {
        Assert.assertTrue(logoutFlag);
    }
}
