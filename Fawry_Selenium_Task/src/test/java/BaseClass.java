import Pages.HomePage;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class BaseClass {

    // Declare WebDriver instance
    public static WebDriver driver;
    protected HomePage homePage;

    // Set up the driver before running tests
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "resources/geckodriver.exe");
        driver = new FirefoxDriver();
//        homePage= new HomePage(driver);
        goHome();
        System.out.println(driver.getTitle());
    }
    // Navigate to the home page before each test
    @BeforeMethod
    public void goHome(){
        driver.get("https://www.amazon.eg/?language=en_AE");
    }
    // Quit the driver after running tests
//    @AfterClass
//    public void exit(){
//        FluentWait wait=new FluentWait(driver);
//        wait.withTimeout(Duration.ofSeconds(3));
//        driver.quit();
//    }
    // Take a screenshot if a test fails
    @AfterMethod
    public void recordFailure(ITestResult result){
        if (ITestResult.SUCCESS==result.getStatus()){
            var camera=(TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void clickElement(By newBy) {
        driver.findElement(newBy).click();
    }
}