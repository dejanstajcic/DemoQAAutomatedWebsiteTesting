package DemoQA.Tests;

import DemoQA.Base.DemoQABaseTest;
import DemoQA.Pages.CheckBoxPage;
import DemoQA.Pages.ElementsPage;
import DemoQA.Pages.Homepage;
import DemoQA.Pages.LinksPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class LinksTest extends DemoQABaseTest {
    @BeforeMethod
    public void pageSetUp (){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HomeURL);
        elementsPage = new ElementsPage();
        linksPage = new LinksPage();
        homepage = new Homepage();
        scrollIntoView(homepage.cards.get(0));
        homepage.clickOnElements();
        elementsPage.clickOnLinks();
    }
    @Test
    public void verifyThatUserIsOnLinksPage(){
        String expectedURL = excelReader.getStringData("URL",8,0);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(elementsPage.headerTitle.getText(),"Links");
    }

    @Test
    public void homeLinkFunctionality (){
        linksPage.clickOnHomeLink();
        ArrayList <String> listaTabova = new ArrayList<>(driver.getWindowHandles()); //napravio sam listu tabova kako bih dohvatio novootvoreni tab
        driver.switchTo().window(listaTabova.get(1));//prebacujem se u novi tab
        Assert.assertEquals(driver.getCurrentUrl(),HomeURL);//Asertovao sam da je u novom tabu URL adresa homepage adresa demoQA sajta.
    }
    @Test
    public void dynamicLinkFuncionality (){
        linksPage.clickOnDynamicLink();
        ArrayList <String> listaTabova = new ArrayList<>(driver.getWindowHandles()); //napravio sam listu tabova kako bih dohvatio novootvoreni tab
        driver.switchTo().window(listaTabova.get(1));//prebacujem se u novi tab
        Assert.assertEquals(driver.getCurrentUrl(),HomeURL);//Asertovao sam da je u novom tabu URL adresa homepage adresa demoQA sajta.
    }
    @Test
    public void createdLinkFunctionality() throws InterruptedException {
        linksPage.clickOnCreatedLink();
        waitElementtoBeClickable(linksPage.responseMessage);
        Assert.assertEquals(linksPage.responseMessage.getText(),"Link has responded with staus " +
                201 + //prvo sam ostavio text iz response poruke pod stringom i nije radilo, zatim sam code broj ostavio bez navodnika i izvukao je pravu poruku za asertaciju
        " and status text " +
                "Created" );
    }
    @Test
    public void NoContentLinkFunctionality () throws InterruptedException {
        linksPage.clickOnNoContentLink();
        waitElementtoBeClickable(linksPage.responseMessage);//waiter da budem siguran da se pojavio element sa response porukom
        Assert.assertEquals(linksPage.responseMessage.getText(),"Link has responded with staus " +
                204 + //prvo sam ostavio text iz response poruke pod stringom i nije radilo, zatim sam code broj ostavio bez navodnika i izvukao je pravu poruku za asertaciju
                " and status text " +
                "No Content" );
    }
    @Test
    public void movedLinkFunctionality (){
        linksPage.clickOnMovedLink();
        waitElementtoBeClickable(linksPage.responseMessage);
        Assert.assertEquals(linksPage.responseMessage.getText(),"Link has responded with staus " +
                301 +
                " and status text " +
                "Moved Permanently" );
    }
    @Test
    public void badRequestLinkFunctionality (){
        linksPage.clickOnBadRequestLink();
        waitElementtoBeClickable(linksPage.responseMessage);
        Assert.assertEquals(linksPage.responseMessage.getText(),"Link has responded with staus " +
                400 +
                " and status text " +
                "Bad Request" );
    }
    @Test
    public void unauthorizedLinkFunctionality (){
        linksPage.clickOnUnauthorizedLink();
        waitElementtoBeClickable(linksPage.responseMessage);
        Assert.assertEquals(linksPage.responseMessage.getText(),"Link has responded with staus " +
                401 +
                " and status text " +
                "Unauthorized" );
    }
    @Test
    public void forbiddenLinkFunctionality (){
        linksPage.clickOnForbiddenLink();
        waitElementtoBeClickable(linksPage.responseMessage);
        Assert.assertEquals(linksPage.responseMessage.getText(),"Link has responded with staus " +
                403 +
                " and status text " +
                "Forbidden" );
    }
    @Test
    public void notFoundLinkFunctionality (){
        linksPage.clickOnNotFoundLink();
        waitElementtoBeClickable(linksPage.responseMessage);
        Assert.assertEquals(linksPage.responseMessage.getText(),"Link has responded with staus " +
                404 +
                " and status text " +
                "Not Found" );
    }

    @AfterMethod
    public void closure (){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
