package tests;

import org.openqa.selenium.edge.EdgeDriver;

import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest {

	public static void main(String[] args) throws InterruptedException {
        // Setup EdgeDriver
        System.setProperty("edgedriver.edge.driver", "F:\\DOWNLOADS\\now edge\\edgedriver_win64\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Step 1: Open SauceDemo and login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSauceDemo();
        Thread.sleep(1000);  // Wait for the page to load
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(1000);  // Wait for the login to complete

        // Step 2: Click the hamburger menu and logout
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickHamburgerMenu();
        Thread.sleep(1000);  // Wait for the hamburger menu to open
        logoutPage.clickLogout();
        Thread.sleep(2000);  // Wait for the logout action to complete and for the page to load

        // Step 3: Verify that the user is redirected to the login page
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Logout Test Passed: User is redirected to the login page.");
        } else {
            System.out.println("Logout Test Failed: User is not redirected to the login page.");
        }

        // Step 4: Close the browser
        driver.quit();
    }
}