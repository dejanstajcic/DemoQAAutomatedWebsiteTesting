/*
import java.io.IOException;
import java.time.Duration;

public class helpBase {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String LoginURL;
    public Homepage homepage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckOutStepOnePage checkOutStepOnePage;
    public CheckoutStepTwoPage checkoutStepTwoPage;
    public CheckoutCompletePage checkoutCompletePage;

    @BeforeClass
    public void setUp () throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/SauceDemo/TestData.xlsx");
        LoginURL = excelReader.getStringData("URL", 1,0);
    }

    public void loginMethod (){
        String validUsername = excelReader.getStringData("Login",1,0);
        String validPassword = excelReader.getStringData("Login",1,1);
        homepage.inputUsername(validUsername);
        homepage.inputPassword(validPassword);
        homepage.clickOnLoginButton();
        Assert.assertTrue(inventoryPage.titleProducts.isDisplayed());
    }


    public void loginMethodLockedOutUser (){
        String validUsername = excelReader.getStringData("Login",2,0);
        String validPassword = excelReader.getStringData("Login",1,1);
        homepage.inputUsername(validUsername);
        homepage.inputPassword(validPassword);
        homepage.clickOnLoginButton();
        Assert.assertTrue(inventoryPage.titleProducts.isDisplayed());
    }
    public void loginMethodProblemUser (){
        String validUsername = excelReader.getStringData("Login",3,0);
        String validPassword = excelReader.getStringData("Login",1,1);
        homepage.inputUsername(validUsername);
        homepage.inputPassword(validPassword);
        homepage.clickOnLoginButton();
    }
    public void loginMethodPerformanceGlitchUser (){
        String validUsername = excelReader.getStringData("Login",4,0);
        String validPassword = excelReader.getStringData("Login",1,1);
        homepage.inputUsername(validUsername);
        homepage.inputPassword(validPassword);
        homepage.clickOnLoginButton();
    }

    public void addAllItemsToCart (){
        loginMethod();
        inventoryPage.clickOnAddBackpack();
        inventoryPage.clickOnAddOnesie();
        inventoryPage.clickOnAddBikeLight();
        inventoryPage.clickOnAddTShirtRed();
        inventoryPage.clickOnAddBoltTShirt();
        inventoryPage.clickOnAddFleeceJacket();
    }

    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
*/
