package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class CheckoutPage {

	 private EdgeDriver driver;

	    // Locators
	    private By checkoutButton = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]");
	    private By firstNameField = By.id("first-name");
	    private By lastNameField = By.id("last-name");
	    private By postalCodeField = By.id("postal-code");
	    private By continueButton = By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input");
	    private By finishButton = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]");
	    private By successMessage = By.xpath("//h2[contains(text(),'Thank you for your order!')]");

	    public CheckoutPage(EdgeDriver driver) {
	        this.driver = driver;
	    }

	    public void clickCheckout() {
	        driver.findElement(checkoutButton).click();
	    }

	    public void enterFirstName(String firstName) {
	        driver.findElement(firstNameField).sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        driver.findElement(lastNameField).sendKeys(lastName);
	    }

	    public void enterPostalCode(String postalCode) {
	        driver.findElement(postalCodeField).sendKeys(postalCode);
	    }

	    public void clickContinue() {
	        driver.findElement(continueButton).click();
	    }

	    public void clickFinish() {
	        driver.findElement(finishButton).click();
	    }

	    public boolean isOrderSuccessful() {
	        return driver.findElements(successMessage).size() > 0;
	    }
	}