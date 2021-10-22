import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Login successfully")
    public static void loginSuccessfully(){
        login();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getTitle(),"PRODUCTS");
    }

    @Test(testName = "Add one item to cart")
    public static void verifyItemAdded(){
        login();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCartBackpack();
        Assert.assertEquals(productsPage.getCartBadge(),"1");
    }

    @Test(testName = "Logout successfully")
    public static void logoutSuccessfully() {
        login();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open_lateral_menu();
        productsPage.logout();
    }

    @Test(testName = "Verify shopping cart")
    public static void verifyShoppingCart() {
        String itemName;

        login();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCartBackpack();
        itemName = productsPage.getItemName();
        productsPage.showCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertEquals(shoppingCartPage.getItemName(),itemName);
    }

    private static void login(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword();
        loginForm.pressLoginButton();
    }

    @AfterSuite
    public static void cleanup(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
