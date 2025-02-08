package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	EdgeDriver driver;

    public ProductPage(EdgeDriver driver) {
        this.driver = driver;
        // Set implicit wait using Duration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // New way of setting implicit wait
    }

    // Add product to cart by clicking "Add to cart" button using full XPath
    public void addToCart(int productIndex) {
        if (productIndex == 1) {
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click(); // First product
        } else if (productIndex == 2) {
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button")).click(); // Second product
        }
    }

    // Go to the cart by clicking the cart icon using full XPath
    public void goToCart() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click(); // View Cart
    }

    // Wait for a few seconds
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Sleep for the given time in seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 // Verify cart badge count with explicit wait to ensure visibility of the badge element
    public void verifyCartBadgeCount(int expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        
        String badgeText = cartBadge.getText();
        int badgeCount = Integer.parseInt(badgeText);
        
        if (badgeCount == expectedCount) {
            System.out.println("Cart badge count is correct: " + badgeCount);
        } else {
            System.out.println("Cart badge count is incorrect. Expected: " + expectedCount + ", Found: " + badgeCount);
        }
    }
    // Remove product from the cart by clicking "Remove" button using full XPath
    public void removeFromCart(int productIndex) {
        if (productIndex == 1) {
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/button")).click(); // First product remove
        } else if (productIndex == 2) {
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/button")).click(); // Second product remove
        }
    }

    
}