package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class CartPage {

	 private EdgeDriver driver;

	    // Locators
	    private By cartBadge = By.className("shopping_cart_badge");
	    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
	    private By removeFromCartButton = By.xpath("//button[contains(text(),'Remove')]");
	    private By cartIcon = By.className("shopping_cart_link");

	    public CartPage(EdgeDriver driver) {
	        this.driver = driver;
	    }

	    // Get the cart badge count
	    public String getCartBadgeCount() {
	        return driver.findElement(cartBadge).getText();
	    }

	    // Add a product to the cart (using the button on the page)
	    public void addProductToCart() {
	        driver.findElement(addToCartButton).click();
	    }

	    // Remove a product from the cart
	    public void removeProductFromCart() {
	        driver.findElement(removeFromCartButton).click();
	    }

	    // Go to the cart page
	    public void goToCart() {
	        driver.findElement(cartIcon).click();
	    }
	}