package login.step;

import homepage.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.mapper.LoginMapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.FileNotFoundException;

public class LogoutStep {
    private WebDriver driver;
    private HomePage homePage;

    @When("I am in homepage")
    public void iAmInHomepage() {
        homePage = new HomePage();
        Assert.assertTrue(homePage.getManagerId().contains("Manger Id : mngr272391"));
    }

    @And("I click on logout")
    public void iClickOnLogout() {
        homePage.clickLogout();
    }


    @Then("I get logout message")
    public void iGetLogoutMessage() throws FileNotFoundException {
        LoginMapper loginMapper=new LoginMapper();
        try{
            Assert.assertTrue(homePage.getAlertMessage().contains("You Have Succesfully Logged Out!!"));
            loginMapper.setStatus(4,4,"Completed");
        }catch (AssertionError e){
            loginMapper.setStatus(4,4,"Failed");
            Assert.fail();
        }
        homePage.setAlert();}
}
