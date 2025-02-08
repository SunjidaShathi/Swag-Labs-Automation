package tests;

import org.openqa.selenium.edge.EdgeDriver;

import pages.LoginPage;
import pages.ProductPage;

public class AddToCartTest {

	public static void main(String[] args) throws InterruptedException {
        // Set EdgeDriver property
        System.setProperty("edgedriver.edge.driver", "F:\\DOWNLOADS\\now edge\\edgedriver_win64\\msedgedriver.exe");

        // Initialize EdgeDriver and open the browser
        EdgeDriver driver = new EdgeDriver();

        // Open SauceDemo and login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSauceDemo();
        loginPage.login("standard_user", "secret_sauce");

        // Initialize ProductPage object for interacting with products
        ProductPage productPage = new ProductPage(driver);

        // Step 1: Add the first two products to the cart
        productPage.addToCart(1); // Add first product
        productPage.addToCart(2); // Add second product

        // Step 2: Wait for 2 seconds to ensure items are added to the cart
        productPage.waitForSeconds(2);

        // Step 3: Go to the cart
        productPage.goToCart();

        // Step 4: Verify cart badge count is 2 before removing any products
        productPage.verifyCartBadgeCount(2);

        // Step 5: Wait for 3 seconds before removing items from cart
        productPage.waitForSeconds(3);

        // Step 6: Remove both products from the cart
        productPage.removeFromCart(1); // Remove first product
        productPage.removeFromCart(2); // Remove second product

        // Step 7: Wait for 3 seconds to observe the changes
        productPage.waitForSeconds(3);

       
        // Step 9: Close the browser after a short wait
        productPage.waitForSeconds(2);
        driver.quit();
    }
}