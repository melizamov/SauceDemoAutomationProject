package automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SuccessfullLoginTest{
    private WebDriver driver;

    @BeforeTest
    public void initiallizeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }



    @Test
    public void successfullLoginTest(){
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");


        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@class='submit-button btn_action']"));
        loginButton.click();

        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));



        Assert.assertTrue(burgerMenuButton.isDisplayed());
    }




}
