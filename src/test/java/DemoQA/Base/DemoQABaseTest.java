package DemoQA.Base;

import DemoQA.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class DemoQABaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String HomeURL;
    public Homepage homepage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenPage brokenPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public PracticeFormPage practiceFormPage;

    @BeforeClass
    public void setUp () throws IOException {
        WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver();
       // wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/DemoQA/TestData.xlsx");
        HomeURL = excelReader.getStringData("URL",1,0);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void waitElementToBeVisible (WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementtoBeClickable (WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitPageVisible (String url){
        wdwait.until(ExpectedConditions.urlToBe("url"));
    }


    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }
    @AfterClass
    public void closure (){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
