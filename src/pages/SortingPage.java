package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SortingPage {

	private EdgeDriver driver;

    // Locators
    private By productSortDropdown = By.className("product_sort_container");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price"); // Locator for product prices

    public SortingPage(EdgeDriver driver) {
        this.driver = driver;
    }

    // Method to select sorting option
    public void selectSortOption(String optionValue) {
        WebElement sortDropdown = driver.findElement(productSortDropdown);
        sortDropdown.click();
        driver.findElement(By.xpath("//option[@value='" + optionValue + "']")).click();
    }

    // Method to get the list of product names
    public List<WebElement> getProductList() {
        return driver.findElements(productNames);
    }

    // Method to get the list of product prices
    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }
}