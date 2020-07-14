package customer.page;

import base.BaseDriver;
import customer.model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class EditCustomerPageForm {
    private WebDriver driver;


    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
    private WebElement address;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
    private WebElement city;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
    private WebElement state;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")
    private WebElement pin;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")
    private WebElement mobile;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")
    private WebElement email;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]")
    private WebElement btnSubmit;

    public EditCustomerPageForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAddress(String addressS)
    {
        address.sendKeys(addressS);
    }

    public void clearAddress(){
        address.clear();
    }
    public void setAddress(WebElement address) {
        this.address = address;
    }

    public void setCity(String cityS) {
        city.sendKeys(cityS);
    }
    public void clearCity(){
        city.clear();
    }
    public void setCity(WebElement city) {
        this.city = city;
    }

    public void setState(String stateS) {
        state.sendKeys(stateS);
    }
    public void clearState(){
        state.clear();
    }
    public void setState(WebElement state) {
        this.state = state;
    }

    public void setPin(String pinS) {
        pin.sendKeys(pinS);
    }
    public void clearPin(){
        pin.clear();
    }

    public void setPin(WebElement pin) {
        this.pin = pin;
    }

    public void setMobile(String mobileS)
    {
        mobile.sendKeys(mobileS);
    }
    public void clearMobile(){
        mobile.clear();
    }
    public void setMobile(WebElement mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String emailS) {
        email.sendKeys(emailS);
    }
    public void clearEmail(){
        email.clear();
    }
    public void setEmail(WebElement email) {
        this.email = email;
    }


    public void clickSubmit() {
        btnSubmit.click();
    }

    //--------after editing customer--------//
    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[14]/td/a")
    private WebElement btnContinue;

    public void clickContinue(){
        btnContinue.click();
    }
    //---------//

    public void editCustomer(){
        Customer customer= BaseDriver.getBaseDriver().getCustomer();
        clearAddress();
        customer.setAddress("editedaddress st");
        clearCity();
        customer.setCity("Los Angeles");
        clearState();
        customer.setState("California");
        clearPin();
        customer.setPin("657465");
        clearMobile();
        customer.setMobile("5544332211");
        clearEmail();
        Random random=new Random();
        int num=random.nextInt(9);
        customer.setEmail(num+"@edited.com");


        address.sendKeys(customer.getAddress());
        city.sendKeys(customer.getCity());
        state.sendKeys(customer.getState());
        pin.sendKeys(customer.getPin());
        email.sendKeys(customer.getEmail());
        mobile.sendKeys(customer.getMobile());
    }
}
