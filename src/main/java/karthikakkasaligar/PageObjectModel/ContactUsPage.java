package karthikakkasaligar.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class ContactUsPage extends ReUseableComponentsPage {

	WebDriver driver;
	WebDriverWait wait;
	String URLlink="https://automationexercise.com/";
	
	public ContactUsPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class='col-sm-12'] h2 ")
	WebElement Contactustext;
	
	By Contactus=By.cssSelector("[class='col-sm-12'] h2 ");
	
	public String getContactustext()
	{
		waitforwebelementtoappear(Contactus);
		return Contactustext.getText().trim();
	}
	
	@FindBy(css="[class='contact-form'] h2")
	WebElement getInTouchText;
	
	public String getgetInTouchText()
	{
	  return getInTouchText.getText().trim();
	}
	
	@FindBy(css="[name='name']")
	WebElement name;
	
	@FindBy(css="[name='email']")
	WebElement email;
	
	@FindBy(css="[name='subject']")
	WebElement Subject;
	
	@FindBy(css="[name='message']")
	WebElement message;
	
	@FindBy(css="[name='upload_file']")
	WebElement fileupload;
	
	@FindBy(css="[name='submit']")
	WebElement submit;
	
	public void Formfillup(String Name, String Email,String subject, String Message, String path)
	{
		name.sendKeys(Name);
		email.sendKeys(Email);
		Subject.sendKeys(subject);
		message.sendKeys(Message);
		fileupload.sendKeys(path);
		submit.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	@FindBy(css="[class='status alert alert-success']")
	WebElement Sucessmessgae;
	
	public String getSucessmessgaetext()
	{
	 return	Sucessmessgae.getText().trim();
	}
	
	@FindBy(css="[class='btn btn-success']")
	WebElement homebutton;
	
	
    public void NavigatetoHomepage()
    {
    	homebutton.click();
    	wait.until(ExpectedConditions.urlToBe(URLlink));
    }
    
    public String getcurrenturl()
    {
      return driver.getCurrentUrl();
    }

	



}
