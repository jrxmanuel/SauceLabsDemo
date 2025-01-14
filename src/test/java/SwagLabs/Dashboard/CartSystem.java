package SwagLabs.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartSystem {
    WebDriver driver;
    WebDriverWait wait;
    List<String> addtoCartList = new ArrayList<>();
    List<String> itemsInsideCart = new ArrayList<>();
    public CartSystem(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void allElementSize()
    {
        List<WebElement> addtoCartButtonListElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("(//button[contains(@class, 'btn_primary btn_inventory')])")));  // Added closing parenthesis
        for (WebElement addtoCartButtonList : addtoCartButtonListElements)
        {
            addtoCartList.add(addtoCartButtonList.getText());
        }
    }


    public void addtoCart(){


        for (int i = 1; i <= addtoCartList.size(); i++) {
            WebElement addtoCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//button[contains(@class, 'btn_primary btn_inventory')and text() = 'ADD TO CART'])[" + (1) + "]")));  // XPath index starts from 1
            if(i == addtoCartList.size())
            {
                System.out.println("CLICKED ADDTOCART "+(i)+"X");
            }
            addtoCartButton.click();

            List<WebElement> CartItemsElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("(//div[contains(@class, 'inventory_item_name')])")));  // Added closing parenthesis
            for (WebElement CartItems : CartItemsElements)
            {
                itemsInsideCart.add(CartItems.getText());
            }




            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@class, 'shopping_cart_link')]")));
            cartIcon.click();

            WebElement CartValue = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//span[contains(@class, 'fa-layers-counter shopping_cart_badge')]")));
            String CartValueString = CartValue.getText();
            Assert.assertEquals(i,Integer.parseInt(CartValueString));
            System.out.println("ACTUAL # OF ITEMS IN CART: "+(i)+" EXPECTED: "+(CartValueString));
        }




    }
    public void removetoCart()
    {

        for (int i = 1; i <= addtoCartList.size(); i++) {
        WebElement removetoCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//button[contains(@class, 'btn_secondary btn_inventory')and text() = 'REMOVE'])[" + (1) + "]")));
        if(i == addtoCartList.size())
        {
            System.out.println("CLICKED REMOVE "+(i)+"X");
        }

        removetoCartButton.click();
    }



    }

}
