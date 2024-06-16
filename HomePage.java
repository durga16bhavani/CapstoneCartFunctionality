package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
     WebDriver driver;
     
     By cartIcon=By.name("img_cart");
     
     public HomePage(WebDriver driver) {
    	 this.driver=driver;
     }
     
     public void clickOnCartIcon() {
    	 driver.findElement(cartIcon).click();
     }  
}
