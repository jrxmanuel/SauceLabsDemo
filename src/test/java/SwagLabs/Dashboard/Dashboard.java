package SwagLabs.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dashboard {
    WebDriver driver;
    WebDriverWait wait;

    public Dashboard(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void SortAtoZ()
    {
        WebElement SortButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//select[contains(@class, 'product_sort_container')]")));
        SortButton.click();

        WebElement SortAtoZButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//option[@value='az' and text()='Name (A to Z)']")));
        SortAtoZButton.click();

        List<String> itemNameList = new ArrayList<>();
        List<String> OriginalNameList = new ArrayList<>();
        List<WebElement> itemNameElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'inventory_item_name')]")));

        for (WebElement itemName : itemNameElements) {
            itemNameList.add(itemName.getText());
            OriginalNameList.add(itemName.getText());
        }
        Collections.sort(itemNameList);
        Assert.assertEquals(OriginalNameList, itemNameList);
        System.out.println("A TO Z SORTING WORKS");
    }

    public void SortZtoA()
    {
        WebElement SortButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//select[contains(@class, 'product_sort_container')]")));
        SortButton.click();

        WebElement SortZtoAButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//option[@value='za' and text()='Name (Z to A)']")));
        SortZtoAButton.click();

        List<String> itemNameList = new ArrayList<>();
        List<String> OriginalNameList = new ArrayList<>();
        List<WebElement> itemNameElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'inventory_item_name')]")));

        for (WebElement itemName : itemNameElements) {
            itemNameList.add(itemName.getText());
            OriginalNameList.add(itemName.getText());
        }
        Collections.sort(itemNameList);
        Collections.reverse(itemNameList);
        Assert.assertEquals(OriginalNameList, itemNameList);

        System.out.println("Z TO A SORTING WORKS");
    }


    public void SortLowToHigh()
    {
        WebElement SortButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//select[contains(@class, 'product_sort_container')]")));
        SortButton.click();

        WebElement SortLowToHighButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//option[@value='lohi' and text()='Price (low to high)']")));
        SortLowToHighButton.click();

        List<Double> itemPriceList = new ArrayList<>();
        List<Double> OriginalPriceList = new ArrayList<>();
        List<WebElement> itemPriceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'inventory_item_price')]")));

        for(WebElement itemPrice : itemPriceElements )
        {
            double price = Double.parseDouble(itemPrice.getText().replace("$", ""));
            itemPriceList.add(price);
            OriginalPriceList.add(price);
        }

        Collections.sort(itemPriceList);
       Assert.assertEquals(OriginalPriceList, itemPriceList);

        System.out.println("LOW TO HIGH PRICE SORTING WORKS");

    }

    public void SortHighToLow()
    {
        WebElement SortButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//select[contains(@class, 'product_sort_container')]")));
        SortButton.click();

        WebElement SortHighToLowButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//option[@value='hilo' and text()='Price (high to low)']")));
        SortHighToLowButton.click();

        List<Double> itemPriceList = new ArrayList<>();
        List<Double> OriginalPriceList = new ArrayList<>();
        List<WebElement> itemPriceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'inventory_item_price')]")));

        for(WebElement itemPrice : itemPriceElements )
        {
            double price = Double.parseDouble(itemPrice.getText().replace("$", ""));
            itemPriceList.add(price);
            OriginalPriceList.add(price);
        }

        Collections.sort(itemPriceList);
        Collections.reverse(itemPriceList);
        Assert.assertEquals(OriginalPriceList, itemPriceList);
        System.out.println("HIGH TO LOW PRICE SORTING WORKS");

    }



}
