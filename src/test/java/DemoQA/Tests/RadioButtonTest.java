package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import DemoQA.Pages.RadioButtonPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.DefaultMenuLayout;
import java.time.Duration;

public class RadioButtonTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetup (){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        elementsPage = new ElementsPage();
        radioButtonPage = new RadioButtonPage();
        homepage = new Homepage();
        Actions action = new Actions(driver);
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        elementsPage.clcikOnradioButton();
    }
    @Test
    public void verifyThatUserIsOnRadioButtonPage(){
        String expectedURL = excelReader.getStringData("URL",5,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Radio Button");
    }


    @Test
    public void verifyThatUserCanClickOnYesRadioButton () throws InterruptedException {
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertEquals(radioButtonPage.notification.getText(),"Yes"); //asertujem poruku koja se dobija prilikom akcije sa ocekivanom porukom
    }
    @Test
    public void verifyThatUserCanClickOnImpressiveRadioButton () {
        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertEquals(radioButtonPage.notification.getText(), "Impressive");
    }
    @Test
    public void verifyThatUserCannotClicOnNoRadioButton () throws InterruptedException {
        radioButtonPage.clickOnNoradioButton();
        String actualMousePointer = radioButtonPage.noRadioButton.getCssValue("cursor");
        Assert.assertEquals(actualMousePointer, "not-allowed");

    }




}
