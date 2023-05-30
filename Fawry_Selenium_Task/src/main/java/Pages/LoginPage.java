package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public static By accountMenu = By.id("nav-link-accountList");
    public static By loginEmail = By.xpath("//input[@id='ap_email']");
    public static By continueLogin = By.xpath("//input[@id='continue']");
    public static By loginPassword = By.id("ap_password");
    public static By signInButton = By.id("signInSubmit");




    public static HomePage login(WebDriver driver) {
        // Create a Properties object
        Properties prop = new Properties();

        // Load the configuration file
        InputStream input;
        try {
            input = new FileInputStream("resources/config.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retrieve the login credentials
        String username = prop.getProperty("email");
        String password = prop.getProperty("password");

        // Enter the username and click the continue button
        driver.findElement(accountMenu).click();
        driver.findElement(loginEmail).sendKeys(username);
        driver.findElement(continueLogin).click();

        // Enter the password and click the sign-in button
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(signInButton).click();

        return new HomePage(driver);
    }
}