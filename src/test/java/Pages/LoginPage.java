package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By usernameHeader = By.id("login2");
    private By usernameTextBox = By.id("loginusername");
    private By passwordTextBox = By.id("loginpassword");
    private By loginButton = By.xpath("//button[@class='btn btn-primary' and text()='Log in']");


    public LoginPage clickUsernameHeader() {  // method same class
        driver.findElement(usernameHeader).click();
        return this; // after end will return the object (registerPage)
    }

    public LoginPage fillUsernameTextBox(String username) {
        driver.findElement(usernameTextBox).sendKeys(username);
        return this;
    }

    public LoginPage fillPasswordTextBox(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

}
