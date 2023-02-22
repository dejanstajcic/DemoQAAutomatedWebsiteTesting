package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenPage extends DemoQABaseTest {
    public BrokenPage (){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "img[src='/images/Toolsqa.jpg']") //trazio sam elemente preko value-a
    public WebElement toolsQAImage;
    @FindBy (css ="img[src='/images/Toolsqa_1.jpg']" )
    public WebElement brokenImageIcon;
    @FindBy (css ="a[href='http://demoqa.com']" )
    public WebElement validLink;
    @FindBy (css ="a[href='http://the-internet.herokuapp.com/status_codes/500']" )
    public WebElement brokenLink;


    public void clickOnValidLink (){
        validLink.click();
    }
    public void clickOnBrokenLink (){
        brokenLink.click();
    }
}
