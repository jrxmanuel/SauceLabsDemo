package SwagLabs;

import SwagLabs.Dashboard.Dashboard;
import SwagLabs.Login.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {

    WebDriver driver;

    Login login;  //NAME OF OTHER PAGE OBJECT MODELS
    Dashboard dashboard;
    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");    //WEBSITE
        login = new Login(driver);
        dashboard = new Dashboard(driver);
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
        dashboard.SortAtoZ();
    }
    @Test(priority = 4)
    public void SortZtoA() {
        dashboard.SortZtoA();
    }

    @Test(priority = 5)
    public void SortLowToHigh() {
        dashboard.SortLowToHigh();
    }

    @Test(priority = 6)
    public void SortHighToLow() {
        dashboard.SortHighToLow();
    }
















}
