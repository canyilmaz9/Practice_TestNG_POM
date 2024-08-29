package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HauseHeavenPage {

     /*
        Page class'i bir URL'e gidildiginde
        kullanilabilecek tum webelementleri locate edip
        kaydedecegimiz class'dir

        Page class'lari TestNG tarafindan ozel tasarlanmistir
        ve locate yaparken @FindBy kullanilir
     */

    public HauseHeavenPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@placeholder='Search for a location']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//a[@class='more-btn']")
    public List<WebElement> bulunanElementlerList;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement ilkUrunSayfasiIsimElementi;

}
