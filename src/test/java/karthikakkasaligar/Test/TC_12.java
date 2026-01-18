package karthikakkasaligar.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.CartPage;
import karthikakkasaligar.PageObjectModel.ProductsDetailsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_12 extends BaseTest {

	@Test
	public void VerifyProductquantityinCart() {
		SignUPorLoginPage signuporloginpage = homepage.Header.clickonhomepage();
		Assert.assertEquals(homepage.getcurrentcurl(), "https://automationexercise.com/");
		// to scroll down page to product
		homepage.scrolldown();
		// to click on any view product of any product
		ProductsDetailsPage productsdetailspage = homepage.clickonviewdetails();
		// to verify the product details page
		driver.get("https://automationexercise.com/product_details/1");
		Assert.assertEquals(productsdetailspage.getcurrenturl(), "https://automationexercise.com/product_details/1");
		// changeing the qunatity of product
		CartPage cartpage = productsdetailspage.changequantity("4");
		// verifying wether changed quantity is same as user added quantity
    	Assert.assertEquals(cartpage.getproductquantity(0), "4");
	}

}
