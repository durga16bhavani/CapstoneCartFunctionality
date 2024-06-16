package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
   WebDriver driver;
   
   By fish=By.linkText("Fish");
   By dogs=By.linkText("Dogs");
   
   public CartPage(WebDriver driver) {
  	 this.driver=driver;
   }
   
   public void clickOnFishCategory(){
	   driver.findElement(fish).click();
   }
   
   public void clickOnDogsCategory(){
	   driver.findElement(dogs).click();  
   }
 
}