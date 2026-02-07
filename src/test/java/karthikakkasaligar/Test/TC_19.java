package karthikakkasaligar.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_19 extends BaseTest {

	@Test
	 public void View_cart_brand_products() {
		
		ProductsPage productspage = homepage.Header.productsbuttonclick();
		productspage.refreshpage();
		productspage.scrolldown1();
		
		//Verify that Brands are visible on left side bar
		Assert.assertTrue(driver.findElements(By.id("brands_products")).isEmpty(), "Brands are not visible");
		productspage.FirstBrandverification();
		Assert.assertEquals(driver.findElement(By.cssSelector("[class='title text-center']")).getText(), "BRAND - H&M PRODUCTS");
		productspage.SecondBrandverification();
		Assert.assertEquals(driver.findElement(By.cssSelector("[class='title text-center']")).getText(), "BRAND - BIBA PRODUCTS");
		
	}

}
