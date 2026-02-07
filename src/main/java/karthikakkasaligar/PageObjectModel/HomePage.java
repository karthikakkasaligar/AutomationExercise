package karthikakkasaligar.PageObjectModel;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class HomePage extends ReUseableComponentsPage {

	WebDriver driver;
	WebDriverWait wait;
	public ReUseableComponentsPage Header;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Header = new ReUseableComponentsPage(driver, wait);
	}

	public void GoTo() {
		driver.get("https://automationexercise.com");
	}
	
	public String getcurrentcurl() {
	return	driver.getCurrentUrl();
	}
	
	public void scrolldown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600);");
	}
	
	@FindBy(css="[href='/product_details/1']")
	WebElement viewdetails;
	
	public ProductsDetailsPage clickonviewdetails() {
		viewdetails.click();
		ProductsDetailsPage productsdetailspage=new ProductsDetailsPage(driver, wait);
		return productsdetailspage;
	}
	

	@FindBy(css="[href='#Women']")
	WebElement WomenCTA;
	
	@FindBy(css="[href='#Men']")
	WebElement MenCTA;
	
	@FindBy(css="[href='/category_products/7']")
	WebElement WomenCategoryCTA;
	
	@FindBy(css="[href='/category_products/6']")
	WebElement menCategoryCTA;
	
	public void Womencategory() {
		WomenCTA.click();
		WomenCategoryCTA.click();
	}
	
	public void Mencategory() {
		MenCTA.click();
		menCategoryCTA.click();
	}
	
	
	
	

}
