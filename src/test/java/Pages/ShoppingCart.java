package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoppingCart {
    protected WebDriver driver;
    private static final String CheckoutButton = "//*[@id='checkout']";

    @FindBy (className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy (className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    public ShoppingCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PersonalInfo openCheckoutPage(){
        WebElement checkoutLink = driver.findElement(By.xpath(CheckoutButton));
        checkoutLink.click();
        return new PersonalInfo(driver);
    }

    public int ItemsCountInTheCart(){
        if (driver.findElements(By.className("shopping_cart_badge")).isEmpty()) {
            return 0;
        }

        return Integer.parseInt(shoppingCartBadge.getText());
    }
}
