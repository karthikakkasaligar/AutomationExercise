package karthikakkasaligar.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class ProductsDetailsPage extends ReUseableComponentsPage{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductsDetailsPage(WebDriver driver,WebDriverWait wait)
	{
		super(driver,wait);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public String getcurrenturl()
	{
	return	driver.getCurrentUrl();
	}
	
	@FindBy(css="[class*='product-information'] h2")
	WebElement ProductName;
	
	@FindBy(xpath="(//div[@class='product-information']/p)[1]")
	WebElement Category;
	
	@FindBy(xpath="(//div[@class='product-information']/p)[2]")
	WebElement Availability;
	
	@FindBy(xpath="(//div[@class='product-information']/p)[3]")
	WebElement Condition;
	
	@FindBy(xpath="(//div[@class='product-information']/p)[4]")
	WebElement Brand;
	
	public boolean isproductnamedispayed()
	{
		return ProductName.isDisplayed();
	}
	
	public boolean isCategorydisplayed() 
	{
	return	Category.isDisplayed();
	}
	
	public boolean isAvailabilitydisplayed()
	{
	 return	Availability.isDisplayed();
	}
	
	public boolean isConditiondisplayed()
	{
	return	Condition.isDisplayed();
	}
	
	public boolean isBranddisplayed()
	{
	  return Brand.isDisplayed();
	}
	
	public String getproductname()
	{
	  return ProductName.getText().trim();
	}
	

	@FindBy(id="quantity")
	WebElement qantity;
	
	@FindBy(css=".btn.btn-default.cart")
	WebElement addtocart;
	
	@FindBy(xpath="(//a[@href='/view_cart'])[2]")
	WebElement viewcart;
	
	public CartPage changequantity(String Quantity) {
		qantity.clear();
		qantity.sendKeys(Quantity);
		addtocart.click();
		viewcart.click();
		CartPage cartpage = new CartPage(driver, wait);
		return cartpage;
	}
	
	
}

