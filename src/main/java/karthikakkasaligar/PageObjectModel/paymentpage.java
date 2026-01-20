package karthikakkasaligar.PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class paymentpage extends ReUseableComponentsPage {

	WebDriver driver;
	WebDriverWait wait;
	public paymentpage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver=driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-control")
	List<WebElement> cardetails;
	
	//By waitformessage=By.className("alert-success alert");
	
	@FindBy(css= "alert-success.alert")
	WebElement message;
	
	public void getcardetails(String name, String cardnumber, String cvc, String expiry, String year) {
		cardetails.get(0).sendKeys(name);
		cardetails.get(1).sendKeys(cardnumber);
		cardetails.get(2).sendKeys(cvc);
		cardetails.get(3).sendKeys(expiry);
		cardetails.get(4).sendKeys(year);
		cardetails.get(5).click();
	}
	
	public String getsuccessmessage() {
	// waitforwebelementtoappear(waitformessage);
	  return message.getText().trim();
	}

}
