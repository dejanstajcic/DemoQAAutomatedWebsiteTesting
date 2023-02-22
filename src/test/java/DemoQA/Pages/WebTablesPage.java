package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesPage extends DemoQABaseTest {
    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewButton;
    @FindBy(id = "searchBox")
    public WebElement searchField;
    @FindBy(id = "firstName")
    public WebElement firstNameField;
    @FindBy(id = "lastName")
    public WebElement lastNameField;
    @FindBy(id = "userEmail")
    public WebElement emailField;
    @FindBy(id = "age")
    public WebElement ageField;
    @FindBy(id = "salary")
    public WebElement salaryField;
    @FindBy(id = "department")
    public WebElement departmentField;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(className = "rt-tr-group")
    public List<WebElement> rows;
    @FindBy(css = "span[title='Delete']")
    public WebElement deleteIcon;
    @FindBy (className = "rt-noData")
    public WebElement noRowsFound;
    @FindBy (className = "-pageInfo")
    public WebElement pageInfo;
    @FindBy (id = "edit-record-1")
    public WebElement editFirstPerson;
    @FindBy (className = "-btn")
    public List <WebElement> previousAndNextButtons;
    @FindBy (css ="input[value='2']" )
    public WebElement secondPage;//broj stranice
    @FindBy (css ="input[value='1']" )
    public WebElement firstPage;
    @FindBy (id = "registration-form-modal")
    public WebElement form;


    public void clickOnAddNewButton() {
        addNewButton.click();
    }

    public void insertFirstName() {
        firstNameField.clear();
        firstNameField.sendKeys("Dejan");
    }

    public void insertLastName() {
        lastNameField.clear();
        lastNameField.sendKeys("Stajcic");
    }

    public void insertEmail() {
        emailField.clear();
        emailField.sendKeys("dest@gmail.com");
    }

    public void insertAge() {
        ageField.clear();
        ageField.sendKeys("36");
    }

    public void insertSalary() {
        salaryField.clear();
        salaryField.sendKeys("50000");
    }

    public void insertDepartment() {
        departmentField.clear();
        departmentField.sendKeys("QA");
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public String getText() {
        return rows.get(3).getText();

    }
    public String getTextFromFirstRow (){
        return rows.get(0).getText();
    }

    public void searchForData(String data) {
        searchField.clear();
        searchField.sendKeys(data);
    }

    public void deleteRows() {
        deleteIcon.click();
    }
    public void clickOnNextButton(){
        for (int i=0; i<previousAndNextButtons.size();i++){
            if (previousAndNextButtons.get(i).getText().equals("Next")){
                previousAndNextButtons.get(i).click();
            }
        }
    }
    public void clickOnPreviousButton(){
        for (int i=0; i<previousAndNextButtons.size();i++){
            if (previousAndNextButtons.get(i).getText().equals("Previous")){
                previousAndNextButtons.get(i).click();
            }
        }
    }
}







