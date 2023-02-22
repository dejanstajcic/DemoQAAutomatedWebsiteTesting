package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends DemoQABaseTest {
   public RadioButtonPage (){
       PageFactory.initElements(driver,this);
   }
   @FindBy (className = "custom-control-label")
    public List<WebElement> radioButtons;
   @FindBy (id = "noRadio")
   public WebElement noRadioButton;
   @FindBy (css = ".custom-control-label.disabled")
   public WebElement crossedCircle;
   @FindBy (className = "text-success")
   public WebElement notification;
   @FindBy (className = "mt-3")
   public WebElement messageElement;

   public void clickOnYesRadioButton (){
       radioButtons.get(0).click();
   }
   public void clickOnImpressiveRadioButton (){
       radioButtons.get(1).click();
   }
   public void clickOnNoradioButton(){
       action.moveToElement(noRadioButton).perform();
   }
    Actions action = new Actions(driver);


}
