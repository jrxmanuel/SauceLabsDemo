package SwagLabs.FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {

    WebDriver driver;
    LoginPage loginPage;
    AddtoCartPage addtoCartPage;
    InsideCart insideCart;

    @BeforeClass
    public void setUp()
    {

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
        addtoCartPage = new AddtoCartPage(driver);
        insideCart = new InsideCart(driver);

    }
    @AfterClass
    public void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

    public void GotoLogin()
    {
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @Test(priority = 1)
    public void ValidLoginInput()
    {
        loginPage.PositiveLoginInputs();
        System.out.println("VALID LOGIN INPUT PASSED");
    }

    @Test(priority = 2)
    public void AddtoCartSingle()
    {

        loginPage.FillLoginForm();
        addtoCartPage.addtoCartSingleItem();
        System.out.println("SINGLE ITEM ADD TO CART PASSED");
    }

    @Test(priority = 3)
    public void AddtoCartMultiple()
    {
        loginPage.FillLoginForm();
        addtoCartPage.addtoCartMultipleItems();
        System.out.println("MULTIPLE ITEMS ADD TO CART PASSED");
    }

    @Test(priority = 4)
    public void InsideCartMultiple()
    {
        loginPage.FillLoginForm();
        insideCart.checkInsideCartMultiple();
        System.out.println("MULTIPLE ITEMS INSIDE CART PASSED");
    }

    @Test(priority = 4)
    public void InsideCartSingle()
    {
        loginPage.FillLoginForm();
        insideCart.checkInsideCartSingle();
        System.out.println("SINGLE ITEMS INSIDE CART PASSED");
    }






}
