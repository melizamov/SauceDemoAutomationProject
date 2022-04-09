package automation.tests;

import Utils.CsvHelper;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UnsuccessfulLoginTest extends TestUtil {

    @DataProvider(name = "wrongUsersList")
    public Object [][] getWrongUsers(){
        return new Object [][]{
                {"standard2", "secret_sauce"},
                {"standard_user", "wrong password"},
                {"blah", "blah"},

        };
    }

    @DataProvider(name = "UserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/main/test/resources/users.csv");
    }



    @Test (dataProvider = "wrongUsersList")
    public void unsuccessfulLoginTest(String userName, String password) {


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
    
    @Test(dataProvider = "UserList")
    public void successfulLoginTest(String userName, String passWord){
      //  driver.get("https://www.saucedemo.com/");


        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName);


        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.sendKeys(passWord);

        WebElement loginButton = driver.findElement(By.xpath("//*[@class='submit-button btn_action']"));
        loginButton.click();

        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));


        Assert.assertTrue(burgerMenuButton.isDisplayed());


    }
}