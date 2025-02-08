package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import pages.LoginPage;
import pages.SortingPage;

public class SortingTest {

	public static void main(String[] args) throws InterruptedException {
        // Setup EdgeDriver
        System.setProperty("edgedriver.edge.driver", "F:\\DOWNLOADS\\now edge\\edgedriver_win64\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Step 1: Open SauceDemo and login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSauceDemo();
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Select sorting options and validate product order
        SortingPage sortingPage = new SortingPage(driver);

        // Sorting by Price (low to high)
        sortingPage.selectSortOption("lohi");
        Thread.sleep(2000); // Wait for the sorting to take effect
        validateSorting("Price (low to high)", sortingPage.getProductPrices(), true); // true indicates ascending order

        // Sorting by Price (high to low)
        sortingPage.selectSortOption("hilo");
        Thread.sleep(2000);
        validateSorting("Price (high to low)", sortingPage.getProductPrices(), false); // false indicates descending order

        // Sorting by Name (A to Z)
        sortingPage.selectSortOption("az");
        Thread.sleep(2000);
        validateSorting("Name (A to Z)", sortingPage.getProductList(), true);

        // Sorting by Name (Z to A)
        sortingPage.selectSortOption("za");
        Thread.sleep(2000);
        validateSorting("Name (Z to A)", sortingPage.getProductList(), false);

        // Step 3: Close the browser
        driver.quit();
    }

    // Helper method to validate sorting
    private static void validateSorting(String sortOption, List<WebElement> elements, boolean isAscending) {
        boolean isSorted = true;
        
        // If sorting by price, we need to compare the prices numerically
        if (sortOption.contains("Price")) {
            for (int i = 0; i < elements.size() - 1; i++) {
                double currentPrice = Double.parseDouble(elements.get(i).getText().replace("$", ""));
                double nextPrice = Double.parseDouble(elements.get(i + 1).getText().replace("$", ""));
                
                if (isAscending) {
                    if (currentPrice > nextPrice) {
                        isSorted = false;
                        break;
                    }
                } else {
                    if (currentPrice < nextPrice) {
                        isSorted = false;
                        break;
                    }
                }
            }
        } 
        // If sorting by name, we compare strings alphabetically
        else {
            for (int i = 0; i < elements.size() - 1; i++) {
                String currentName = elements.get(i).getText();
                String nextName = elements.get(i + 1).getText();

                if (isAscending) {
                    if (currentName.compareTo(nextName) > 0) {
                        isSorted = false;
                        break;
                    }
                } else {
                    if (currentName.compareTo(nextName) < 0) {
                        isSorted = false;
                        break;
                    }
                }
            }
        }

        // Output the result
        if (isSorted) {
            System.out.println("Sorting by " + sortOption + " is correct.");
        } else {
            System.out.println("Sorting by " + sortOption + " is incorrect.");
        }
    }
}