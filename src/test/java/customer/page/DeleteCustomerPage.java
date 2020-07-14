package customer.page;

import base.BaseDriver;
import customer.model.Customer;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
    private WebDriver driver;
    private Alert alert;
    private Customer customer;

    public DeleteCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")
    WebElement customerID;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input[1]")
    WebElement btnSubmit;

    public void setCustomerID(){
        customer= BaseDriver.getBaseDriver().getCustomer();
        String cid=customer.getCustomerID();
        customerID.sendKeys(cid);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public String getAlertMessage() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert(){
//        alert=driver.switchTo().alert();
        alert.accept();
    }
}
