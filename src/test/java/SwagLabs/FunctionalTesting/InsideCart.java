package SwagLabs.FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InsideCart {

    WebDriver driver;
    WebDriverWait wait;
    AddtoCartPage addtoCartPage;

    List<String> itemsAddedToCart = new ArrayList<>();
    List<String> itemsInsideCart = new ArrayList<>();

    public InsideCart(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.addtoCartPage = new AddtoCartPage(driver);
    }

    public void checkInsideCartMultiple()
    {
        int itemsToAdd = 6;

        while (itemsToAdd <= 6) {

            // Add items to cart based on current iteration
            for (int k = 0; k < itemsToAdd; k++) {
                WebElement addtoCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//button[contains(@class, 'btn_primary btn_inventory') and text() = 'ADD TO CART'])[1]")));
                addtoCartButton.click();

                WebElement CartItemElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class, 'inventory_item_name')])[" + (k+1) + "]")));
                itemsAddedToCart.add(CartItemElement.getText());
            }

            // Go to cart
            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@class, 'shopping_cart_link')]")));
            cartIcon.click();

            // Get items in cart
            List<WebElement> CartItemsInsideElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class, 'inventory_item_name')]")));
            for (WebElement CartItemsInside : CartItemsInsideElements) {
                itemsInsideCart.add(CartItemsInside.getText());
            }

            // Print and verify cart contents
            System.out.println("ITEMS INSIDE: " + itemsInsideCart);
            System.out.println("ITEMS ADDED: " + itemsAddedToCart);
            Assert.assertEquals(itemsAddedToCart, itemsInsideCart);

            WebElement CartValue = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//span[contains(@class, 'fa-layers-counter shopping_cart_badge')]")));
            String CartValueString = CartValue.getText();
            System.out.println("ACTUAL # OF ITEMS IN CART: " + itemsToAdd + " EXPECTED: " + CartValueString);

            // Proceed to checkout
            WebElement CheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@class, 'btn_action checkout_button')and text() = 'CHECKOUT']")));
            CheckoutButton.click();
            itemsToAdd++;
        }
    }
    public void checkInsideCartSingle()
    {
        int itemsToAdd = 1;

        while (itemsToAdd <= 1) {

            // Add items to cart based on current iteration
            for (int k = 0; k < itemsToAdd; k++) {
                WebElement addtoCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//button[contains(@class, 'btn_primary btn_inventory') and text() = 'ADD TO CART'])[1]")));
                addtoCartButton.click();

                WebElement CartItemElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class, 'inventory_item_name')])[" + (k+1) + "]")));
                itemsAddedToCart.add(CartItemElement.getText());
            }

            // Go to cart
            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@class, 'shopping_cart_link')]")));
            cartIcon.click();

            // Get items in cart
            List<WebElement> CartItemsInsideElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class, 'inventory_item_name')]")));
            for (WebElement CartItemsInside : CartItemsInsideElements) {
                itemsInsideCart.add(CartItemsInside.getText());
            }

            // Print and verify cart contents
            System.out.println("ITEMS INSIDE: " + itemsInsideCart);
            System.out.println("ITEMS ADDED: " + itemsAddedToCart);
            Assert.assertEquals(itemsAddedToCart, itemsInsideCart);

            WebElement CartValue = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//span[contains(@class, 'fa-layers-counter shopping_cart_badge')]")));
            String CartValueString = CartValue.getText();
            System.out.println("ACTUAL # OF ITEMS IN CART: " + itemsToAdd + " EXPECTED: " + CartValueString);

            // Proceed to checkout
            WebElement CheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@class, 'btn_action checkout_button')and text() = 'CHECKOUT']")));
            CheckoutButton.click();
            itemsToAdd++;
        }


    }

}


