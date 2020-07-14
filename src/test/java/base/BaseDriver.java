package base;

import customer.model.Customer;
import login.mapper.LoginMapper;
import login.model.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    private WebDriver driver;
    private static BaseDriver baseDriver;
    private Customer customer;
    private Login login;
    private LoginMapper loginMapper;

    private BaseDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.demo.guru99.com/V4/index.php");
        driver.manage().window().maximize();
    }

    public static BaseDriver getBaseDriver() {
        if (null == baseDriver) {
            baseDriver = new BaseDriver();
        }
        return baseDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void printSingleton() {
        System.out.println("Inside print Singleton");
    }

    //getter setter for customer pojo
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //getter setter for login pojo
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LoginMapper getLoginMapper() {
        return loginMapper;
    }

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }
}
