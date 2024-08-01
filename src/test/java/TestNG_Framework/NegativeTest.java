package TestNG_Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.driver;

public class NegativeTest {

    //NegativeTest
    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeClass
    public void negativeTest() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }
    @BeforeMethod
    public void loginlink(){
        // 2- account linkine basin

        ReusableMethods.bekle(1);
        testOtomasyonuPage.accountLinki.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

        // 3-  3 farkli test method’u olusturun.- gecerli email, gecersiz password- gecersiz email, gecerli password- gecersiz email, gecersiz password.
        // 4- Login butonuna basarak login olmayi deneyin
        // 5- Basarili olarak giris yapilamadigini test edin
        @Test (priority = 1)
        public void gecerliEmailGecersizPassword(){

        testOtomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        testOtomasyonuPage.loginSignInButonu.click();
        }


        @Test (priority = 2)
        public void gecersizEmailGecerliPassword(){
            testOtomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
            testOtomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
            testOtomasyonuPage.loginSignInButonu.click();

            Assert.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());
        }

        @Test (priority = 3)
        public void gecersizEmailGecersizPassword(){
            testOtomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
            testOtomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
            testOtomasyonuPage.loginSignInButonu.click();

            Assert.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());
        }

        @Test (priority = 4)
        public void tearDown(){
            Driver.getDriver();
            }

}
