package steps;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Properties;

public class ProductInfoPageStep {
    private final LoginPage loginPage;
    private final Properties prop;
    AccountsPage accPage;
    SearchResultsPage searchPage;
    ProductInfoPage infoPage;
    Integer actImageCount;
    public ProductInfoPageStep(Hooks hooks){
        this.loginPage = hooks.getLoginPage();
        this.prop = hooks.getProperties();
    }

    @Given("The user lands on the {string} info page")
    public void the_user_lands_on_the_info_page(String productName) {
        accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        searchPage=accPage.doSearch(productName);
        infoPage =searchPage.selectProduct(productName);
    }
    @When("user finds total number of images for the product")
    public void user_finds_total_number_of_images_for_the_product() {
        actImageCount =infoPage.getProductImagesCount();
    }
    @Then("user should be able to find {int} images")
    public void user_should_be_able_to_find_images(Integer expectedImageCount) {
        Assert.assertEquals(actImageCount,expectedImageCount);
    }
}
