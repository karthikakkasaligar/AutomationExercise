package karthikakkasaligar.PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class CartPage extends ReUseableComponentsPage {
	
	WebDriver driver;
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
	

}
