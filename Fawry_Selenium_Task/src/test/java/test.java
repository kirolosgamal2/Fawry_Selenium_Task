import Pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class test extends BaseClass{

    @Test
    public void test(){
        LoginPage.login(driver);
        HomePage.clickOnVideogame();
        VideoGamesPage.addFilters();
        VideoGamesPage.FromHightoLowCondition("Price: High to Low");
        AddtoCartPage.additemtocart();
        AddtoCartPage.Checkmycart();
        PlaceOrderPage.proceedToBuy();
    }
}
