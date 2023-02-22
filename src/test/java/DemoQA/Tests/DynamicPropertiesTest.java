package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.DynamicPropertiesPage;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import DemoQA.Pages.UploadAndDownloadPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicPropertiesTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        homepage = new Homepage();
        elementsPage = new ElementsPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        scrollIntoView(elementsPage.dynamicProperties);
        elementsPage.clickOndynamicProperties();
    }
    @Test
    public void verifyThatUserIsOnDynamicPropertiesPage(){
        String expectedURL = excelReader.getStringData("URL",11,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Dynamic Properties");
    }

    @Test
    public void checkVisibilityOfVisibleAfter5SecondsButton () throws InterruptedException {
        Assert.assertFalse(isDisplayed(dynamicPropertiesPage.visibleAfter5SecButton));
        Thread.sleep(5000);
        Assert.assertTrue(isDisplayed(dynamicPropertiesPage.visibleAfter5SecButton));

    }
    @Test
    public void verifyThatEnableAfter5SecondsButtonIsEnabledAfter5Seconds () throws InterruptedException {
        Assert.assertFalse(dynamicPropertiesPage.after5SecButton.isEnabled()); //asertovao sam da dugme na pocetku nije aktivno
        Thread.sleep(5000);//stavio sam Thread Sleep na 5 sekundi da bi proverio da li je dugme aktivno
        Assert.assertTrue(dynamicPropertiesPage.after5SecButton.isEnabled()); //asertovao sam da je posle 5 sekundi dugme aktivno
    }
    @Test
    public void verifyThatColorOfLettersChangeInColorChangeButton () throws InterruptedException {
        Assert.assertFalse(isDisplayed(dynamicPropertiesPage.colorChangeRed));
        Thread.sleep(5000);
        Assert.assertTrue(isDisplayed(dynamicPropertiesPage.colorChangeRed));

    }



}
