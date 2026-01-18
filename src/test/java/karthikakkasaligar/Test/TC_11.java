package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.CartPage;
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
		CartPage cartpage = productspage.secondproductselection();


		// to Verify both products are added to Cart
		Assert.assertEquals(cartpage.getproductverification(0), "Blue Top");
		Assert.assertEquals(cartpage.getproductverification(1), "Men Tshirt");

		// to check the price of both products
		Assert.assertEquals(cartpage.getproductprice(0), "Rs. 500");
		Assert.assertEquals(cartpage.getproductprice(1), "Rs. 400");

		// to check the quantity of both products
		Assert.assertEquals(cartpage.getproductquantity(0), "1");
		Assert.assertEquals(cartpage.getproductquantity(1), "1");

		// to check the total price of both products
		Assert.assertEquals(cartpage.getproducttotalprice(0), "Rs. 500");
		Assert.assertEquals(cartpage.getproducttotalprice(1), "Rs. 400");

	}

}
