package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderPage {

        private static WebDriver driver;
        private static By buy=By.id("proceed-to-checkout-action");

        public PlaceOrderPage(WebDriver driver){
            this.driver=driver;
        }
        public static void proceedToBuy (){
            driver.findElement(buy).click();
        }
    }


