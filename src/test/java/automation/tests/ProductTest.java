package automation.tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProductTest extends TestUtil {

    @Test
    public void selectDifferentOrder() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@class='submit-button btn_action']"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 12);

        WebElement dropDownOptionMenu = driver.findElement(By.xpath("//select[@class=('product_sort_container')]"));
        dropDownOptionMenu.wait();
        dropDownOptionMenu.click();

        WebElement lowToHighOrderOption = driver.findElement(By.cssSelector("[value=lohi]"));
        lowToHighOrderOption.click();


    }
}

