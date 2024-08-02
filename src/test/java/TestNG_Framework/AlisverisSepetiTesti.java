package TestNG_Framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class AlisverisSepetiTesti {

    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void alisverisSepetiTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime2") + Keys.ENTER);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3- Listelenen sonuclardan ikincisini tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList
                .get(1)
                .click();

        //4- urun ismini kaydedin

        String ikinciUrunIsmi = testOtomasyonuPage.ikinciUrunSayfasiIsimElementi.getText();
        ReusableMethods.bekle(1);
        ReusableMethods.getWebelementScreenshot(testOtomasyonuPage.ikinciUrunSayfasiIsimElementi,"SecilenUrunIsmi");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        // ve urunu sepete ekleyin
        testOtomasyonuPage.urunSayfasiAddToCartButonu
                .click();

        //5- your cart linkine tiklayin
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(3);
        testOtomasyonuPage.yourCartLinki
                .click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testOtomasyonuPage.sepettekiUrunIsimElementi
                .getText();
        ReusableMethods.bekle(2);
        ReusableMethods.getWebelementScreenshot(testOtomasyonuPage.sepettekiUrunIsimElementi,"SepettekiUrunIsmi");

        Assert.assertEquals(sepettekiUrunIsmi,ikinciUrunIsmi);
        // urun ismi ile sepetteki urun ismi ayni degil
        // bug bulundu

        //7- sayfayi kapatin
        Driver.quitDriver();

    }
}
