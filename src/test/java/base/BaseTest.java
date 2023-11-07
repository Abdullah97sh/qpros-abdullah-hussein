package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public String randomUsername = "abdullah1-" + ((int) (Math.random() * 20)) + "@qpros.com";


    // anything will add under @BeforeTest will run onr time before all test cases
    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();  // it will setup automatically
        driver.navigate().to("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    // anything will add under @AfterTest will run onr time after all test cases
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
