package karthik.ReuseAbleComponentsPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import karthikakkasaligar.PageObjectModel.DeletionConfirmationPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;

public class ReUseableComponentsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	public ReUseableComponentsPage(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[href='/login']")
	WebElement SignUporLogin;
	
	
	public SignUPorLoginPage SignUporLogin() 
	{
		SignUporLogin.click();	
		SignUPorLoginPage signuporloginpage = new SignUPorLoginPage(driver, null);
		return signuporloginpage;
	}
	
	public void waitforwebelementtoappear(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	@FindBy(xpath=("//*[text()=' Logged in as ']"))
			WebElement Loggedin;
	
	@FindBy(xpath=("//*[text()='Karthik']"))
	WebElement name;
	
	////	driver.findElement(By.cssSelector("")).click();
	 @FindBy(css="[href='/delete_account']")
	 WebElement deleteaccount;
	 
	 @FindBy(css="[data-qa='account-deleted'] b")
	 WebElement deletecta;
	
	
	public void loginconfirmation()
	{
		Assert.assertTrue(Loggedin.isDisplayed(),"Logged in as is not displayed");
		Assert.assertTrue(name.isDisplayed(),"Karthik is not displayed");	
	}
	
	
	
	public DeletionConfirmationPage deleaccountcta()
	{
		deleteaccount.click();
		DeletionConfirmationPage deletionconfirmationPage = new DeletionConfirmationPage(driver, wait);
		return deletionconfirmationPage;
	}
	
	
	@FindBy(css="[href='/logout']")
	WebElement Logout;
	
	public void logout()
	{
		Logout.click();
	}
	


	

}
