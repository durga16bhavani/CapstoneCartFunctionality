package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage{
	WebDriver driver;
	  By maleAdultBullDog=By.xpath("//tbody/tr[2]/td[5]/a[1]");
	  By femalePuppyBullDog=By.xpath("//tbody/tr[3]/td[5]/a[1]");
	  By largeAngelfish=By.xpath("//tbody/tr[2]/td[5]/a[1]");
	  By smallAngelfish=By.xpath("//tbody/tr[3]/td[5]/a[1]");
	  
	  public ProductsPage(WebDriver driver) {
		  this.driver=driver;
	  }
	  
	  public void addMaleAdultBullDog() {
		  driver.findElement(maleAdultBullDog).click();
	  }
	  public void addFemalePuppyBullDog() {
		  driver.findElement(femalePuppyBullDog).click();
	  }
	  
	  public void addLargeAngelfish() {
		  driver.findElement(largeAngelfish).click();
	  }
	  public void addSmallAngelfish() {
		  driver.findElement(smallAngelfish).click();
	  }

}
