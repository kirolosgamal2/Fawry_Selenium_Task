package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

        public static WebDriver driver;

        public HomePage(WebDriver driver){
            this.driver = driver;
        }

    private static By Menu= By.id("nav-hamburger-menu");
    private static By seeAllButton= By.xpath("//*[@class=\"hmenu-item hmenu-compressed-btn\"]");
    private static By videogameOption= By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/ul/li[11]/a");
    private static By allVideoGames= By.linkText("All Video Games");

    public static VideoGamesPage clickOnVideogame () {
        driver.findElement(Menu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(videogameOption)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(allVideoGames)).click();
        return new VideoGamesPage(driver);
    }





}

