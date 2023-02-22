package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends DemoQABaseTest {
    public ButtonsPage (){
        PageFactory.initElements(driver,this);
    }
    Actions action = new Actions(driver);

    @FindBy (id = "doubleClickBtn")
    public WebElement doubleClickButton;
    @FindBy (id = "rightClickBtn")
    public WebElement rightClickButton;
    @FindBy (id = "9E8Qr")
    public WebElement clickMeButton;
    @FindBy (id = "doubleClickMessage")
    public WebElement doubleClickMessage;
    @FindBy (id = "rightClickMessage")
    public WebElement rightClickMessage;
    @FindBy (id = "dynamicClickMessage")
    public WebElement clickMeMessage;
    @FindBy (css = ".btn.btn-primary")
    public List<WebElement> buttons;

    public void doubleClickOnDoubleClickButton (){
        action.doubleClick(doubleClickButton).perform();
    }

    public void rightClickOnRightclickButton(){
        action.contextClick(rightClickButton).perform();
    }

    public void clickOnClickMeButton (){
        buttons.get(2).click();
    }
}
