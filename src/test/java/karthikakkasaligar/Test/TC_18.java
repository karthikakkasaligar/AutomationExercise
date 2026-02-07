package karthikakkasaligar.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_18 extends BaseTest {

	@Test
	public void View_Category_Products() {

		// Home Page Opening
		SignUPorLoginPage signuporloginpage = homepage.Header.clickonhomepage();
		homepage.scrolldown();

		// categories are visible on left side bar
		Assert.assertTrue(driver.findElements(By.id("categories are visible on left side bar")).isEmpty(),
				"categories are not visible");

		// to click on women category & Verification
		homepage.Womencategory();
		Assert.assertEquals(driver.findElement(By.cssSelector("[class='title text-center']")).getText(),
				"WOMEN - SAREE PRODUCTS");

		//// to click on Men category & Verification
		homepage.Mencategory();
		Assert.assertEquals(driver.findElement(By.cssSelector("[class='title text-center']")).getText(),
				"MEN - JEANS PRODUCTS");
	}

}
