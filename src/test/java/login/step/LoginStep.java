package login.step;

import base.BaseDriver;
import homepage.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.mapper.LoginMapper;
import login.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class LoginStep {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private LoginMapper loginMapper;

    @Before
    public void setup() {
        driver = BaseDriver.getBaseDriver().getDriver();
    }


    @When("I go to login page")
    public void iGoToLoginPage() {
        loginPage = new LoginPage(driver);

    }

    @And("I submit incorrect username and password")
    public void iSubmitIncorrectUsernameAndPassword() {
        loginPage.wrongLogin();
        loginPage.setLoginButton();
    }

    @Then("I should receive an invalid message")
    public void iShouldReceiveAnInvalidMessage() throws FileNotFoundException {
        LoginMapper loginMapper=new LoginMapper();
        try {
            Assert.assertTrue(loginPage.getAlertMessage().contains("User or Password is not valid"));
            //loginMapper.setStatus(1,4,"Completed");
            loginMapper.setStatus(1,4,"Completed");
        }catch (AssertionError e){
           // loginMapper.setStatus(1,4,"Failed");
            loginMapper.setStatus(1,4,"Failed");
            Assert.fail();
        }

        loginPage.setAlert();
    }

    @When("I return back on login page")
    public void iReturnBackOnLoginPage() {
        driver = BaseDriver.getBaseDriver().getDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("I enter incorrect username and password")
    public void iEnterIncorrectUsernameAndPassword() {
        loginPage.wrongLogin();
    }

    @Then("I click reset and return back to login page")
    public void iClickResetAndReturnBackToLoginPage() throws FileNotFoundException {
        loginPage.clickReset();
        LoginMapper loginMapper=new LoginMapper();
        loginMapper.setStatus(2,4,"Completed");
    }

    @When("I return back to login page")
    public void iReturnBackToLoginPage() {
        driver = BaseDriver.getBaseDriver().getDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("I submit correct username and password")
    public void iSubmitCorrectUsernameAndPassword() {
        loginPage.rightLogin();
        loginPage.setLoginButton();
    }

    @Then("I should go to homepage")
    public void iShouldGoToHomepage() throws FileNotFoundException {
        homePage = new HomePage();
        LoginMapper loginMapper=new LoginMapper();
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertTrue(homePage.getManagerId().contains("Manger Id : mngr272391"));
            loginMapper.setStatus(3,4,"Completed");
        }catch (AssertionError e){
            loginMapper.setStatus(3,4,"Failed");
            Assert.fail();
        }
    }
}
