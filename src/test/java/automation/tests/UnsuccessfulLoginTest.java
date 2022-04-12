package automation.tests;

import Pages.LoginPage;
import Utils.CsvHelper;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UnsuccessfulLoginTest extends TestUtil {



    @DataProvider(name = "wrongUsers")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/WrongUsers.csv");
    }

    @Test(dataProvider = "wrongUsers")
    public void unsuccessfulLoginTest(String username, String password){
        LoginPage login = new LoginPage(driver);
        login.LoginAttempt(username, password);

        String warning = "Username and password do not match any user in this service";
        if (username.length() == 0) {
            warning = "Username is required";
        } else if (password.length() == 0) {
            warning = "Password is required";
        }

        Assert.assertTrue(login.warningMessage(warning));
    }
}