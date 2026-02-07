package karthikakkasaligar.PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class CartPage extends ReUseableComponentsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	public CartPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(css=".cart_price")
	   List<WebElement> cartproductsprice;
	   
	   public String getproductprice(int index) {
		  return cartproductsprice.get(index).getText().trim();
	   }
	   
	   @FindBy(css="[class='cart_description'] a")
	   List<WebElement> productprice;
	   
	   public String getproductverification(int index) {
		return  productprice.get(index).getText().trim();
	   }
	      
	   @FindBy(css=".cart_quantity")
	   List<WebElement> productquantity;
	   
	   public String getproductquantity(int index) {
		  return   productquantity.get(index).getText().trim();
	   }
	     
	   @FindBy(css=".cart_total")
	   List<WebElement> totalprice;
	   
	   public String getproducttotalprice(int index) {
		 return  totalprice.get(index).getText().trim();
	   }
	
	   @FindBy(css="[class*='check_out']")
	   WebElement cartcheckout;
	   
	   public checkoutpage clickoncartcheckout() {
		   cartcheckout.click(); 
		   checkoutpage checkout=new checkoutpage(driver, wait);
		   return checkout;
	   }
	   
	   @FindBy(xpath="(//a[@href='/login'])[2]")
	   WebElement registerorlogin;
	   
	   public void clickonregisterorlogin() {
		   registerorlogin.click();
	   }
	  
	   public void checkoutt() {
		   cartcheckout.click();
	   }
	
	   //driver.findElements(By.cssSelector("[class='cart_quantity_delete']")).get(0).click();
	   @FindBy(css="[class='cart_quantity_delete']")
	   List<WebElement> cartquantity;
	   
	   By productid=By.id("product-1");
	   
	   public void removeproductfromcart() {
		   cartquantity.get(0).click();
		   waituntilinvisibilityOfElementLocated(productid);
	   }

}
