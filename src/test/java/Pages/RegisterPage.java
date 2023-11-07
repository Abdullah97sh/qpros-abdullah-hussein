package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By signupHeader = By.id("signin2");
    private By usernameTextBox = By.id("sign-username");
    private By passwordTextBox = By.id("sign-password");
    private By signupButton = By.xpath("//button[@class='btn btn-primary' and text()='Sign up']");


    public RegisterPage clickSignupHeader() {
        driver.findElement(signupHeader).click();
        return this; // after end will return the object (registerPage)
    }

    public RegisterPage fillUsernameTextBox(String username) {
        driver.findElement(usernameTextBox).sendKeys(username);
        return this;
    }

    public RegisterPage fillPasswordTextBox(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public RegisterPage clickSignupButton() throws InterruptedException {
        driver.findElement(signupButton).click();
        Thread.sleep(1500);
        driver.switchTo().alert().accept();
        return this;
    }
}
