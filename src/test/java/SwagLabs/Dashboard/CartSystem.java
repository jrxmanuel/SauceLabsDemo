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
    SortItems sortItems;
    List<String> addtoCartList = new ArrayList<>();
    List<String> itemsAddedToCart = new ArrayList<>();
    List<String> itemsInsideCart = new ArrayList<>();
    int SortNumber = 1;
    public CartSystem(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        sortItems = new SortItems(driver);
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


    public void addtoCart() {
        // Counter for how many items to add in current iteration
        int itemsToAdd = 1;

        while (itemsToAdd <= addtoCartList.size()) {
            // Clear previous items
            itemsAddedToCart.clear();
            itemsInsideCart.clear();

            // Add items to cart based on current iteration
            for (int k = 0; k < itemsToAdd; k++) {
                WebElement addtoCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//button[contains(@class, 'btn_primary btn_inventory') and text() = 'ADD TO CART'])[1]")));
                addtoCartButton.click();

                WebElement CartItemElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class, 'inventory_item_name')])[" + (k + 1) + "]")));
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

            // Complete checkout process
            CheckoutForm();

            // Increment counter for next iteration
            itemsToAdd++;
        }
        SortNumber++;
    }

    public void CheckoutForm() {
        WebElement FirstNameTextBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@class, 'form_input')and @id = 'first-name']")));
        WebElement LastNameTextBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@class, 'form_input')and @id = 'last-name']")));
        WebElement PostalTextBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@class, 'form_input')and @id = 'postal-code']")));
        WebElement ContinueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@class, 'btn_primary cart_button')and @value = 'CONTINUE']")));

        FirstNameTextBox.sendKeys("JEAN REI");
        LastNameTextBox.sendKeys("MANUEL");
        PostalTextBox.sendKeys("4102");
        ContinueButton.click();

        WebElement CheckoutOverview = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'subheader')and text() = 'Checkout: Overview']")));
        WebElement FinishButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[contains(@class, 'btn_action cart_button')and text() = 'FINISH']")));
        FinishButton.click();

        WebElement Hamburger = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'bm-burger-button')]")));
        Hamburger.click();

        WebElement AllItemsButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, 'bm-item menu-item')and text() = 'All Items']")));
        AllItemsButton.click();

        if(SortNumber == 1)
        {
        sortItems.SortAtoZ();
        }
        else if(SortNumber == 2)
        {
        sortItems.SortZtoA();
        }
         else if(SortNumber == 3)
        {
            sortItems.SortHighToLow();
        }
         else if(SortNumber == 4)
        {
            sortItems.SortLowToHigh();
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
