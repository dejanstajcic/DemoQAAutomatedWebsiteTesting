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

public class WebTablesTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetup (){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        homepage = new Homepage();
        elementsPage = new ElementsPage();
        webTablesPage = new WebTablesPage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        elementsPage.clickOnWebTables();

    }
    @Test (priority = 10)
    public void verifyThatUserIsOnWebTablesPage(){
        String expectedURL = excelReader.getStringData("URL",6,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Web Tables");
    }

    @Test (priority = 20)
    public void verifyThatUserCanAddNewPerson () {
        webTablesPage.clickOnAddNewButton();
        webTablesPage.insertFirstName();
        webTablesPage.insertLastName();
        webTablesPage.insertEmail();
        webTablesPage.insertAge();
        webTablesPage.insertSalary();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        System.out.println(webTablesPage.getText());//provera ispisa
        Assert.assertEquals(webTablesPage.getText(),"Dejan\n" +
                "Stajcic\n" +
                "36\n" +
                "dest@gmail.com\n" +
                "50000\n" +
                "QA");  //kopiran text koji je ispisan u konzoli za dodatog korisnika u 4.tom redu

    }
    @Test (priority = 30)
    public void verifyThatUserCanDeleteAllPersons (){
        add();
        for (int i=0; i <4; i++){
            webTablesPage.deleteRows();
        }
        waitElementToBeVisible(webTablesPage.noRowsFound);
        Assert.assertTrue(webTablesPage.noRowsFound.isDisplayed());
    }
    @Test(priority = 40)
    public void verifyThatUserCanEditPersonInTable (){
        webTablesPage.editFirstPerson.click();
        webTablesPage.insertFirstName();
        webTablesPage.insertLastName();
        webTablesPage.insertEmail();
        webTablesPage.insertAge();
        webTablesPage.insertSalary();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        System.out.println(webTablesPage.getTextFromFirstRow());//provera ispisa
        Assert.assertEquals(webTablesPage.getTextFromFirstRow(),"Dejan\n" +
                "Stajcic\n" +
                "36\n" +
                "dest@gmail.com\n" +
                "50000\n" +
                "QA");  //kopiran text koji je ispisan u konzoli za dodatog korisnika u 4.tom redu
    }


    public void add ()  {
        webTablesPage.clickOnAddNewButton();
        webTablesPage.insertFirstName();
        webTablesPage.insertLastName();
        webTablesPage.insertEmail();
        webTablesPage.insertAge();
        webTablesPage.insertSalary();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        System.out.println(webTablesPage.getText());//provera ispisa
        Assert.assertEquals(webTablesPage.getText(),"Dejan\n" +
                "Stajcic\n" +
                "36\n" +
                "dest@gmail.com\n" +
                "50000\n" +
                "QA");  //kopiran text koji je ispisan u konzoli za dodatog korisnika u 4.tom redu
    }

    @Test (priority = 50)
    public void verifyThatUserCanGoToNextPage (){
        for (int i=0; i < 10; i++){//dodajem 10 novih osoba u tabelu da noih mogao da predjem na drugu stranu
            add();
        }
        scrollIntoView(webTablesPage.previousAndNextButtons.get(1));//skrol da bude vidljivo next dugme
        webTablesPage.clickOnNextButton();
        Assert.assertTrue(webTablesPage.secondPage.isDisplayed());//asertujem da je broj trenutne stranice dva
    }
    @Test (priority = 60)
    public void verifyThatUserCanGoToPreviousPage (){
        goToNextPage();
        webTablesPage.clickOnPreviousButton();
        Assert.assertTrue(webTablesPage.firstPage.isDisplayed());

    }
    @Test (priority = 70)
    public void verifyThatUserCannotAddNewPersonWithInvalidFirstName (){
        for (int i=1; i<excelReader.getLastRow("webtables")+1; i++){
            webTablesPage.clickOnAddNewButton();
            webTablesPage.firstNameField.clear();
            webTablesPage.firstNameField.sendKeys(excelReader.getStringData("webtables",i,0));
            webTablesPage.insertLastName();
            webTablesPage.insertEmail();
            webTablesPage.insertAge();
            webTablesPage.insertSalary();
            webTablesPage.insertDepartment();
            webTablesPage.clickOnSubmitButton();
        }
    }
    @Test (priority = 90)
    public void verifyThatUserCannotAddNewPersonWithInvalidLastName (){
        for (int i=1; i<excelReader.getLastRow("webtables")+1; i++){
            webTablesPage.clickOnAddNewButton();
            webTablesPage.insertFirstName();
            webTablesPage.lastNameField.clear();
            webTablesPage.lastNameField.sendKeys(excelReader.getStringData("webtables",i,1));
            webTablesPage.insertEmail();
            webTablesPage.insertAge();
            webTablesPage.insertSalary();
            webTablesPage.insertDepartment();
            webTablesPage.clickOnSubmitButton();
        }
    }
    @Test(priority = 100)
    public void verifyThatUserCannotAddNewPersonWithInvalidEmailFormat (){
        webTablesPage.clickOnAddNewButton();
        for (int i=1; i<excelReader.getLastRow("webtablesemail")+1; i++){
            webTablesPage.insertFirstName();
            webTablesPage.insertLastName();
            webTablesPage.emailField.clear();
            webTablesPage.emailField.sendKeys(excelReader.getStringData("webtablesemail",i,0));
            webTablesPage.insertAge();
            webTablesPage.insertSalary();
            webTablesPage.insertDepartment();
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(webTablesPage.form.isEnabled());
        }
    }
    @Test(priority = 110)
    public void verifyThatUserCannotAddNewPersonWithInvalidAge (){
        webTablesPage.clickOnAddNewButton();
        for (int i=1; i<excelReader.getLastRow("webtables")+1; i++){
            webTablesPage.insertFirstName();
            webTablesPage.insertLastName();
            webTablesPage.insertEmail();
            webTablesPage.ageField.clear();
            webTablesPage.ageField.sendKeys(excelReader.getStringData("webtables",i,2));
            webTablesPage.insertSalary();
            webTablesPage.insertDepartment();
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(webTablesPage.form.isEnabled());
        }
    }
    @Test(priority = 120)
    public void verifyThatUserCannotAddNewPersonWithInvalidSalary (){
        webTablesPage.clickOnAddNewButton();
        for (int i=1; i<excelReader.getLastRow("webtables")+1; i++){
            webTablesPage.insertFirstName();
            webTablesPage.insertLastName();
            webTablesPage.insertEmail();
            webTablesPage.insertAge();
            webTablesPage.salaryField.clear();
            webTablesPage.salaryField.sendKeys(excelReader.getStringData("webtables",i,4));
            webTablesPage.insertDepartment();
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(webTablesPage.form.isEnabled());
        }
    }
    @Test (priority = 130)
    public void verifyThatUserCannotAddNewPersonWithInvalidDepartment (){
        for (int i=1; i<excelReader.getLastRow("webtables")+1; i++){
            webTablesPage.clickOnAddNewButton();
            webTablesPage.insertFirstName();
            webTablesPage.insertLastName();
            webTablesPage.insertEmail();
            webTablesPage.insertAge();
            webTablesPage.insertSalary();
            webTablesPage.departmentField.clear();
            webTablesPage.departmentField.sendKeys(excelReader.getStringData("webtables",i,5));
            webTablesPage.clickOnSubmitButton();
        }
    }
    @Test (priority = 140)
    public void verifyThatUserCannotAddNewPersonWithoutFirstName(){
        webTablesPage.clickOnAddNewButton();
        webTablesPage.firstNameField.clear();
        webTablesPage.insertLastName();
        webTablesPage.insertEmail();
        webTablesPage.insertAge();
        webTablesPage.insertSalary();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.form.isEnabled());
    }
    @Test(priority = 150)
    public void verifyThatUserCannotAddNewPersonWithoutLastName(){
        webTablesPage.clickOnAddNewButton();
        webTablesPage.insertFirstName();
        webTablesPage.lastNameField.clear();
        webTablesPage.insertEmail();
        webTablesPage.insertAge();
        webTablesPage.insertSalary();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.form.isEnabled());
    }

    @Test(priority = 160)
    public void verifyThatUserCannotAddNewPersonWithoutEmail(){
        webTablesPage.clickOnAddNewButton();
        webTablesPage.insertFirstName();
        webTablesPage.insertLastName();
        webTablesPage.emailField.clear();
        webTablesPage.insertAge();
        webTablesPage.insertSalary();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.form.isEnabled());
    }

    @Test(priority = 170)
    public void verifyThatUserCannotAddNewPersonWithoutAge(){
        webTablesPage.clickOnAddNewButton();
        webTablesPage.insertFirstName();
        webTablesPage.insertLastName();
        webTablesPage.insertEmail();
        webTablesPage.ageField.clear();
        webTablesPage.insertSalary();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.form.isEnabled());
    }
    @Test(priority = 180)
    public void verifyThatUserCannotAddNewPersonWithoutSalary(){
        webTablesPage.clickOnAddNewButton();
        webTablesPage.insertFirstName();
        webTablesPage.insertLastName();
        webTablesPage.insertEmail();
        webTablesPage.insertAge();
        webTablesPage.salaryField.clear();
        webTablesPage.insertDepartment();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.form.isEnabled());
    }
    @Test(priority = 190)
    public void verifyThatUserCannotAddNewPersonWithoutDepartment(){
        webTablesPage.clickOnAddNewButton();
        webTablesPage.insertFirstName();
        webTablesPage.insertLastName();
        webTablesPage.insertEmail();
        webTablesPage.insertAge();
        webTablesPage.insertSalary();
        webTablesPage.departmentField.clear();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.form.isEnabled());
    }
    @Test
    public void verifyThatUserCanSearchForDataInTable(){
        webTablesPage.searchForData("Alden");
        System.out.println(webTablesPage.rows.get(0).getText());
        Assert.assertEquals(webTablesPage.rows.get(0).getText(),"Alden\n" +
                "Cantrell\n" +
                "45\n" +
                "alden@example.com\n" +
                "12000\n" +
                "Compliance");
    }





    public void goToNextPage (){
        for (int i=0; i < 10; i++){
            add();
        }
        scrollIntoView(webTablesPage.previousAndNextButtons.get(1));
        webTablesPage.clickOnNextButton();
        Assert.assertTrue(webTablesPage.secondPage.isDisplayed());

    }



   /* @Test
    public void verifyThatSearchIsWorking (){
        webTablesPage.searchForData("Alden");
        Assert.assertTrue(webTablesPage.getText(),"Alden");


    }*/

    @AfterMethod
    public void closeChrome (){
        //driver.quit();
    }
}
