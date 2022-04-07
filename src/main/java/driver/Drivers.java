package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Drivers {

    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup(); //this download the needed web driver
        WebDriver driver = new ChromeDriver(); //creates the session and open the
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return driver;
    }

    public static WebDriver getFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        return null;
    }
}