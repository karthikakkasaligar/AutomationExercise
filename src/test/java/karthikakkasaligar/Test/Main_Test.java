package karthikakkasaligar.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Main_Test {

	public static void main(String[] args) {
		
		
		// Base Page
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		driver.findElement(By.cssSelector("[href='/login']")).click();

		// Login/SgnUpPage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='signup-form']/h2")));
		String usersignup = driver.findElement(By.xpath("//div[@class='signup-form']/h2")).getText().trim();
		Assert.assertEquals("New User Signup!", usersignup);
		driver.findElement(By.cssSelector("[placeholder='Name']")).sendKeys("Karthik");
		driver.findElement(By.cssSelector("[placeholder='Email Address']:nth-child(3)")).sendKeys("karthik" + System.currentTimeMillis() + "@yopmail.com");	
		driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

		// Information Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-form']/h2")));
		String accountinfotext = driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText().trim();
		Assert.assertTrue(accountinfotext.equalsIgnoreCase("Enter Account Information"),"Account information Text is Mismatched");
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("Test@123");
		WebElement days = driver.findElement(By.id("days"));
		Select daydp=new Select(days);
		daydp.selectByContainsVisibleText("3"); 
		WebElement months = driver.findElement(By.id("months"));
		Select monthsdp=new Select(months);
		monthsdp.selectByContainsVisibleText("December");
		WebElement years = driver.findElement(By.id("years"));
		Select yearsdp=new Select(years);
		yearsdp.selectByContainsVisibleText("1997");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		//Address information
		driver.findElement(By.id("first_name")).sendKeys("Karthik");
		driver.findElement(By.id("last_name")).sendKeys("A");
		driver.findElement(By.id("company")).sendKeys("Aukath se bahar");
		driver.findElement(By.id("address1")).sendKeys("#78, Beverly hills");
		WebElement country= driver.findElement(By.id("country"));
		Select countrydp=new Select(country);
		countrydp.selectByContainsVisibleText("India");
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		driver.findElement(By.id("city")).sendKeys("Hubli");
		driver.findElement(By.id("zipcode")).sendKeys("969658");
		driver.findElement(By.id("mobile_number")).sendKeys("9590188891");
		driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
		
		//Account Creation Page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='account-created'] b")));
		Assert.assertTrue(driver.findElement(By.cssSelector("[data-qa='account-created'] b")).isDisplayed(),"account-created is not displayed");
		driver.findElement(By.cssSelector("[data-qa='continue-button'] ")).click();
		
		//Account Deletion page
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed(),"Logged in as is not displayed");
	    Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Karthik']")).isDisplayed(),"Karthik is not displayed");
		
	    // Deletion confirmation page
	    driver.findElement(By.cssSelector("[href='/delete_account']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("[data-qa='account-deleted'] b")).isDisplayed(),"account-deleted is not dispalyed");
		driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
		driver.quit();
	}

}
