package SwagLabs;

import SwagLabs.Dashboard.CartSystem;
import SwagLabs.Dashboard.SortItems;
import SwagLabs.Login.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {

    WebDriver driver;
    CartSystem cartSystem;
    Login login;  //NAME OF OTHER PAGE OBJECT MODELS
    SortItems sortItems;
    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");    //WEBSITE
        login = new Login(driver);
        sortItems = new SortItems(driver);
        cartSystem = new CartSystem(driver);
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void LoopedLoginForm() {
        login.LoopLoginForm();
    }
    @Test(priority = 2) //THIS IS WHERE YOU START YOUR TEST
    public void testLogin() {
        login.LoginForm();
    }
    @Test(priority = 3)
    public void SortAtoZ() {
        sortItems.SortAtoZ();
    }
    @Test(priority = 4)
    public void SortZtoA() {
        sortItems.SortZtoA();
    }

    @Test(priority = 5)
    public void SortLowToHigh() {
        sortItems.SortLowToHigh();
    }

    @Test(priority = 6)
    public void SortHighToLow() {
        sortItems.SortHighToLow();
    }
















}
