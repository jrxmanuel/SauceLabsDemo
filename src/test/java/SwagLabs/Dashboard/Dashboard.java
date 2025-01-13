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
                By.xpath("//option[@value='za' and text()='Name (Z to A)']")));
        SortLowToHighButton.click();

        List<String> itemPriceList = new ArrayList<>();
        List<String> OriginalPriceList = new ArrayList<>();
        List<WebElement> itemPriceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'inventory_item_price')]")));

        for(WebElement itemPrice : itemPriceElements )
        {   itemPriceList.add(itemPrice.getText());
            OriginalPriceList.add(itemPrice.getText());
        }
        System.out.println(itemPriceList+"Z TO A SORTING WORKS"+OriginalPriceList);



    }



}
