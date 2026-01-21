package karthikakkasaligar.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import karthikakkasaligar.ReuseAbleComponentsPage.ReUseableComponentsPage;

public class PaymentsDonePage extends ReUseableComponentsPage {

	WebDriver driver;
	WebDriverWait wait;
	public PaymentsDonePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[data-qa='order-placed']")
	WebElement orderplaced;		
	
	public String orderplacedconfirmation() {
		return orderplaced.getText().trim();
	}
			

}
