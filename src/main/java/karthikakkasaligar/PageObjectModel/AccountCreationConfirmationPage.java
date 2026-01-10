package karthikakkasaligar.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class AccountCreationConfirmationPage extends ReUseableComponentsPage{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AccountCreationConfirmationPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	 By Accountvreatedtext=By.cssSelector("[data-qa='account-created'] b");

	@FindBy(css="[data-qa='continue-button'] ")
	WebElement Continue;
	
	public void verifyAccountCreated()
	{
		WebElement accountcreated= wait.until(ExpectedConditions.visibilityOfElementLocated(Accountvreatedtext));
		Assert.assertTrue(accountcreated.isDisplayed(),"account-created is not displayed");
				
	}
	
	public void clickContinue()
	{
		Continue.click();
	}
	
}



