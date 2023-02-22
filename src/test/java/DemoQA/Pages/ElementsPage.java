package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends DemoQABaseTest {
    public ElementsPage (){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "item-0")
    public WebElement textBox;
    @FindBy (id = "item-1")
    public WebElement checkBox;
    @FindBy (id ="item-2" )
    public WebElement radioButton;
    @FindBy (id ="item-3" )
    public WebElement webTables;
    @FindBy (id ="item-4" )
    public WebElement buttons;
    @FindBy (id ="item-5" )
    public WebElement links;
    @FindBy (id ="item-6" )
    public WebElement brokenLinksImages;
    @FindBy (id ="item-7" )
    public WebElement uploadAndDownload;
    @FindBy (id = "item-8")
    public WebElement dynamicProperties;
    @FindBy (className = "main-header")
    public WebElement headerTitle;

    public void clickOnTextBox (){
        textBox.click();
    }
    public void clickOnCheckBox (){
        checkBox.click();
    }
    public void clcikOnradioButton (){
        radioButton.click();
    }
    public void clickOnWebTables (){
        webTables.click();
    }
    public void clickOnButtons (){
        buttons.click();
    }
    public void clickOnLinks (){
        links.click();
    }
    public void clickOnBrokenLinksImages (){
        brokenLinksImages.click();
    }
    public void clickOnUploadAndDownload (){
        uploadAndDownload.click();
    }
    public void clickOndynamicProperties (){
        dynamicProperties.click();
    }


}
