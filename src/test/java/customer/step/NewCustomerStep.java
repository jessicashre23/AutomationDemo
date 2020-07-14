package customer.step;

import base.BaseDriver;
import customer.page.CustomerPage;
import customer.page.RegisteredCustomerPage;
import homepage.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NewCustomerStep {
    private WebDriver driver;
    private HomePage homePage;
    private CustomerPage customerPage;
    private RegisteredCustomerPage registeredCustomerPage;

    @Given("I am on homepage")
    public void iAmOnHomepage() {
        homePage = new HomePage();
        driver = BaseDriver.getBaseDriver().getDriver();
    }

    @When("I click on new customer menu")
    public void iClickOnNewCustomerMenu() {
        customerPage = new CustomerPage(driver);
        homePage.clickNewCustomer();

    }

    @And("I fill up fields in the customer form")
    public void iFillUpFieldsInTheCustomerForm() {
        customerPage.addCustomer();

    }

    @Then("I click on reset button")
    public void iClickOnResetButton() {
        customerPage.clickReset();
    }

    @When("I am back add customer form page")
    public void iAmBackAddCustomerFormPage() {
        driver = BaseDriver.getBaseDriver().getDriver();
        customerPage=new CustomerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Assert.assertTrue(customerPage.getPageTitle().contains("Add New Customer"));
    }

    @And("I fill up all the fields in the form")
    public void iFillUpAllTheFieldsInTheForm() {
        customerPage.addCustomer();
    }

    @Then("I click on submit")
    public void iClickOnSubmit() {
        customerPage.clickSubmit();

        registeredCustomerPage = new RegisteredCustomerPage(driver);
        registeredCustomerPage.getRegisteredCustomer();
        registeredCustomerPage.clickContinue();
    }
}
