package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends DemoQABaseTest {
    public CheckBoxPage (){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = ".rct-icon.rct-icon-expand-close")
    public List <WebElement> expandArrow;
    @FindBy(css = ".rct-icon.rct-icon-uncheck")
    public WebElement checkBox;
    @FindBy (css = ".rct-icon.rct-icon-expand-all")
    public WebElement plusIcon;
    @FindBy (css = ".rct-option.rct-option-collapse-all")
    public WebElement minusIcon;
    @FindBy (css = ".rct-node.rct-node-parent.rct-node-collapsed")
    public List <WebElement> iconsNotOpened;
    @FindBy (css = ".rct-node.rct-node-parent.rct-node-expanded")
    public List <WebElement> closeIcons;
    @FindBy (id = "result")
    public WebElement selectionResults;
    @FindBy (className = "rct-title")
    public List <WebElement> filesName;


   /* public void clickOnExpandArrow (){
        expandArrow.click();
    }*/
    public void clickOnCheckBox (){
        checkBox.click();
    }
    public void clickOnPlusIcon (){
        plusIcon.click();
    }

    public void clickOnEcOnxpandArrows() throws InterruptedException {
        for (int i=0; i<expandArrow.size();i++){
            expandArrow.get(i).click();
            Thread.sleep(1000);
        }
    }
    public void clickOnCloseDoc() throws InterruptedException {
        for (int i=0; i<closeIcons.size();i++){
            closeIcons.get(i).click();
            Thread.sleep(1000);
        }
    }
    public void clickOnMinusIcon (){
        minusIcon.click();
    }

}

