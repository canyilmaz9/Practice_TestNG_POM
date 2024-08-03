package TestNG_Framework;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Locale;

public class SoftAssertion {

    @Test
    public void aramaTesti(){
        //Test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url isminde "testotomasyonu" icerip icermedigini test edin

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //SoftAssert:
        // First step: Create an softAssert objext

        SoftAssert softAssert = new SoftAssert();

        // Second step: all assertions are done with softAssert object

        softAssert.assertTrue(actualUrl.contains(expectedUrlContent), "it does not contain url testotomasyonu");

        // Search predetermined word
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu
                        .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // test product number are greater than 3

        int expectedMinProductNumber = 3;
        int actualFoundProductNumber = testOtomasyonuPage.bulunanUrunElementleriList
                                                            .size();

        softAssert.assertTrue(actualFoundProductNumber > expectedMinProductNumber, "The number of products found is not more than the minimum expected number");

        // click on first product
        testOtomasyonuPage.bulunanUrunElementleriList
                                                     .get(0)
                                                     .click();
        //without case sensitive in the product name on the opened page
        //test if the search word is found

        String actualProductName = testOtomasyonuPage.ilkUrunSayfasiIsimElementi
                                                      .getText()
                                                      .toLowerCase();

        String expectedNameContent = ConfigReader.getProperty("toAranacakKelime");

        softAssert.assertTrue(actualProductName.contains(expectedNameContent), "There is not searching word in product");

        // Third step: Let's tell it to REPORT the assertions it makes to the softAssert object.
        softAssert.assertAll();

        Driver.quitDriver();
    }
}
