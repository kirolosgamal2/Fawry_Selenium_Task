// Import necessary packages
package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
// Create a class for adding items to cart
public class AddtoCartPage {
    private static WebDriver driver;
    private static By addbutton=By.id("add-to-cart-button");
    private static By checkout=By.id("proceed-to-checkout-action");
    private static By cartbutton=By.id("nav-cart");
    private static By prices=By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < 15000]/ancestor::div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']");
    // Constructor to initialize driver
    public AddtoCartPage(WebDriver driver){
        this.driver=driver;
    }
    // Method to add items to cart
    public static void additemtocart() {
        // Find all product links on page
        List<WebElement> items = driver.findElements(prices);
        List<String> productLinks = new ArrayList<>();
        for (WebElement item : items) {
            WebElement productLink = item.findElement(By.tagName("a"));
            productLinks.add(productLink.getAttribute("href"));
        }
        // Add each item to cart
        for (String link : productLinks) {
            driver.get(link); // Navigate to product page
            driver.findElement(addbutton).click(); // Click add to cart button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Wait for cart count to update
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nav-cart-count"), "1"));
            driver.navigate().back(); // Navigate back to product list
            driver.navigate().back();
        }
    }
    // Method to check cart and proceed to checkout
    public static PlaceOrderPage Checkmycart(){
        driver.findElement(cartbutton).click(); // Click cart button
        return new PlaceOrderPage(driver); // Return PlaceOrderPage object
    }
}