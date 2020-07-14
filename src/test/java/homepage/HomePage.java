package homepage;

import base.BaseDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private Alert alert;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
    private WebElement managerId;

    @FindBy(linkText = "New Customer")
    private WebElement newCustomerMenu;

    @FindBy(linkText = "Edit Customer")
    private WebElement editCustomerMenu;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    private WebElement logoutMenu;

    @FindBy(linkText = "Delete Customer")
    private WebElement deleteCustomerMenu;

    public HomePage() {
        driver = BaseDriver.getBaseDriver().getDriver();

        PageFactory.initElements(driver, this);
    }

    public String getManagerId() {
        return managerId.getText();
    }

    public void clickNewCustomer() {
        newCustomerMenu.click();
    }

    public void clickEditCustomer() {
        editCustomerMenu.click();
    }

    public void clickLogout() {
        logoutMenu.click();
    }

    public String getAlertMessage() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void setAlert() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickDeleteCustomer() {
        deleteCustomerMenu.click();
    }
}
