import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageObject{

    @FindBy(id = "item_4_title_link")
    private WebElement item_name;

    public ShoppingCartPage(WebDriver driver) { super(driver); }

    public String getItemName() { return this.item_name.getText(); }
}