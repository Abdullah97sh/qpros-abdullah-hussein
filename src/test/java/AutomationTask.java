
import Pages.*;
import base.BaseTest;
import org.testng.annotations.Test;

public class AutomationTask extends BaseTest {
    // make the driver and randomUsername instantiated on class level - so all test cases can access it
    @Test(priority = 1)
    public void register() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver); // define object

        // chaining method - call the object one time (registerPage)
        registerPage.clickSignupHeader()
                .fillUsernameTextBox(randomUsername)
                .fillPasswordTextBox("12345678")
                .clickSignupButton();
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickUsernameHeader()
                .fillUsernameTextBox(randomUsername)
                .fillPasswordTextBox("12345678")
                .clickLoginButton();
        Thread.sleep(1500);
    }

    @Test(priority = 3)
    public void checkCategories() throws InterruptedException {

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.checkCategoriesItems();
        categoriesPage.toHome();
    }


    @Test(priority = 4)
    public void addItems() throws InterruptedException {
        // add 2 items from each category:
        // click on item
        // click Add to cart button
        // click ok on popup
        // back to home

        // get all page items

//        driver.navigate().to("https://www.demoblaze.com/index.html"); // delete it
        AddItemsPage addItemsPage = new AddItemsPage(driver);
        addItemsPage.addItems();

    }


    @Test(priority = 5)
    public void removeItem() {

        // go to cart
        // remove Item
        DeleteItemPage deleteItemPage = new DeleteItemPage(driver);
        deleteItemPage.clickCartHeader()
                .clickDeleteButton();
    }

    @Test(priority = 6)
    public void checkout() {

        // go to Cart page - if you are not on it
        // click Place Order
        // Fill Name... etc
        // click Purchase
        // wait 2 sec
        // click ok on popup

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickPlaceOrderBtn()
                .fillNameTextBox("Abdullah Hussein")
                .fillCountryTextBox("Jordan")
                .fillCityTextBox("Amman")
                .fillCardTextBox("4774099273945966")
                .fillMonthTextBox("November")
                .fillYearTextBox("2024")
                .clickPurchaseButton()
                .clickOkAlert();
    }
}
