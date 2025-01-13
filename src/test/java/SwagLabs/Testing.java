package SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {

    WebDriver driver;

    Login login;  //NAME OF OTHER PAGE OBJECT MODELS

    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");    //WEBSITE
        login = new Login(driver);

    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1) //THIS IS WHERE YOU START YOUR TEST

    public void testLogin() {
        login.LoginFormInput();
    }
}
