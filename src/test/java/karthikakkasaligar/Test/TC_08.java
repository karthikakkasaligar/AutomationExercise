package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.PageObjectModel.ProductsDetailsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_08 extends BaseTest {

	@Test
	public void VerifyAllProductsandproductdetailpage() {

		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		ProductsPage allproductspage = homepage.Header.productsbuttonclick();

		// ALL Products Page
		String allproductstext = allproductspage.getallproductstext();
		Assert.assertTrue(allproductstext.equalsIgnoreCase(allproductstext), "text mismatching");
		Assert.assertTrue(allproductspage.getproductssize() > 50, "Products are not visible");
		allproductspage.scrolldown();
		ProductsDetailsPage productsdetailspage = allproductspage.clickviewproduct();

		// Products details page
		String URL = productsdetailspage.getcurrenturl();
		Assert.assertEquals(URL, "https://automationexercise.com/product_details/1");
		Assert.assertTrue(productsdetailspage.isproductnamedispayed(), "Product Name is Not Visible");
		Assert.assertTrue(productsdetailspage.isCategorydisplayed(), "Category is not visible");
		Assert.assertTrue(productsdetailspage.isAvailabilitydisplayed(), "Availability is not visible");
		Assert.assertTrue(productsdetailspage.isConditiondisplayed(), "Condition is not visible");
		Assert.assertTrue(productsdetailspage.isBranddisplayed(), "Brand is not visible");
	}

}
