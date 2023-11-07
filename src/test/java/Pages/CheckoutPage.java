package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By placeOrderBtn = By.xpath("//button[@class='btn btn-success']");
    private By nameTextBox = By.id("name");
    private By countryTextBox = By.id("country");
    private By cityTextBox = By.id("city");
    private By cardTextBox = By.id("card");
    private By monthTextBox = By.id("month");
    private By yearTextBox = By.id("year");
    private By purchaseButton = By.xpath("//button[@class='btn btn-primary'  and text()='Purchase']");
    private By okAlert = By.xpath("//button[@class='confirm btn btn-lg btn-primary'  and text()='OK']");


    public CheckoutPage clickPlaceOrderBtn() {
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public CheckoutPage fillNameTextBox(String name) {
        driver.findElement(nameTextBox).sendKeys(name);
        return this;
    }

    public CheckoutPage fillCountryTextBox(String country) {
        driver.findElement(countryTextBox).sendKeys(country);
        return this;
    }

    public CheckoutPage fillCityTextBox(String city) {
        driver.findElement(cityTextBox).sendKeys(city);
        return this;
    }

    public CheckoutPage fillCardTextBox(String card) {
        driver.findElement(cardTextBox).sendKeys(card);
        return this;
    }

    public CheckoutPage fillMonthTextBox(String month) {
        driver.findElement(monthTextBox).sendKeys(month);
        return this;
    }

    public CheckoutPage fillYearTextBox(String year) {
        driver.findElement(yearTextBox).sendKeys(year);
        return this;
    }

    public CheckoutPage clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
        return this;
    }

    public CheckoutPage clickOkAlert() {
        driver.findElement(okAlert).click();
        return this;
    }
}




