package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage extends DemoQABaseTest {
    public PracticeFormPage(){
        PageFactory.initElements(driver,this);
    }

}
