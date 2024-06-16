package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	    WebDriver driver;
	    
		By signin=By.xpath("//a[normalize-space()='Sign In']");
		By username=By.xpath("//input[@name='username']");
		By pwd=By.xpath("//input[@name='password']");
		By login=By.xpath("//button[normalize-space()='Login']");
		
		public SignInPage(WebDriver driver) {
			this.driver=driver;
		}
		
		public void clickOnSignIn() {
			driver.findElement(signin).click();
		}
		
		public void enterUsername() {
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys("Jpetstore");	
		}
		
		public void enterPassword() {
			driver.findElement(pwd).clear();
			driver.findElement(pwd).sendKeys("jpet@123");	
		}
		
		public void clickLogin() {
			driver.findElement(login).click();
				
		}
		
}
