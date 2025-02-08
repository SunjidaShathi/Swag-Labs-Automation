package tests;

import org.openqa.selenium.edge.EdgeDriver;

import pages.LockedOutUserPage;

public class LockedOutUserTest {

	 public static void main(String[] args) throws InterruptedException {
	        // Setup EdgeDriver
	        System.setProperty("edgedriver.edge.driver", "F:\\DOWNLOADS\\now edge\\edgedriver_win64\\msedgedriver.exe");
	        EdgeDriver driver = new EdgeDriver();
	        driver.manage().window().maximize();

	        // Step 1: Open SauceDemo login page
	        LockedOutUserPage lockedOutUserPage = new LockedOutUserPage(driver);
	        lockedOutUserPage.openSauceDemo();
	        Thread.sleep(1000);  // Wait for the page to load

	        // Step 2: Enter locked-out user credentials and click Login
	        lockedOutUserPage.loginLockedOutUser();
	        Thread.sleep(1000);  // Wait for the login attempt to complete

	        // Step 3: Verify the error message for locked-out user
	        if (lockedOutUserPage.isErrorDisplayed()) {
	            System.out.println("Locked-Out User Validation Passed: Error message is displayed.");
	        } else {
	            System.out.println("Locked-Out User Validation Failed: Error message is not displayed.");
	        }

	        // Step 4: Close the browser
	        driver.quit();
	    }
	}