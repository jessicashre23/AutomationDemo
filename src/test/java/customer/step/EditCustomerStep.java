package customer.step;

import base.BaseDriver;
import customer.model.Customer;
import customer.page.CustomerPage;
import customer.page.DeleteCustomerPage;
import customer.page.EditCustomerPageCustomerID;
import customer.page.EditCustomerPageForm;
import homepage.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EditCustomerStep {
    private HomePage homePage;
    private CustomerPage customerPage;
    private EditCustomerPageCustomerID editCustomerPageCustomerID;
    private EditCustomerPageForm editCustomerPageTwo;
    private WebDriver driver;
    private Customer customer;
    private DeleteCustomerPage deleteCustomerPage;
    private Alert alert;

    @When("I click on edit customer")
    public void iClickOnEditCustomer() {
        homePage = new HomePage();
        driver = BaseDriver.getBaseDriver().getDriver();
        homePage.clickEditCustomer();
    }

    @And("I enter Customer ID and submit")
    public void iEnterCustomerIDAndSubmit() {
        EditCustomerPageCustomerID editCustomerPageCustomerID = new EditCustomerPageCustomerID();
        editCustomerPageCustomerID.setCustomerID();
        editCustomerPageCustomerID.clickSubmit();
    }

    @Then("Form appears where I edit and submit")
    public void formAppearsWhereIEditAndSubmit() {
        EditCustomerPageForm editCustomerPageForm = new EditCustomerPageForm(driver);
        editCustomerPageForm.editCustomer();
        editCustomerPageForm.clickSubmit();
        editCustomerPageForm.clickContinue(); //on edited customer page
    }

    @When("I click on delete customer")
    public void iClickOnDeleteCustomer() {
        homePage = new HomePage();
        driver = BaseDriver.getBaseDriver().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickDeleteCustomer();
    }

    @And("I submit customer ID")
    public void iSubmitCustomerID() {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.setCustomerID();
        deleteCustomerPage.clickSubmit();
    }

    @Then("I accept confirmation to delete customer")
    public void iAcceptConfirmationToDeleteCustomer() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertTrue(deleteCustomerPage.getAlertMessage().contains("Do you really want to delete this Customer?"));
        deleteCustomerPage.acceptAlert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(deleteCustomerPage.getAlertMessage().contains("Customer deleted Successfully"));
        deleteCustomerPage.acceptAlert();
    }
}
