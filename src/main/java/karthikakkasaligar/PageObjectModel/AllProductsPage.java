package karthikakkasaligar.PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class AllProductsPage extends ReUseableComponentsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AllProductsPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
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
}


