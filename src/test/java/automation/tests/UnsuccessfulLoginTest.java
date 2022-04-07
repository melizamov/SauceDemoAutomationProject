package automation.tests;

import Utils.CsvHelper;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UnsuccessfulLoginTest {
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

    @DataProvider(name = "wrongUsersList")
    public Object [][] getWrongUsers(){
        return new Object [][]{
                {"standard2", "secret_sauce"},
                {"standard_user", "wrong password"},
                {"blah", "blah"},

        };
    }



    @Test (dataProvider = "wrongUsersList")
    public void unsuccessfulLoginTest(String userName, String password) {
        driver.get("https://www.saucedemo.com/");


        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("userName");


        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.sendKeys("password");

        WebElement loginButton = driver.findElement(By.xpath("//*[@class='submit-button btn_action']"));
        loginButton.click();

        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));
        Assert.assertTrue(errorLoginLabel.isDisplayed());

    }


}



