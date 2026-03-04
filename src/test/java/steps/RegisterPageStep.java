package steps;

import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.utils.StringUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterPageStep {
    private final LoginPage loginPage;
    RegisterPage regPage;
    boolean registrationSuccess;
    public RegisterPageStep(Hooks hooks){
        this.loginPage=hooks.getLoginPage();
    }

    @Given("The user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        regPage =loginPage.navigateToRegisterPage();
    }
    @When("the user registers with {string},{string},{string},{string},{string}")
    public void the_user_registers_with(String firstName, String lastName, String teleNo, String password, String subscribeFlag)
    {
        registrationSuccess=regPage.userRegister(firstName,lastName, StringUtils.getRandomEmailId(),teleNo,password,subscribeFlag);
    }
    @Then("user should be able to register themselves.")
    public void user_should_be_able_to_register_themselves() {
        Assert.assertTrue(registrationSuccess);
    }



}
