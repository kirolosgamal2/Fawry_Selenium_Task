package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoGamesPage {
    public static WebDriver driver;

    public VideoGamesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static By freeShipping=By.xpath("(//label[input[@type='checkbox'] and i[@class='a-icon a-icon-checkbox'] and span[@class='a-label a-checkbox-label']])[1]");
    public static By newCondition =By.linkText("New");
    public static By sortBy =By.xpath("//span[@class='a-dropdown-prompt' and text()='Featured']");


//This method adds a new filter to the current page. It waits for the "free shipping" element to be clickable and then clicks it. It also waits for the "new condition" element to be clickable and then clicks it.
    public static VideoGamesPage addFilters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement newConditionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newCondition));
        newConditionElement.click();
        return new VideoGamesPage(driver);

    }

    public static AddtoCartPage FromHightoLowCondition(String choose){
        Select select=new Select(driver.findElement(sortBy));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        select.selectByVisibleText(choose);
        return new AddtoCartPage(driver);

    }
}
