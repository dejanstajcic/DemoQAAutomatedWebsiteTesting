package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import DemoQA.Pages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class textBoxTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        homepage = new Homepage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        elementsPage.clickOnTextBox();
    }

    @Test(priority = 10)
    public void verifyThatUserIsOnTextBoxPage() {
        String expectedURL = excelReader.getStringData("URL", 3, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(), "Text Box");
    }


    @Test(priority = 20)
    public void verifyThatUserCanSubmitFormWithValidData() {
        textBoxPage.inputFullName();
        textBoxPage.inputEmail();
        textBoxPage.inputCurrentAddress();
        textBoxPage.inputPermanentAddress();
        scrollIntoView(textBoxPage.submit);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.outputForm.isDisplayed());
    }

    @Test(priority = 30)
    public void verifyThatUserCannotSubmitFormWithInvalidFullName() {
        for (int i = 1; i < excelReader.getLastRow("textBox") + 1; i++) {
            textBoxPage.fullNameField.clear();
            textBoxPage.fullNameField.sendKeys(excelReader.getStringData("textBox", i, 0));
            textBoxPage.inputEmail();
            textBoxPage.inputCurrentAddress();
            textBoxPage.inputPermanentAddress();
            scrollIntoView(textBoxPage.submit);
            textBoxPage.clickOnSubmitButton();
            Assert.assertTrue(textBoxPage.outputForm.isDisplayed());
        }
    }

    @Test(priority = 40)
    public void verifyThatUserCannotSubmitFormWithInvalidEmail() {
        for (int i = 1; i < excelReader.getLastRow("textBox1") + 1; i++) {
            textBoxPage.inputFullName();
            textBoxPage.emailField.clear();
            textBoxPage.emailField.sendKeys(excelReader.getStringData("textBox1", i, 0));
            textBoxPage.inputCurrentAddress();
            textBoxPage.inputPermanentAddress();
            scrollIntoView(textBoxPage.submit);
            textBoxPage.clickOnSubmitButton();
            Assert.assertTrue(textBoxPage.errorEmailMessage.isDisplayed());
        }

    }

    @Test(priority = 50)
    public void verifyThatUserCannotSubmitFormWithInvalidCurrentAddress() {
        for (int i = 1; i < excelReader.getLastRow("textBox") + 1; i++) {
            textBoxPage.inputFullName();
            textBoxPage.inputEmail();
            textBoxPage.currentAddress.clear();
            textBoxPage.currentAddress.sendKeys(excelReader.getStringData("textBox", i, 2));
            textBoxPage.inputPermanentAddress();
            scrollIntoView(textBoxPage.submit);
            textBoxPage.clickOnSubmitButton();
            Assert.assertTrue(textBoxPage.outputForm.isDisplayed());
        }

    }

    @Test(priority = 60)
    public void verifyThatUserCannotSubmitFormWithInvalidPermanentAddress() {
        for (int i = 1; i < excelReader.getLastRow("textBox") + 1; i++) {
            textBoxPage.inputFullName();
            textBoxPage.inputEmail();
            textBoxPage.inputCurrentAddress();
            textBoxPage.permanentAddress.clear();
            textBoxPage.permanentAddress.sendKeys(excelReader.getStringData("textBox", i, 3));
            scrollIntoView(textBoxPage.submit);
            textBoxPage.clickOnSubmitButton();
            Assert.assertTrue(textBoxPage.outputForm.isDisplayed());
        }

    }
}
/*
    @AfterMethod
    public void c(){
        driver.quit();
    }
}
*/
