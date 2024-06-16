package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
	WebDriver driver;
    
    By bullDog=By.xpath("//a[normalize-space()='K9-BD-01']");
    By Angelfish=By.xpath("//a[normalize-space()='FI-SW-01']"); 
    
    
    public CategoryPage(WebDriver driver) {
  	  this.driver=driver;
    }
    
    public void selectBullDog() {
  	  driver.findElement(bullDog).click();
    }
   
    public void selectAngelfish() {
  	  driver.findElement(Angelfish).click();
    }
   
}
