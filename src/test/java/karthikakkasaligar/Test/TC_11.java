package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_11 extends BaseTest {

	@Test
	public void AddProductstocart() {

		// link opening code
		ProductsPage signuporloginpage = homepage.Header.productsbuttonclick();

		// object creation
		ProductsPage productspage = new ProductsPage(driver, wait);

		// to refresh page to unload all advertisements
		productspage.refreshpage();

		// scrolling action
		productspage.scrolldown();

		// adding products to cart 1st element
		productspage.firstproductsselection();

		// adding products to cart 2nd element
		productspage.secondproductselection();

		// to Verify both products are added to Cart
		Assert.assertEquals(productspage.getproductverification(0), "Blue Top");
		Assert.assertEquals(productspage.getproductverification(1), "Men Tshirt");

		// to check the price of both products
		Assert.assertEquals(productspage.getproductprice(0), "Rs. 500");
		Assert.assertEquals(productspage.getproductprice(1), "Rs. 400");

		// to check the quantity of both products
		Assert.assertEquals(productspage.getproductquantity(0), "1");
		Assert.assertEquals(productspage.getproductquantity(1), "1");

		// to check the total price of both products
		Assert.assertEquals(productspage.getproducttotalprice(0), "Rs. 500");
		Assert.assertEquals(productspage.getproducttotalprice(1), "Rs. 400");

	}

}
