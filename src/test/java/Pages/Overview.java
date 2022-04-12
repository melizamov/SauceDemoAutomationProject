package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Overview {

    protected WebDriver driver;
    private static final String FinishButton = "//*[@id='finish']";

    public Overview(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderComplete openOrderCompletePage(){
        WebElement continueShoppingLink = driver.findElement(By.xpath(FinishButton));
        continueShoppingLink.click();

        return new OrderComplete(driver);
    }
}
