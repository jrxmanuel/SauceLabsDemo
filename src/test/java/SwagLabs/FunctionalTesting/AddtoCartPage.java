package SwagLabs.FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddtoCartPage {

    WebDriver driver;
    WebDriverWait wait;
    int itemsinCart;
    public AddtoCartPage(WebDriver driver)
    {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void addtoCartSingleItem()
    {
        for(int i = 1; i <= 1; i++)
        {
        WebElement addtoCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//button[contains(@class, 'btn_primary btn_inventory') and text() = 'ADD TO CART'])[1]")));
        addtoCartButton.click();

        WebElement CartValue = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[contains(@class, 'fa-layers-counter shopping_cart_badge')]")));
        String CartValueString = CartValue.getText();
        System.out.println("ACTUAL # OF ITEMS IN CART: " +i+ " EXPECTED: " + CartValueString);
    }
    }

    public void addtoCartMultipleItems()
    {


        for(int i = 1; i <= 6; i++)
        {
            WebElement addtoCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//button[contains(@class, 'btn_primary btn_inventory') and text() = 'ADD TO CART'])[1]")));
            addtoCartButton.click();
            itemsinCart = i;
        }
        WebElement CartValue = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[contains(@class, 'fa-layers-counter shopping_cart_badge')]")));
        String CartValueString = CartValue.getText();
        System.out.println("ACTUAL # OF ITEMS IN CART: " +itemsinCart+ " EXPECTED: " + CartValueString);

        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, 'shopping_cart_link')]")));
        cartIcon.click();
    }

}
