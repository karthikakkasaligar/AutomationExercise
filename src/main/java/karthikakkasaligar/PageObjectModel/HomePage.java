package karthikakkasaligar.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthik.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class HomePage extends ReUseableComponentsPage{
	
	WebDriver driver;
	WebDriverWait wait;
	public ReUseableComponentsPage Header;
	
	public HomePage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    Header = new ReUseableComponentsPage(driver, wait);
	}
	
	public void  GoTo() 
	{
		driver.get("https://automationexercise.com/");
		
	}

}
