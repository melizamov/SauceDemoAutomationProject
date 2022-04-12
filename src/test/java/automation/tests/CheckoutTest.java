package automation.tests;

import Pages.*;
import Utils.CsvHelper;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends TestUtil {

    @DataProvider(name = "checkoutDetails")
    public static Object[][] readCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/CheckoutDetails.csv");
    }

    @Test(dataProvider = "checkoutDetails")
    public void completeCheckout(String userName, String passWord, String firstItem, String secondItem,
                                 String thirdItem, String firstName, String lastName, String postCode){
        LoginPage login = new LoginPage(driver);
        Products products = login.login(userName, passWord);


        products.addAnItemToCart(firstItem);

        products.addAnItemToCart(secondItem);

        products.addAnItemToCart(thirdItem);

        ShoppingCart cartPage = products.openShoppingCartPage();

        Assert.assertEquals(cartPage.ItemsCountInTheCart(),3);

        PersonalInfo checkoutInfoPage = cartPage.openCheckoutPage();
        checkoutInfoPage.fillInfo(firstName, lastName, postCode);
        Overview checkoutOverviewPage = checkoutInfoPage.openOverviewPage();

        OrderComplete orderCompletePage = checkoutOverviewPage.openOrderCompletePage();
        Assert.assertTrue(orderCompletePage.OrderCompleteMessageDisplayed());
    }


}
