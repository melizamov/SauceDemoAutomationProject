package automation.tests;

import Pages.LoginPage;
import Pages.Products;
import Utils.CsvHelper;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SuccessfulLoginTest extends TestUtil {

    @DataProvider(name = "validUsers")
    public static Object[][] readUsersFromCsvFiles() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/ValidUsers.csv");
    }

    @Test (dataProvider = "validUsers")
    public void SuccessfulLogin(String username, String password) {
        LoginPage login = new LoginPage(driver);
        Products products = login.login(username, password);

        Assert.assertTrue(products.HamburgerMenu());
    }

}
