/*
public class helpTests {
    //6. Test klasa ekstenduje BaseTest klasu
    //7. Kreiram metodu pageSetUp sa anotacijom BeforeMethod jer zelim da se ova metoda izvrsi pre svakog testa

    @BeforeMethod
    public void pageSetUp() {
        //8. Inicijalizujem driver i wdwait
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //9. Odlazim na pocetnu stranicu koju sam upisao u svoj excel file
        driver.get(homeURL);
        //16. Inicijalizujem sve klase stranica
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        sidebarPage = new SidebarPage();
        practicePage = new PracticePage();
    }

    //17. Kreiram metodu bez anotacija jer zelim da je pozivam u svojim test metodama da skratim korake
    //Gde god primetimo da se code ponavlja, mozemo taj deo da smestimo u posebnu 'pomocnu' metodu
    //Nije bitno gde se nalaze ove metode u klasi ali radi snalazenja lakse je da ih postavimo pre
    //testnih metoda

    public void goToLoginPage() {
        sidebarPage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
    }

    //10. Kreiram praznu test metodu sa anotacijom samo da proverim da li mi se browser otvara i da li se
    //cita URL iz excel fajla

    */
/*@Test
    public void test() {
       //svrha testa je samo da pokrenem na pocetku i vidim jel sve radi
       //nakon toga bih ili obrisao metodu ili preimenovao pa nastavio dalje
       //ova provera moze da se nazove i Ping Test - proveravamo da li nam je server 'ziv'
    }*//*


    //-> prelazim na kreiranje pages klasa -> SidebarPage

    //18. Kreiram test metode
    @Test (priority = 10)
    public void userCanLogIn() {
        goToLoginPage();
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1,1);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.LogOutButton.isDisplayed());
        String expectedURL = excelReader.getStringData("URL", 1,3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        goToLoginPage();
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1,1);
            loginPage.insertUsername(invalidUsername);
            loginPage.insertPassword(validPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertFalse(isDisplayed(profilePage.LogOutButton));
            String expectedURL = excelReader.getStringData("URL", 1,3);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
        }
    }

    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        goToLoginPage();
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            loginPage.insertUsername(validUsername);
            loginPage.insertPassword(invalidPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertFalse(isDisplayed(profilePage.LogOutButton));
            String expectedURL = excelReader.getStringData("URL", 1,3);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
        }
    }

    @Test (priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        goToLoginPage();
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            loginPage.insertUsername(invalidUsername);
            loginPage.insertPassword(invalidPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertFalse(isDisplayed(profilePage.LogOutButton));
            String expectedURL = excelReader.getStringData("URL", 1,3);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
        }
    }

    //19. Kreiram tearDown metodu koja ce da mi zatvori browser posle svakog testa
    //*dok pravim testove ova metoda je zakomentarisana kako bih mogao lakse da ispratim ako neki test padne
    //kad vidim da je sve u redu onda aktiviram ovu metodu
    //-> prelazim na BaseTest klasu
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
*/
