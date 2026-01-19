package karthikakkasaligar.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.AccountCreationConfirmationPage;
import karthikakkasaligar.PageObjectModel.InformationPage;
import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_13 extends BaseTest {

	@Test
	public void RegisterwhileCheckout() {
		ProductsPage productspage = homepage.Header.productsbuttonclick();

	
		// to refresh page to unload all advertisements
		productspage.refreshpage();

		// scrolling action
		productspage.scrolldown();

		// adding products to cart 1st element
		productspage.firstproductsselection();
		
		//Adding second product to cart 
		productspage.secondproductselection();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

		//clicking on checkout
		driver.findElement(By.cssSelector("[class*='check_out']")).click();
		
		//clicking on register/login
		driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();
		
		//signup
		SignUPorLoginPage signuporloginpage = new SignUPorLoginPage(driver, wait);
		signuporloginpage.SignUp("Karthik", "karthik"+System.currentTimeMillis() +"@yopmail.com");
		
		//
		InformationPage informationpage = new InformationPage(driver, wait);
		AccountCreationConfirmationPage accountcreationconfirmationpage = informationpage.informationinfo("Test@123","Karthik", "Akkasaligar", "Product Based company", "#78, Beverly hills", "Karnataka", "Hubli", "969658","9590188891");
		
		// Account Creation Page
		accountcreationconfirmationpage.verifyAccountCreated();
		accountcreationconfirmationpage.clickContinue();

		// LoginConfirmationPage
		homepage.Header.loginconfirmation();
		
		driver.findElement(By.cssSelector("[href='/view_cart']")).click();
		driver.findElement(By.cssSelector("[class*='check_out']")).click();
		
	}

}
