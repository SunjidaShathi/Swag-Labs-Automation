package tests;

import org.openqa.selenium.edge.EdgeDriver;

import pages.LoginPage;

public class NegtiveLoginTest {

	public static void main(String[] args) throws InterruptedException {
        // Set up EdgeDriver and the LoginPage object
        System.setProperty("edgedriver.edge.driver", "F:\\DOWNLOADS\\now edge\\edgedriver_win64\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        LoginPage loginPage = new LoginPage(driver);

        // Open SauceDemo for negative login
        loginPage.openSauceDemo();

        // Test: Invalid Login (wrong username)
        loginPage.login("wrong_user", "secret_sauce");
        loginPage.checkLoginError();

        // Wait for 5 seconds before closing
        Thread.sleep(5000);

        driver.quit();
    }
}