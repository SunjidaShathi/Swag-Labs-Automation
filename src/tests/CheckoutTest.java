package tests;

import org.openqa.selenium.edge.EdgeDriver;

import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutTest {

	 public static void main(String[] args) throws InterruptedException {
	        // Setup EdgeDriver
	        System.setProperty("edgedriver.edge.driver", "F:\\DOWNLOADS\\now edge\\edgedriver_win64\\msedgedriver.exe");
	        EdgeDriver driver = new EdgeDriver();
	        driver.manage().window().maximize();

	        // Step 1: Open SauceDemo and login
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.openSauceDemo();
	        loginPage.login("standard_user", "secret_sauce");

	        // Wait to observe the login process
	        Thread.sleep(2000); // Wait for 2 seconds

	        // Step 2: Add first product to the cart
	        ProductPage productPage = new ProductPage(driver);
	        productPage.addToCart(1); // Add first product
	        System.out.println("First product added to the cart.");
	        Thread.sleep(2000); // Wait for 2 seconds

	        // Step 3: Add second product to the cart
	        productPage.addToCart(2); // Add second product
	        System.out.println("Second product added to the cart.");
	        Thread.sleep(2000); // Wait for 2 seconds

	        // Step 4: Go to the cart
	        productPage.goToCart();
	        System.out.println("Navigating to the cart...");
	        Thread.sleep(2000); // Wait for 2 seconds

	        // Step 5: Proceed to checkout
	        CheckoutPage checkoutPage = new CheckoutPage(driver);
	        checkoutPage.clickCheckout();
	        System.out.println("Proceeding to checkout...");
	        Thread.sleep(2000); // Wait for 2 seconds

	        // Step 6: Enter checkout details
	        checkoutPage.enterFirstName("John");
	        checkoutPage.enterLastName("Doe");
	        checkoutPage.enterPostalCode("12345");
	        System.out.println("Checkout details entered.");
	        Thread.sleep(2000); // Wait for 2 seconds
	        checkoutPage.clickContinue();
	        System.out.println("Clicked Continue...");
	        Thread.sleep(2000); // Wait for 2 seconds

	        // Step 7: Complete the order
	        checkoutPage.clickFinish();
	        System.out.println("Completing the order...");
	        Thread.sleep(2000); // Wait for 2 seconds

	        // Step 8: Verify Order Success
	        if (checkoutPage.isOrderSuccessful()) {
	            System.out.println("Checkout Test Passed: Order was successful!");
	        } else {
	            System.out.println("Checkout Test Failed: Order not completed.");
	        }

	        // Step 9: Close Browser
	        driver.quit();
	    }
	}