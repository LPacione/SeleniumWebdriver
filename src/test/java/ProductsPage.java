import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageObject{

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement products_label;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart_SauceBackpack;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cart_badge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement collapsible_menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout_button;

    @FindBy(id = "shopping_cart_container")
    private WebElement shopping_cart;

    @FindBy(id = "item_4_title_link")
    private WebElement item_name;

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return this.products_label.getText();
    }

    public void addToCartBackpack(){
        this.addToCart_SauceBackpack.click();
    }

    public String getItemName(){
        return this.item_name.getText();
    }

    public String getCartBadge(){
        return this.cart_badge.getText();
    }

    public void open_lateral_menu() {
        this.collapsible_menu.click();
    }

    public void showCart() {
        this.shopping_cart.click();
    }

    public void logout() {
        this.logout_button.click();
    }
}
