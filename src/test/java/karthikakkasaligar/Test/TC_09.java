package karthikakkasaligar.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.PageObjectModel.ProductsDetailsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_09 extends BaseTest {

	@Test(dataProvider = "getdata")
	public void SearchProduct(String productname)
	{
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		ProductsPage productspage = homepage.Header.productsbuttonclick();
		productspage.scrolldown();
		

		// ALL Products Page
		String allproductstext = productspage.getallproductstext();
		Assert.assertTrue(allproductstext.equalsIgnoreCase(allproductstext), "text mismatching");
		driver.findElement(By.id("search_product")).sendKeys(productname);
		driver.findElement(By.id("submit_search")).click();
		productspage.scrolldown();
		ProductsDetailsPage productsdetailspage = productspage.clickviewproduct();
		 String Productname= productsdetailspage.getproductname();
	    Assert.assertEquals(Productname, productname);
	}
	
	@DataProvider
	public  Object[][]  getdata() 
	{
		return new Object[][] {{"Rust Red Linen Saree"}};
	}

}
