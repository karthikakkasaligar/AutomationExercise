package karthikakkasaligar.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class TestCasePage extends ReUseableComponentsPage{
	
	WebDriver driver;
	public TestCasePage(WebDriver driver, WebDriverWait wait) 
	{
		super(driver, wait);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public String getcurrenyurl()
	{ 
		return driver.getCurrentUrl();
	}
}
