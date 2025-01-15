package SwagLabs.FunctionalTesting;

import SwagLabs.FunctionalTesting.LoginPage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Testing {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp()
    {

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);

    }
    @AfterClass
    public void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void ValidLoginInput()
    {
        loginPage.PositiveLoginInputs();
        System.out.println("VALID LOGIN INPUT PASSED");
    }






}
