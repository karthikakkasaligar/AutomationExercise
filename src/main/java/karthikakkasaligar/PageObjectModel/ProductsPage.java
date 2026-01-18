package karthikakkasaligar.PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class ProductsPage extends ReUseableComponentsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	
	public ProductsPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
		this.action= new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[class='title text-center']")
	WebElement allproductstext;
	
	public String getallproductstext()
	{
	 return	allproductstext.getText().trim();
	}
	
	@FindBy(xpath="//div/p")
	List<WebElement> products;
	
   public int getproductssize()
   {
	 return   products.size();
   }

   public void scrolldown()
   {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,500);");
   }
   
   @FindBy(css="[class*='nav-justified']")
    List<WebElement> viewproduct;
   
   public ProductsDetailsPage clickviewproduct()
   {
	   viewproduct.get(0).click();
	   ProductsDetailsPage productsdetailspage=new ProductsDetailsPage(driver, wait);
	   return productsdetailspage;
   }
   
   public void refreshpage()
   {
	   driver.navigate().refresh();
	   
   }
   
   
   @FindBy(css=".product-image-wrapper")
   List<WebElement> productstoadd;
    
   @FindBy(css=".btn-block")
   WebElement tocontinue;
   
   @FindBy(xpath="(//a[@href='/view_cart'])[1]")
   WebElement viewcart;

   
   public void firstproductsselection(){
  
	   WebElement product1=  productstoadd.get(0);
	   action.moveToElement(product1).build().perform();  
	   WebElement addtocart=product1.findElement(By.cssSelector("[class*='add-to-cart']"));
	   action.moveToElement(addtocart).click().build().perform();
	   tocontinue.click();
	     
   }
   
   public CartPage secondproductselection() {
	   WebElement product2= productstoadd.get(1);
	   action.moveToElement(product2).build().perform();  
	   WebElement addtocart1=product2.findElement(By.cssSelector("[class*='add-to-cart']"));
	   action.moveToElement(addtocart1).click().build().perform();
	   viewcart.click();
	   CartPage cartpage = new CartPage(driver, wait);
	   return cartpage;
   }
   
  
   
   
  
}


