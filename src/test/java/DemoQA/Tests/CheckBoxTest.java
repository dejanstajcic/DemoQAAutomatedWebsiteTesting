package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp (){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        elementsPage = new ElementsPage();
        checkBoxPage = new CheckBoxPage();
        homepage = new Homepage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        elementsPage.clickOnCheckBox();
    }
    @Test
    public void verifyThatUserIsOnCheckBoxPage(){
        String expectedURL = excelReader.getStringData("URL",4,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Check Box");
    }
    /*@Test
    public void expandArrowFunctionality () throws InterruptedException {//proveravam funkcionalnost expand strelice
        checkBoxPage.clickOnExpandArrow();
        Assert.assertTrue(checkBoxPage.desktopFileIcon.isDisplayed());

       // checkBoxPage.clickOnCheckBox();
    }*/
    @Test
    public void CheckBoxSelectionFunctionality () throws InterruptedException {
        checkBoxPage.clickOnEcOnxpandArrows();
        checkBoxPage.clickOnCheckBox();
        Assert.assertTrue(checkBoxPage.selectionResults.isDisplayed());

    }
    @Test
    public void PlusButtonFunctionality (){
        checkBoxPage.clickOnPlusIcon();
    }
    @Test
    public void minusButtonFunctionality (){
        checkBoxPage.clickOnPlusIcon();
        checkBoxPage.clickOnMinusIcon();
    }
    @Test
    public void ea () throws InterruptedException {
        for (int i=0 ; i<4; i++){
            checkBoxPage.clickOnEcOnxpandArrows();
        }
        for (int i=0 ; i<4; i++){
            checkBoxPage.clickOnCloseDoc();
        }

        //Assert.assertFalse(checkBoxPage.iconsNotOpened.get(4).isDisplayed());

    }


   /* @AfterMethod
    public void closebrowser(){
       // driver.quit();
    }
*/

}
