package tests;

import org.openqa.selenium.edge.EdgeDriver;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

public class CartBadgeCountTest {

	public static void main(String[] args) throws InterruptedException {
        // Setup EdgeDriver
        System.setProperty("edgedriver.edge.driver", "F:\\DOWNLOADS\\now edge\\edgedriver_win64\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Step 1: Open SauceDemo and login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSauceDemo();
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(1000);  // Wait for login to complete

        // Step 2: Add multiple products to the cart
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart(1); // Add the first product
        Thread.sleep(1000);  // Wait for the cart to update
        productPage.addToCart(2); // Add the second product
        Thread.sleep(1000);  // Wait for the cart to update

        // Step 3: Verify the cart badge count after adding products
        CartPage cartPage = new CartPage(driver);
        String cartBadgeCount = cartPage.getCartBadgeCount();
        if (cartBadgeCount.equals("2")) {
            System.out.println("Cart Badge Count Validation Passed: 2 items in the cart.");
        } else {
            System.out.println("Cart Badge Count Validation Failed: Incorrect item count in the cart.");
        }

        // Step 4: Remove an item from the cart and verify the badge updates
        cartPage.removeProductFromCart();
        Thread.sleep(1000);  // Wait for the cart to update

        // Step 5: Verify the cart badge count after removing a product
        cartBadgeCount = cartPage.getCartBadgeCount();
        if (cartBadgeCount.equals("1")) {
            System.out.println("Cart Badge Count Validation Passed: 1 item in the cart.");
        } else {
            System.out.println("Cart Badge Count Validation Failed: Incorrect item count in the cart.");
        }

        // Step 6: Close the browser
        driver.quit();
    }
}