package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import DemoQA.Pages.PracticeFormPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeFormTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp () throws InterruptedException {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        homepage = new Homepage();
        scrollIntoView(homepage.cards.get(0));
        Thread.sleep(2000);
        homepage.clickOnForms();
        practiceFormPage = new PracticeFormPage();

    }

}
