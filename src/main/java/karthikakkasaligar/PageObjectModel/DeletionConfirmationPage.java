package karthikakkasaligar.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class DeletionConfirmationPage extends ReUseableComponentsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DeletionConfirmationPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[data-qa='account-deleted'] b")
	WebElement accountdeleted;
	
	@FindBy(css="[data-qa='continue-button']")
	WebElement Continue;
	
	public void Deleteconfirmation()
	{
		Assert.assertTrue((accountdeleted).isDisplayed(),"account-deleted is not dispalyed");
		Continue.click();
				
	}


//	driver.findElement(By.cssSelector("")).click();

}
