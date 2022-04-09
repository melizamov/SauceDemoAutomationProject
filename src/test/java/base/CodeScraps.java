package base;

import Utils.CsvHelper;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CodeScraps {


    @DataProvider(name = "wrongUserList")
    public Object[][] readWrongUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/main/test/resources/WrongUsers.csv");
    }
}


