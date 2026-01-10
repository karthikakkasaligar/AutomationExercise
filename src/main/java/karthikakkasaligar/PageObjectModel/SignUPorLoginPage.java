package karthikakkasaligar.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthik.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class SignUPorLoginPage extends ReUseableComponentsPage{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public SignUPorLoginPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	By signuptext=By.xpath("//div[@class='signup-form']/h2");
	
	@FindBy(xpath="//div[@class='signup-form']/h2")
	WebElement Signuptext;
	
	@FindBy(css="[placeholder='Name']")
	WebElement Name;
	
	@FindBy(css="[placeholder='Email Address']:nth-child(3)")
	WebElement Email;
	
	@FindBy(css="[data-qa='signup-button']")
	WebElement SignUpCTA;
	
	public String GetSignuptext()
	{
		waitforwebelementtoappear(signuptext);
		return Signuptext.getText().trim();
	}
	
	public InformationPage SignUp(String name, String email)
	{
		Name.sendKeys(name);
		Email.sendKeys(email);
		SignUpCTA.click();
		InformationPage informationpage = new InformationPage(driver, wait);
		return informationpage;
	}
	

	@FindBy(xpath="//div[@class='login-form']/h2")
	WebElement logintext;
	
	public String getlogintext()
	{
		return logintext.getText().trim(); 
	}
	
	@FindBy(css="[data-qa='login-email']")
	WebElement Email1;
	
	@FindBy(css="[data-qa='login-password']")
	WebElement password;
	
	@FindBy(css="[data-qa='login-button']")
	WebElement click1;
	
	public void login(String email1, String password1) 
	{
		Email1.sendKeys(email1);
		password.sendKeys(password1);
		click1.click();
	}
	
  
	By textwait=By.cssSelector("[action='/login'] p");
	
	@FindBy(css="[action='/login'] p")
	WebElement errorext;
	
	public String geterrortext()
	{
	  
	  waitforwebelementtoappear(textwait);
	  return	errorext.getText().trim();
	}
	
	//String EmailText= driver.findElement(By.cssSelector("")).getText().trim();
	
	@FindBy(css="[action='/signup'] p")
	WebElement EmailText;
	
	By EMAILTEXTWAIT=By.cssSelector("[action='/signup'] p");
	
	public String getemailalreadyexisttext()
	{
		waitforwebelementtoappear(EMAILTEXTWAIT);
	 return	EmailText.getText().trim();
	}


}
