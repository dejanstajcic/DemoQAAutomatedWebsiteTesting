package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.ButtonsPage;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonsTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp (){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        homepage = new Homepage();
        elementsPage = new ElementsPage();
        buttonsPage = new ButtonsPage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        elementsPage.clickOnButtons();
    }
    @Test
    public void verifyThatUserIsOnButtonsPage(){
        String expectedURL = excelReader.getStringData("URL",7,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Buttons");
    }
    @Test
    public void verifyThatUserCanClickOnDoubleClickButton (){
        buttonsPage.doubleClickOnDoubleClickButton();
        Assert.assertTrue(buttonsPage.doubleClickMessage.isDisplayed());
    }
    @Test
    public void verifyThatUserDoneRightClickOnRightClickButton (){
        buttonsPage.rightClickOnRightclickButton();
        Assert.assertTrue(buttonsPage.rightClickMessage.isDisplayed());
    }
    @Test
    public void verifyThatUserCanClickOnClickMeButton ()  {
        buttonsPage.clickOnClickMeButton();
        Assert.assertTrue(buttonsPage.clickMeMessage.isDisplayed());
    }


}
