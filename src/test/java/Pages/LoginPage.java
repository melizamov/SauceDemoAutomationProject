package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passWordInput;

    @FindBy(xpath = "//*[@class='submit-button btn_action']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Products login(String userName, String passWord){
        userNameInput.click();
        userNameInput.sendKeys(userName);

        passWordInput.click();
        passWordInput.sendKeys(passWord);

        loginButton.click();

        return new Products(driver);
    }

    public void LoginAttempt(String username, String password){
        userNameInput.click();
        userNameInput.sendKeys(username);

        passWordInput.click();
        passWordInput.sendKeys(password);

        loginButton.click();
    }

    public boolean warningMessage(String warning) {
        WebElement errorLogin = driver.findElement(By.xpath("//*[text()='Epic sadface: "+warning+"']"));
        return errorLogin.isDisplayed();
    }
}
