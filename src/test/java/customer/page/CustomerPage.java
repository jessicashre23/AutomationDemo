package customer.page;

import base.BaseDriver;
import customer.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CustomerPage {
    private WebDriver driver;

    @FindBy(xpath ="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
    private WebElement customerName;

    private List<WebElement> gender;




  /* @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
   private WebElement genderFemale;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
    private WebElement genderMale;*/

    @FindBy(xpath = "//*[@id=\"dob\"]")
    private WebElement dob;

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

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input")
    private WebElement password;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
    private WebElement btnSubmit;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[2]")
    private WebElement btnReset;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")
    private WebElement pageTitle;




    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setCustomerName(String customerNameS){
        customerName.sendKeys(customerNameS);
    }

    public void setCustomerName(WebElement customerName){
        this.customerName=customerName;
    }

    public void selectGenderFemale(){
        gender.get(1).click();
        // genderFemale.click();
    }

    public void selectGenderMale(){
        gender.get(0).click();
        //genderMale.click();
    }

    public void setDob(String dobS){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].type = arguments[1]", dobS, "text");
        dob.sendKeys(dobS);
    }

    public void setDob(WebElement dob){
        this.dob=dob;
    }

    public void setAddress(String addressS){
        address.sendKeys(addressS);
    }

    public void setAddress(WebElement address){
        this.address=address;
    }

    public void setCity(String cityS){
        city.sendKeys(cityS);
    }

    public void setCity(WebElement city){
        this.city=city;
    }

    public void setState(String stateS){
        state.sendKeys(stateS);
    }

    public void setState(WebElement state){
        this.state=state;
    }

    public void setPin(String pinS){
        pin.sendKeys(pinS);
    }

    public void setPin(WebElement pin){
        this.pin=pin;
    }

    public void setMobile(String mobileS){
        mobile.sendKeys(mobileS);
    }

    public void setMobile(WebElement mobile){
        this.mobile=mobile;
    }

    public void setEmail(String emailS){
        email.sendKeys(emailS);
    }

    public void setEmail(WebElement email){
        this.email=email;
    }

    public void setPassword(String passwordS){
        password.sendKeys(passwordS);
    }

    public void setPassword(WebElement password){
        this.password=password;
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void clickReset(){
        btnReset.click();
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void addCustomer() {
        Customer customer=new Customer();
        customer.setCustomerName("John Doe");
        customer.setGender("male");
        customer.setDob("06201968");
        customer.setAddress("123 address st");
        customer.setCity("Atlanta");
        customer.setState("Georgia");
        customer.setPin("234543");
        customer.setMobile("1122334455");
        Random random=new Random();
        int rand=random.nextInt(9);
        customer.setEmail(rand+"@email.com");
        customer.setPassword("pass1");


        customerName.sendKeys(customer.getCustomerName());
        gender=driver.findElements(By.name("rad1"));
        if (customer.getGender().equals("male")) {
            selectGenderMale();
        }
        else {
            selectGenderFemale();
        }
        //genderFemale.click();
        dob.sendKeys(customer.getDob());
        address.sendKeys(customer.getAddress());
        city.sendKeys(customer.getCity());
        state.sendKeys(customer.getState());
        pin.sendKeys(customer.getPin());
        mobile.sendKeys(customer.getMobile());
        email.sendKeys(customer.getEmail());
        password.sendKeys(customer.getPassword());

        BaseDriver.getBaseDriver().setCustomer(customer);

    }
}
