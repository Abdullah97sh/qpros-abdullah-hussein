package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoriesPage {
    WebDriver driver;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    private By categorySelector = By.cssSelector("a#itemc");
//    private List<WebElement> categorySelector() { ///
//        return driver.findElements(By.cssSelector("a#itemc"));
//    }

    // private List<WebElement> dynamicElement = driver.findElements(By.id("tbodyid"));
    private By dynamicElementSelector = By.id("tbodyid");   /// ???

    public CategoriesPage checkCategoriesItems() throws InterruptedException {
        // Iterate through the categories and check if they have items

//        List<WebElement> categoryList = categorySelector;
        for (WebElement category : driver.findElements(categorySelector)) {
            // Get the category name
            String categoryName = category.getText();

            category.click();  // case issue
            Thread.sleep(1500);


            // category has items ??
            List<WebElement> dynamicElements = driver.findElements(dynamicElementSelector);
            if (dynamicElements.size() != 0) {
                //If list size is non-zero, element is present
                System.out.println("====================== " + categoryName + " Category has items =====================");
            } else {
                //Else if size is 0, then element is not present
                System.out.println("====================== " + categoryName + " Category didn't has items =====================");
            }

            // just to view the items names
            for (WebElement webElement : dynamicElements) {
                String itemName = webElement.getText();
                System.out.println(itemName + "\n" + "\n");
            }
            Thread.sleep(1500);
        }
        return this;
    }

    public CategoriesPage toHome() {
        driver.navigate().to("https://www.demoblaze.com/index.html");
        return this;
    }
}
