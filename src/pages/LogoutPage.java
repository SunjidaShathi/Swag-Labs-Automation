package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class LogoutPage {

	private EdgeDriver driver;

    // Locators
    private By hamburgerMenu = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/button");
    private By logoutButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]");

    public LogoutPage(EdgeDriver driver) {
        this.driver = driver;
    }

    // Click the hamburger menu
    public void clickHamburgerMenu() {
        driver.findElement(hamburgerMenu).click();
    }

    // Click the Logout button
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}