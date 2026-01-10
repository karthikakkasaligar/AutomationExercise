package karthikakkasaligar.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class InformationPage extends ReUseableComponentsPage{
	
	WebDriver driver;
	WebDriverWait wait;
	public InformationPage (WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	By accountinfo=By.xpath("//div[@class='login-form']/h2");
	
	@FindBy(xpath="//div[@class='login-form']/h2")
	WebElement accountinfotext;
	
	@FindBy(id="id_gender1")
	WebElement gender;
	
	@FindBy(id="password")
	WebElement passcode;
	
	By daysdropdown=By.id("days");
	By monthsdropdown=By.id("months");
	By yearsdropdown=By.id("years");
	
	@FindBy(id="newsletter")
	WebElement checkbox;
	
	@FindBy(id="optin")
	WebElement checkbox2;
	
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="last_name")
	WebElement lastname;
	
	@FindBy(id="company")
	WebElement company;
	@FindBy(id="address1")
	WebElement address1;
	By Country=By.id("country");
	@FindBy(id="state")
	WebElement state;
	@FindBy(id="city")
	WebElement city;
	@FindBy(id="zipcode")
	WebElement zipcode;
	@FindBy(id="mobile_number")
	WebElement mobile_number;
	@FindBy(css="[data-qa='create-account']")
	WebElement Submit;
	
	
	
	public String getaccountinfotext()
	{
		waitforwebelementtoappear(accountinfo);
		 return accountinfotext.getText().trim();
	}
	
	public AccountCreationConfirmationPage informationinfo(String password ,String name, String Lastname, String Company, String address, String State , String City , String Zipcode,String mobilenumber)
	{
		gender.click();
		passcode.sendKeys(password);
		WebElement days = driver.findElement(daysdropdown);
		Select daydp = new Select(days);
		daydp.selectByContainsVisibleText("3");
		WebElement months = driver.findElement(monthsdropdown);
		Select monthsdp = new Select(months);
		monthsdp.selectByContainsVisibleText("December");
		WebElement years = driver.findElement(yearsdropdown);
		Select yearsdp = new Select(years);
		yearsdp.selectByContainsVisibleText("1997");
		checkbox.click();
		checkbox2.click();
		firstname.sendKeys(name);
		lastname.sendKeys(Lastname);
		company.sendKeys(Company);
		address1.sendKeys(address);
		WebElement country = driver.findElement(Country);
		Select countrydp = new Select(country);
		countrydp.selectByContainsVisibleText("India");
		state.sendKeys(State);
		city.sendKeys(City);
		zipcode.sendKeys(Zipcode);
		mobile_number.sendKeys(mobilenumber);
		Submit.click();
		AccountCreationConfirmationPage accountcreationconfirmationpage = new AccountCreationConfirmationPage(driver, wait);
		return accountcreationconfirmationpage;
	}
	
}










