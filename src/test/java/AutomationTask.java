import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class AutomationTask {
    // make the driver and randomUsername instantiated on class level - so all test cases can access it
    WebDriver driver;
    String randomUsername = "abdullah-" + ((int) (Math.random() * 20)) + "@qpros.com";

    // anything will add under @BeforeTest will run onr time before all test cases
    @BeforeTest
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    // anything will add under @AfterTest will run onr time after all test cases
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void openWebsite() {
        driver.navigate().to("https://www.demoblaze.com/");
    }

    @Test(priority = 2)
    public void register() throws InterruptedException {

        WebElement signupButton = driver.findElement(By.id("signin2"));
        signupButton.click();
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.id("sign-username"));
        WebElement password = driver.findElement(By.id("sign-password"));

        username.sendKeys(randomUsername);
        password.sendKeys("12345678");

        Thread.sleep(5000);
        password.submit();
    }

    @Test(priority = 3)
    public void login() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.id("loginusername"));
        WebElement password = driver.findElement(By.id("loginpassword"));

        username.sendKeys(randomUsername);
        password.sendKeys("12345678");

        Thread.sleep(5000);
        password.submit();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void checkCategories() throws InterruptedException {
        // last step go Home

        // Define a list of category elements
        By categorySelector = By.cssSelector("a#itemc");

        // Iterate through the categories and check if they have items
        for (WebElement category : driver.findElements(categorySelector)) {
            // Get the category name
            String categoryName = category.getText();

            category.click();
            Thread.sleep(2000);


            // category has items ??
            List<WebElement> dynamicElement = driver.findElements(By.id("tbodyid"));

            if (dynamicElement.size() != 0) {
                //If list size is non-zero, element is present
                System.out.println("====================== " + categoryName + " Category has items =====================");
            } else {
                //Else if size is 0, then element is not present
                System.out.println("====================== " + categoryName + " Category didn't has items =====================");
            }
            Thread.sleep(5000);

            // just to view the items names
            for (WebElement webElement : dynamicElement) {
                String itemName = webElement.getText();
                System.out.println(itemName + "\n" + "\n");
            }
            Thread.sleep(3000);
        }
        driver.navigate().to("https://www.demoblaze.com/index.html");
        Thread.sleep(5000);
    }


    @Test(priority = 5)
    public void addItems() throws InterruptedException {
        // add 2 items from each category:
        // click on item
        // click Add to cart button
        // click ok on popup
        // back to home

        // get all page items

        List<WebElement> dynamicElement = driver.findElements(By.xpath("//*[@class='hrefch']"));

        int maxLength = dynamicElement.size();
        // just to check the length
        // System.out.println(maxLength);

        // get random item
        Random randomItem = new Random();
        // int randomProduct;

        for (int i = 0; i < 3; i++) {
            // get & click on a random item
            dynamicElement.get(randomItem.nextInt(maxLength)).click();
            Thread.sleep(5000);

            // Add the item to the cart
            WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
            addToCartButton.click();

            Thread.sleep(3000);

            // accept alert dialog
            driver.switchTo().alert().accept();

            Thread.sleep(3000);
            driver.navigate().back();
            driver.navigate().back();
            Thread.sleep(3000);
        }
    }


    @Test(priority = 6)
    public void removeItem() throws InterruptedException {

        // go to cart
        // remove any Item

        WebElement cartButton = driver.findElement(By.id("cartur"));
        cartButton.click();

        Thread.sleep(2000);

        // Locate the delete button by its onclick attribute
        WebElement deleteButton = driver.findElement(By.cssSelector("a[onclick*='deleteItem']"));

        // Click the delete button
        deleteButton.click();

        Thread.sleep(5000);

    }

    @Test(priority = 7)
    public void checkout() throws InterruptedException {

        // go to Cart page - if you are not on it
        // click Place Order
        // Fill Name... etc
        // click Purchase
        // wait 2 sec
        // click ok on popup

        WebElement placeOrderBtn = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        placeOrderBtn.click();

        Thread.sleep(3000);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Abdullah Hussein");

        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys("Jordan");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Amman");

        WebElement creditCard = driver.findElement(By.id("card"));
        creditCard.sendKeys("4774099273945966");

        WebElement month = driver.findElement(By.id("month"));
        month.sendKeys("November");

        WebElement year = driver.findElement(By.id("year"));
        year.sendKeys("2024");

        Thread.sleep(5000);

        WebElement purchaseButton = driver.findElement(By.xpath("//button[@class='btn btn-primary'  and text()='Purchase']"));
        purchaseButton.click();

        Thread.sleep(5000);

        WebElement okAlert = driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary'  and text()='OK']"));
        okAlert.click();
    }
}
