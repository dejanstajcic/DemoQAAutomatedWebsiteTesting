package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Base.ExcelReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends DemoQABaseTest {
    public TextBoxPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "userName")
    public WebElement fullNameField;
    @FindBy (id = "userEmail")
    public WebElement emailField;
    @FindBy (id = "currentAddress")
    public WebElement currentAddress;
    @FindBy (id = "permanentAddress")
    public WebElement permanentAddress;
    @FindBy (id = "submit")
    public WebElement submit;
    @FindBy (id = "output")
    public WebElement outputForm;
    @FindBy (css = ".mr-sm-2.field-error.form-control")
    public WebElement errorEmailMessage;

    public void inputFullName (){
        fullNameField.clear();
        fullNameField.sendKeys("dejan sta");
    }

    public void inputEmail (){
        emailField.clear();
        emailField.sendKeys("1234@gmail.com");
    }
    public void inputCurrentAddress (){
        currentAddress.clear();
        currentAddress.sendKeys("moja adresa 12");
    }
    public void inputPermanentAddress (){
        permanentAddress.clear();
        permanentAddress.sendKeys("moja sadasnja adresa 15");
    }
    public void clickOnSubmitButton (){
        submit.click();
    }

    /*public void inputInvalidFullName (){
        for (int i=1; i<excelReader.getLastRow("textBox"); i++){
            fullNameField.clear();
            fullNameField.sendKeys(excelReader.getStringData("textBox",i,0));
        }
    }*/

}
