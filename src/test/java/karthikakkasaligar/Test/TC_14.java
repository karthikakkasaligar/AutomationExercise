package karthikakkasaligar.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.CartPage;
import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_14 extends BaseTest{

	@Test
	public void RemoveProductsfromCart() throws InterruptedException
	{
		ProductsPage productspage = homepage.Header.productsbuttonclick();

		// to refresh page to unload all advertisements
		productspage.refreshpage();

		// scrolling action
		productspage.scrolldown();

		// adding products to cart 1st element
		productspage.firstproductsselection();

		// Adding second product to cart
		CartPage cartpage = productspage.secondproductselection();

		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
		
		//to remove the product from cart
		cartpage.removeproductfromcart();
		Assert.assertTrue(driver.findElements(By.id("product-1")).isEmpty(), "Item is still present");
       
        

	}

}
