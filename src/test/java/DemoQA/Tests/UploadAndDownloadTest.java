package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import DemoQA.Pages.UploadAndDownloadPage;
import DemoQA.Pages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadAndDownloadTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp (){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        homepage = new Homepage();
        elementsPage = new ElementsPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        elementsPage.clickOnUploadAndDownload();
    }
    @Test
    public void verifyThatUserIsOnUploadAndDownloadPage(){
        String expectedURL = excelReader.getStringData("URL",10,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Upload and Download");
    }

    @Test
    public void verifyThatUserCanDownloadFile (){
        uploadAndDownloadPage.clickOnDownloadButton();
        Assert.assertTrue(uploadAndDownloadPage.isFileDownloaded("C:\\Users\\damnj\\Downloads","sampleFile.jpeg"));
    }
    @Test
    public void ChooseFileButtonFunctionality (){
        uploadAndDownloadPage.chooseFileButton.sendKeys("C:\\Users\\damnj\\OneDrive\\Pictures\\Carter_vs_Gasol,_Lakers_vs_Magic.jpg");
        Assert.assertTrue(isDisplayed(uploadAndDownloadPage.UploadMsg));
        Assert.assertEquals(uploadAndDownloadPage.UploadMsg.getText(), "C:\\fakepath\\Carter_vs_Gasol,_Lakers_vs_Magic.jpg");
    }



}
