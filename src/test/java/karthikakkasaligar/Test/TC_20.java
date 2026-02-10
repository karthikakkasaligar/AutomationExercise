package karthikakkasaligar.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.CartPage;
import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_20 extends BaseTest {

	@Test
	public void SearchProductsandVerifyCartAfterLogin() throws InterruptedException {

		Actions action = new Actions(driver);
		// Navigating to Products Page
		ProductsPage productspage = homepage.Header.productsbuttonclick();

		// redirect to products page to bypass adds
		homepage.redirecttoproductspage();

		// search product
		String text = productspage.searchproduct("T-Shirt");
		Assert.assertEquals(text, "SEARCHED PRODUCTS");

		productspage.scrolldown();

		// To Verify all the products related to search are visible
		productspage.verifyproductsrelatedtodearch();

		// To add searched product to cart
		productspage.addingproductstocart();

		// logging in again
		SignUPorLoginPage signuporloginpage = homepage.SignUporLogin();
		new SignUPorLoginPage(driver, wait);
		signuporloginpage.login("karthikkihtrak@yopmail.com", "Test@123");
		
		//verifying cart items
		CartPage cart =signuporloginpage.clickheadercarticon();
		cart.verifycartproducts();

	}

}
