package TestNG_Framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HauseHeavenPage;
import utilities.Driver;

import javax.swing.*;

import static utilities.Driver.driver;

public class HauseHeavenPageClass {



    @Test
    public void test01(){


        Driver.getDriver().get("https://qa.hauseheaven.com/");
        Actions actions = new Actions(driver);

        HauseHeavenPage hauseHeavenPage = new HauseHeavenPage();

        hauseHeavenPage.aramaKutusu.sendKeys("New York" + Keys.ENTER);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        hauseHeavenPage.bulunanElementlerList
                .get(0)
                .click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String expectedIsim = "Manisada Yazlik";
        String actulIsim = hauseHeavenPage.ilkUrunSayfasiIsimElementi
                                            .getText();

        Assert.assertTrue(actulIsim.contains(expectedIsim));



    }
}
