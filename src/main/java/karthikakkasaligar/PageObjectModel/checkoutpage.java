package karthikakkasaligar.PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class checkoutpage extends ReUseableComponentsPage {

	WebDriver driver;
	WebDriverWait wait;
	public checkoutpage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(css=".address_phone")
	   WebElement getphonenumber;
	   
	   public String getgetphonenumber() {
		return   getphonenumber.getText().trim();
	   }
	   
	   @FindBy(css=".cart_description h4")
	   List<WebElement> items;
	   
	   public String itemdiscrption(int index) {
		  return items.get(index).getText().trim();
	   }
	   
	   @FindBy(css="[name='message']")
	   WebElement message;
	   
	   @FindBy(css="[href='/payment']")
	   WebElement placeorder;
	   
	   public paymentpage checkout(String msg) {
		   message.sendKeys(msg);
		   placeorder.click();
		   paymentpage payments = new paymentpage(driver, wait);
		   return payments;
	   }

}
