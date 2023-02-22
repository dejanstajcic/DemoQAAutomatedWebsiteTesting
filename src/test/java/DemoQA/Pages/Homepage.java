package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage extends DemoQABaseTest {
    public Homepage (){
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "card-body")
    public List<WebElement> cards;

    public void clickOnElements (){
        for (int i =0; i<cards.size();i++){
            if(cards.get(i).getText().equals("Elements")){
                cards.get(i).click();
            }break;
        }
    }
    public void clickOnForms (){
        for (int i =0; i<cards.size();i++){
            if(cards.get(i).getText().equals("Forms")){
                cards.get(i).click();
            }break;
        }
    }
    public void clickOnAlerts(){
        for (int i =0; i<cards.size();i++){
            if(cards.get(i).getText().equals("Alerts, Frame & Windows")){
                cards.get(i).click();
            }break;
        }
    }
    public void clickOnWidgets (){
        for (int i =0; i<cards.size();i++){
            if(cards.get(i).getText().equals("Widgets")){
                cards.get(i).click();
            }break;
        }
    }
    public void clickOnInteractions (){
        for (int i =0; i<cards.size();i++){
            if(cards.get(i).getText().equals("Interactions")){
                cards.get(i).click();
            }break;
        }
    }
    public void clickOnBookStore (){
        for (int i =0; i<cards.size();i++){
            if(cards.get(i).getText().equals("Book Store Application")){
                cards.get(i).click();
            }break;
        }
    }




}
