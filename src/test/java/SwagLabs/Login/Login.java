package SwagLabs.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class Login
{
    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void LoopLoginForm()
    {
        String[] UsernameList = {"standard_user",
            "problem_user", "performance_glitch_user","locked_out_user"};
        var AccountUsed = 0;
        for (int i = 0; i < UsernameList.length; i++)
        {

            if(AccountUsed == 3)
            {
                WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[contains(@class, 'form_input')and @id = 'user-name']")));
                username.sendKeys(UsernameList[i]);

                WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[contains(@class, 'form_input')and @id = 'password']")));
                password.sendKeys("secret_sauce");

                WebElement LoginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[contains(@class, 'btn_action')and @id = 'login-button']")));
                LoginButton.click();


                WebElement LockedOutUserError = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(@class, 'error-button')]")));
            }
            else {
                WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[contains(@class, 'form_input')and @id = 'user-name']")));
                username.sendKeys(UsernameList[i]);

                WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[contains(@class, 'form_input')and @id = 'password']")));
                password.sendKeys("secret_sauce");

                WebElement LoginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[contains(@class, 'btn_action')and @id = 'login-button']")));
                LoginButton.click();

                WebElement DashboardCheck = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class, 'app_logo')]")));

                WebElement Hamburger = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class, 'bm-burger-button')]")));
                Hamburger.click();


                WebElement LogoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@class, 'bm-item menu-item')and text() = 'Logout']")));
                LogoutButton.click();

                AccountUsed++;
            }


        }
        System.out.println("ALL ACCOUNTS TESTED");
    }


    public void LoginForm()
    {
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'form_input')and @id = 'user-name']")));
        username.sendKeys(Keys.chord(Keys.CONTROL, "a"), "standard_user");

        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(
               By.xpath("//input[contains(@class, 'form_input')and @id = 'password']")));
        password.sendKeys(Keys.chord(Keys.CONTROL, "a"), "secret_sauce");

        WebElement LoginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'btn_action')and @id = 'login-button']")));
        LoginButton.click();

        WebElement DashboardLocate = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'app_logo')]")));

        System.out.println("DASHBOARD LOADED, LOGIN WORKS");
    }


    public void logout()
    {
        WebElement Hamburger = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//div[contains(@class, 'bm-burger-button')]")));
        Hamburger.click();


        WebElement LogoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, 'bm-item menu-item')and text() = 'Logout']")));
        LogoutButton.click();
    }
}
