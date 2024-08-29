package TestNG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class HauseHeavenContact {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void ContactTesti(){

        driver.get("https://qa.hauseheaven.com/contact");

        String expectedYazi = "Get In Touch";
        WebElement actualcontactYazi = driver.findElement(By.xpath("(//h2)[2]"));

        ReusableMethods.bekle(3);
        Assert.assertEquals(actualcontactYazi.getText(), expectedYazi );
    }

}
