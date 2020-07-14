package customer.page;

import base.BaseDriver;
import customer.model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class EditCustomerPageCustomerID {
    private WebDriver driver;
    private Customer customer;
    private CustomerPage customerPage;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")
    private WebElement customerID;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")
    private WebElement btnSubmit;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[2]")
    private WebElement btnReset;

    public EditCustomerPageCustomerID() {
        driver = BaseDriver.getBaseDriver().getDriver();
        PageFactory.initElements(driver, this);
    }

    public void setCustomerID() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        customer = BaseDriver.getBaseDriver().getCustomer();
        String cid = customer.getCustomerID();
        customerID.sendKeys(cid);

    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public void clickReset() {
        btnReset.click();
    }
}
