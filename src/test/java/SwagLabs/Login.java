package SwagLabs;
import org.openqa.selenium.By;
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

    public void LoginFormInput()
    {
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'form_input')and @id = 'user-name']")));
        username.sendKeys("standard_user");

        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'form_input')and @id = 'password']")));
        password.sendKeys("secret_sauce");

        WebElement LoginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'btn_action')and @id = 'login-button']")));
        LoginButton.click();

    }
}
