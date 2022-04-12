package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfo {
    protected WebDriver driver;
    private static final String ContinueButton = "//*[@id='continue']";

    @FindBy(xpath = "//*[@class='input_error form_input']")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postCodeInput;



    public PersonalInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInfo(String firstName, String lastName, String postCode){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.sendKeys(lastName);

        postCodeInput.click();
        postCodeInput.sendKeys(postCode);

    }

    public Overview openOverviewPage(){
        WebElement continueShoppingLink = driver.findElement(By.xpath(ContinueButton));
        continueShoppingLink.click();

        return new Overview(driver);
    }
}
