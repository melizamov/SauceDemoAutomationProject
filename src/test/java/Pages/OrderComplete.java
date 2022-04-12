package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderComplete {
    protected WebDriver driver;

    public OrderComplete(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean OrderCompleteMessageDisplayed() {
        WebElement orderCompleteMessage = driver.findElement(By.xpath("//*[text()='THANK YOU FOR YOUR ORDER']"));
        return orderCompleteMessage.isDisplayed();
    }
}
