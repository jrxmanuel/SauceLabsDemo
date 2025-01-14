package SwagLabs;

import SwagLabs.Dashboard.CartSystem;
import SwagLabs.Dashboard.SortItems;
import SwagLabs.Login.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing2 {

    WebDriver driver;
    CartSystem cartSystem;
    Login login;  //NAME OF OTHER PAGE OBJECT MODELS
    SortItems sortItems;
    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
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

    @Test(priority = 1) //THIS IS WHERE YOU START YOUR TEST
    public void testLogin() {
        login.LoginForm();
    }

    @Test(priority = 2)
    public void allElement()
    {
        cartSystem.allElementSize();
    }

    //@Test(priority = 4)
    public void removeToCartButton()
    {
        cartSystem.removetoCart();
    }

    @Test(priority = 3)
    public void AddtoCartButton() {

    cartSystem.addtoCart();
    }
}
