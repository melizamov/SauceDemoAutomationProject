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

public class AddToCartTest extends TestUtil {

    @DataProvider(name = "ItemList")
    public static Object[][] readCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/AddToCart.csv");
    }

    @Test(dataProvider = "ItemList")
    public void addToCart(String userName, String passWord, String firstItem, String secondItem, String thirdItem){
        LoginPage login = new LoginPage(driver);
        Products products = login.login(userName, passWord);

        if (firstItem.length() != 0) {
            products.addAnItemToCart(firstItem);
            Assert.assertEquals(products.checkItemsInTheCart(), 1);
        }
        if (secondItem.length() != 0) {
            products.addAnItemToCart(secondItem);
            Assert.assertEquals(products.checkItemsInTheCart(), 2);
        }
        if (thirdItem.length() != 0) {
            products.addAnItemToCart(thirdItem);
            Assert.assertEquals(products.checkItemsInTheCart(), 3);
        }

        Assert.assertEquals(products.checkItemsInTheCart(),3);
    }
}
