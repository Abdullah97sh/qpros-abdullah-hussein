package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class AddItemsPage {
    WebDriver driver;

    public AddItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // / private By itemsIds = By.xpath("//*[@class='hrefch']");

    // Define the WebElement for the dynamic elements
    private List<WebElement> dynamicElements() { ///
        return driver.findElements(By.xpath("//*[@class='hrefch']"));
    }

    private By addToCartButton = By.xpath("//a[@class='btn btn-success btn-lg']");


    public AddItemsPage addItems() throws InterruptedException {
        // /   List<WebElement> items = (List<WebElement>) driver.findElement(itemsIds);

        List<WebElement> elements = dynamicElements(); ///

        int maxLength = elements.size();
        // just to check the length
        // System.out.println(maxLength);

        // get random item
        Random randomItem = new Random();

        // add 3 items to cart
        for (int i = 0; i < 3; i++) {
            elements.get(randomItem.nextInt(maxLength)).click();  ///


            // Add the item to the cart
            driver.findElement(addToCartButton).click();

            // accept alert dialog
            Thread.sleep(1500);
            driver.switchTo().alert().accept();

            driver.navigate().back();
            driver.navigate().back();
        }
        return this;
    }

}
