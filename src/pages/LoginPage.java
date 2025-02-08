package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage {
	EdgeDriver driver;

    // Constructor to initialize the driver
    public LoginPage(EdgeDriver driver) {
        this.driver = driver;
    }

    // Open the SauceDemo login page
    public void openSauceDemo() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    // Login with username and password
    public void login(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    // Check if login was successful by verifying the "Products" title
    public void checkLogin() {
        String pageTitle = driver.findElement(By.className("title")).getText();
        if (pageTitle.equals("Products")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
        }
    }

    // Check for an error message in case of a failed login
    public void checkLoginError() {
        if (driver.findElements(By.cssSelector(".error-message-container")).size() > 0) {
            System.out.println("Login Failed! Error message is displayed.");
        } else {
            System.out.println("No error message. Login might be successful.");
        }
    }
}