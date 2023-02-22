package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DynamicPropertiesPage extends DemoQABaseTest {
    public DynamicPropertiesPage (){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "enableAfter")
    public WebElement after5SecButton;
    @FindBy (id = "colorChange")
    public WebElement colorChangeButton;
    @FindBy (id = "visibleAfter")
    public WebElement visibleAfter5SecButton;
    @FindBy (css = ".mt-4.text-danger.btn.btn-primary")
    public WebElement colorChangeRed;
    @FindBy (css = ".mt-4.btn.btn-primary")
    public List<WebElement> buttons;


    public void assertVisibilityOfVisibleAfter5SecondsButton (){
        for (int i = 0; i<buttons.size(); i++){
            if (buttons.get(i).getText().equals("Visible After 5 Seconds")){

            }break;
        }

    }

}
