package login.page;

import base.BaseDriver;
import login.mapper.LoginMapper;
import login.model.Login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "uid")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    @FindBy(name = "btnReset")
    WebElement resetButton;

    private WebDriver driver;
    private Alert alert;
    private LoginMapper loginMapper;
    private Login login;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String usernameS) {

        username.sendKeys(usernameS);
    }

    public void setUsername(WebElement username) {

        this.username = username;
    }

    public String getUsername() {
        return username.getText();
    }

    public void setPassword(String passwordS) {

        password.sendKeys(passwordS);
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public String getPassword() {
        return password.getText();
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public void setResetButton() {
        resetButton.click();
    }

    public void setAlert() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void setUsernameAndPassword(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public String getAlertMessage() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void wrongLogin(){
        //Login login=new Login();
        //login.setUsername("Jessica");
        //login.setPassword("12345");
        loginMapper = new LoginMapper();
        login=loginMapper.getInvalidData();

        username.sendKeys(login.getUsername());
        password.sendKeys(login.getPassword());
        BaseDriver.getBaseDriver().setLogin(login);
    }

    public void rightLogin(){
        //Login login=new Login();
        // login.setUsername("mngr267081");
        // login.setPassword("rysapEt");
        loginMapper=new LoginMapper();
        login=loginMapper.getValidData();

        username.sendKeys(login.getUsername());
        password.sendKeys(login.getPassword());
    }

    public void clickReset(){
        resetButton.click();
    }
}
