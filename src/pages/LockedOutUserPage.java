package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class LockedOutUserPage {

	private EdgeDriver driver;

    // Locators
    private By usernameField = By.name("user-name");
    private By passwordField = By.name("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container");

    public LockedOutUserPage(EdgeDriver driver) {
        this.driver = driver;
    }

    // Open SauceDemo login page
    public void openSauceDemo() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    // Login with locked-out user credentials
    public void loginLockedOutUser() {
        driver.findElement(usernameField).sendKeys("locked_out_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }

    // Check for the error message
    public boolean isErrorDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }
}