package stepDef;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import JPetStoreAutomation.Screenshot;
import cart.CartPage;
import cart.CategoryPage;
import cart.HomePage;
import cart.ProductsPage;
import cart.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinition {
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    CartPage cartPage;
    CategoryPage categoryPage;
    ProductsPage  productsPage;
    Screenshot screenshot;
	private WebDriver WebDriver;
	
    @Given("The user is on the JPetStore SignInpage")
    public void userIsOnTheJPetStoreSignInpage() throws InterruptedException{
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://jpetstore.aspectran.com/");
    	Thread.sleep(2000);
    	signInPage=new SignInPage(driver);
    }
    
    @When("The user signs in with username and password")
    public void userSignsInWithUsernameAndPassword()throws InterruptedException {
    	signInPage.clickOnSignIn();	
    	Thread.sleep(2000);
    	signInPage.enterUsername();
    	signInPage.enterPassword();
    	Thread.sleep(2000);
    	signInPage.clickLogin();	
    }
    
    @And("The user clicks on the cart image")
    public void clicksOnTheCartImage() throws InterruptedException, IOException {
    	homePage=new HomePage(driver);
    	screenshot=new Screenshot(driver);
    	Thread.sleep(2000);
        homePage.clickOnCartIcon(); 
        screenshot.ScreenShots();
    }
    
    @Then("The user should be redirected to the view cart page")
    public void redirectedToViewCartPage() {
    	String currentUrl=driver.getCurrentUrl();
    	assert currentUrl.contains("viewCart");
    }
    
    @And("The cart page display Your cart is empty message when there is no items in cart")
    public void cartIsEmptyMessage() {
    	 WebElement emptyCartMsg=driver.findElement(By.xpath("//td[normalize-space()='Your cart is empty.']"));
    	 String actualMsg=emptyCartMsg.getText();
    	 String expectedmsg="Your cart is empty.";
    	 assertEquals(expectedmsg,actualMsg);
    }
    
    @When("The user clicks on Fish")
    public void clicksOnFish() throws InterruptedException{
    	cartPage=new CartPage(driver);
    	Thread.sleep(2000);
    	cartPage.clickOnFishCategory();
    }
    
    @Then("The user should redirected to the fish category page")
    public void  redirectedToFishCategory() {
    	String currentUrl=driver.getCurrentUrl();
    	assert currentUrl.contains("FISH");
    }
    
    @When("The user clicks on product id")
    public void clicksOnProductId() throws InterruptedException{
        categoryPage=new CategoryPage(driver);
    	Thread.sleep(2000);
    	categoryPage.selectAngelfish();
    	
    }
    
    @Then("The user should be redirected to the items page of that product")
    public void redirectedToItemsPage() {
    	String currentUrl=driver.getCurrentUrl();
    	assert currentUrl.contains("FI-SW-01");
    }
    
    @When("The user clicks on add to cart button which is next to item price")
    public void clickOnAddToCart() throws InterruptedException, IOException {
    	productsPage=new ProductsPage(driver);
    	Thread.sleep(2000);
    	productsPage.addLargeAngelfish();
    	screenshot.ScreenShots();
    	
    }
    
    @Then("The product should be added to the cart and redirected to view cart page")
    public void redirectedToViewCart() throws InterruptedException{
    	String currentUrl=driver.getCurrentUrl();
    	assert currentUrl.contains("viewCart");
    	Thread.sleep(2000);
    	cartPage.clickOnFishCategory();
    	Thread.sleep(2000);
    	categoryPage.selectAngelfish();
    	Thread.sleep(2000);
    	productsPage.addSmallAngelfish();
    	Thread.sleep(2000);
    	cartPage.clickOnFishCategory();
    	Thread.sleep(2000);
    	categoryPage.selectAngelfish();
    	Thread.sleep(2000);
    	productsPage.addSmallAngelfish();
    	Thread.sleep(2000);
    	WebElement remove=driver.findElement(By.cssSelector(".button[hx-post='/cart/removeItemFromCart?cartItem=EST-1']"));
        remove.click();
        Thread.sleep(2000);
        WebElement removeall=driver.findElement(By.cssSelector(".button[hx-post='/cart/removeAllItemsFromCart']"));
        removeall.click();
    }
    
   
    @And("Add items to cart again")
    public void addItemsAgain() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	cartPage.clickOnDogsCategory();
    	categoryPage=new CategoryPage(driver);
    	Thread.sleep(2000);
    	categoryPage.selectBullDog();
    	
    	productsPage=new ProductsPage(driver);
    	Thread.sleep(2000);
    	productsPage.addFemalePuppyBullDog();
    	Thread.sleep(2000);
    	cartPage.clickOnDogsCategory();
    	Thread.sleep(2000);
    	categoryPage.selectBullDog();
    	Thread.sleep(2000);
    	productsPage.addFemalePuppyBullDog();
    	Thread.sleep(2000);
    	cartPage.clickOnDogsCategory();
    	Thread.sleep(2000);
    	categoryPage.selectBullDog();
    	Thread.sleep(2000);
    	productsPage.addMaleAdultBullDog();
    		
    }
   
    @And("set quantity of item and click updateCart")
    public void increaseQuantity() throws InterruptedException {
    	WebElement item1=driver.findElement(By.xpath("//input[@type='number'][@value='2']"));
    	item1.clear();
    	item1.sendKeys("5");
    	Thread.sleep(2000);
    	WebElement item2=driver.findElement(By.xpath("//input[@type='number'][@value='1']"));
    	item2.clear();
    	item2.sendKeys("0");
    	Thread.sleep(2000);
    	WebElement updateCart=driver.findElement(By.xpath("//button[normalize-space()='Update Cart']"));
    	updateCart.click();
    }
    @Then("Click on Check out process button")
    public void checkOutProcess() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//a[normalize-space()='Proceed to Checkout']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
    	Thread.sleep(2000);
    	WebElement orderMsg=driver.findElement(By.xpath("//p[normalize-space()='Thank you, your order has been submitted.']"));
    	String actualMsg=orderMsg.getText();
    	String expectedMsg="Thank you, your order has been submitted.";
    	assertEquals(expectedMsg,actualMsg);
    	
    }
    @And("Close Browser")
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.close();
    }
}
