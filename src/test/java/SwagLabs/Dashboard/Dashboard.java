package SwagLabs.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    WebDriver driver;
    WebDriverWait wait;

    public Dashboard(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void SortListTesting()
    {
        List<String> itemNameList = new ArrayList<>();

        // Find all item names using an XPath selector
        List<WebElement> itemNameElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'inventory_item_name')]")));

        // Loop through all elements and add their text to the list
        for (WebElement itemName : itemNameElements) {
            itemNameList.add(itemName.getText());
        }

        // Print out the original list
        System.out.println("Original Item Names: " + itemNameList);



        // Print out the sorted list
        System.out.println("Sorted Item Names: " + itemNameList);

    }

}
