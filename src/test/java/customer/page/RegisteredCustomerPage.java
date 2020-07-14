package customer.page;

import base.BaseDriver;
import customer.model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RegisteredCustomerPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
    private WebElement customerID;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[5]/td[2]")
    private WebElement customerName;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[6]/td[2]")
    private WebElement gender;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[7]/td[2]")
    private WebElement dob;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[8]/td[2]")
    private WebElement address;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[9]/td[2]")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[10]/td[2]")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[11]/td[2]")
    private WebElement pin;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[12]/td[2]")
    private WebElement mobile;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[13]/td[2]")
    private WebElement email;

    @FindBy(linkText = "Continue")
    private WebElement btnContinue;

    public RegisteredCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public void getRegisteredCustomer() {
        driver = BaseDriver.getBaseDriver().getDriver();
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        Customer customer = BaseDriver.getBaseDriver().getCustomer();
        customer.setCustomerID(customerID.getText());
        customer.setCustomerName(customerName.getText());
        customer.setGender(gender.getText());
        customer.setDob(dob.getText());
        customer.setAddress(address.getText());
        customer.setCity(city.getText());
        customer.setState(state.getText());
        customer.setPin(pin.getText());
        customer.setEmail(email.getText());
        customer.setMobile(mobile.getText());

        BaseDriver.getBaseDriver().setCustomer(customer);
    }
}
