package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DeleteItemPage {
    WebDriver driver;

    public DeleteItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By cartHeader = By.id("cartur");
    private By deleteButton = By.cssSelector("a[onclick*='deleteItem']");

    public DeleteItemPage clickCartHeader() {
        driver.findElement(cartHeader).click();
        return this;
    }

    public DeleteItemPage clickDeleteButton() {
        driver.findElement(deleteButton).click();
        return this;
    }
}
