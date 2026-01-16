package karthikakkasaligar.ReuseAbleComponentsPage;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import karthikakkasaligar.PageObjectModel.AllProductsPage;
import karthikakkasaligar.PageObjectModel.ContactUsPage;
import karthikakkasaligar.PageObjectModel.DeletionConfirmationPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.PageObjectModel.TestCasePage;

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
	
	@FindBy(xpath="(//a[@href='/'])[2]")
	WebElement Homepage;
	
	public SignUPorLoginPage clickonhomepage()
	{
		Homepage.click();
		return null;
	}
	
	@FindBy(css="[href='/products']")
	WebElement productsclick;
	
	public void clickonproducts()
	{
		productsclick.click();
		
	}
	
	
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
	
	
	@FindBy(css="[href='/contact_us']")
	WebElement contactus;
	
	public ContactUsPage contactus()
	{
		contactus.click();
		ContactUsPage contactuspage=new ContactUsPage(driver, wait);
		return contactuspage;
	}
	
	//driver.findElement(By.cssSelector("")).click();
	@FindBy(css="[href='/test_cases']")
	WebElement TestCaseButton;
	
	public TestCasePage clickTestCaseButton()
	{
		TestCaseButton.click();
		TestCasePage testcasepage=new TestCasePage(driver,wait);
		return testcasepage;
	}
	
	//driver.findElement(By.cssSelector("")).click();
	@FindBy(css="[href='/products']")
	WebElement Productsbutton;
	
	public AllProductsPage productsbuttonclick()
	{
		Productsbutton.click();
		AllProductsPage allproductspage=new AllProductsPage(driver,wait);
		return allproductspage;
	}
	
	public String gethomepageurl()
	{
	  return driver.getCurrentUrl();
	}

	@FindBy(id="susbscribe_email")
	WebElement susbscribeemail;
	
	@FindBy(id="subscribe")
	WebElement subscribeCTA;
	
	@FindBy(id="success-subscribe")
	WebElement successsubscribemsg;
	
	public void VerifySubscription(String email)
	{
		susbscribeemail.sendKeys(email);
		subscribeCTA.click();
	}
	
	public String VerifySubscriptionmsg()
	{
	  return successsubscribemsg.getText().trim();
	}

}
