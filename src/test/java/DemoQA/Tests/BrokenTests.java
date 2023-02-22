package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.BrokenPage;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import DemoQA.Pages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrokenTests extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp (){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        homepage = new Homepage();
        elementsPage = new ElementsPage();
        brokenPage = new BrokenPage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        scrollIntoView(elementsPage.brokenLinksImages);
        elementsPage.clickOnBrokenLinksImages();
    }
    @Test
    public void verifyThatUserIsOnBrokenPage(){
        String expectedURL = excelReader.getStringData("URL",9,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Broken Links - Images");
    }
    @Test
    public void verifyThatToolsQAImageIsVisible (){
        Assert.assertTrue(brokenPage.toolsQAImage.isDisplayed());
    }

    @Test
    public void verifyThatBrokenImageIconIsVisible (){
        Assert.assertTrue(brokenPage.brokenImageIcon.isDisplayed());
    }
    @Test
    public void clickOnValidLinkResult () throws InterruptedException {
        brokenPage.clickOnValidLink();
        Assert.assertEquals(driver.getCurrentUrl(),HomeURL);
    }
    @Test
    public void clickOnBrokenLinkResult (){
        scrollIntoView(brokenPage.brokenLink);
        brokenPage.clickOnBrokenLink();
        Assert.assertEquals(driver.getCurrentUrl(),"http://the-internet.herokuapp.com/status_codes/500"); //posle klika na broken link otvara se stranica sa code-om 500
    }

}
