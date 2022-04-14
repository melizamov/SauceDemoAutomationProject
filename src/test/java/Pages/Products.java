package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {

    protected WebDriver driver;
    private static final String addToCartButton = "//button[@id='add-to-cart-sauce-labs-%s']";

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartCounter;

    public Products(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addAnItemToCart(String productName) {
        String xpathOfElementToBeAdded = String.format(addToCartButton, productName);
        WebElement addToCartButton = driver.findElement(By.xpath(xpathOfElementToBeAdded));
        addToCartButton.click();
    }


    public int checkItemsInTheCart() {
        if (driver.findElements(By.className("shopping_cart_badge")).isEmpty()) {
            return 0;
        }

        return Integer.parseInt(shoppingCartCounter.getText());
    }

    public boolean HamburgerMenu() {
        WebElement HamburgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        return HamburgerMenuButton.isDisplayed();
    }

    public ShoppingCart openShoppingCartPage() {
        shoppingCartLink.click();

        return new ShoppingCart(driver);
    }
}

