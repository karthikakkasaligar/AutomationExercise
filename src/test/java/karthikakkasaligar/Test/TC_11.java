package karthikakkasaligar.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_11 extends BaseTest {

	@Test
	public void AddProductstocart() throws InterruptedException {
			
		//link opening code
		ProductsPage signuporloginpage=homepage.Header.productsbuttonclick();
		
		//object creation
		ProductsPage productspage = new ProductsPage(driver , wait);
		
		//to refresh page to unload all advertisements
		productspage.refreshpage();
	
		//scrolling action
		productspage.scrolldown();
			
		// adding products to cart 1st element
		productspage.firstproductsselection();
		
		// adding products to cart 2nd element
		productspage.secondproductselection();
		
	    // to Verify both products are added to Cart
		String Product1name=  productspage.firstproductverification();
		Assert.assertEquals(Product1name, "Blue Top");
		
	    String Product2name= productspage.secondproductverification();
		Assert.assertEquals(Product2name, "Men Tshirt");
		
		
		// to check the price of both products
		String price1= productspage.firstproductprice();
		Assert.assertEquals(price1, "Rs. 500");
		String price2= productspage.secondproductprice();
		Assert.assertEquals(price2, "Rs. 400");
		
		//to check the quantity of both products	
		String quantity1=  productspage.firstproductquantity();
		Assert.assertEquals(quantity1, "1");
	    String	quantity2= productspage.secondproductquantity();
		Assert.assertEquals(quantity2, "1");
		
		//to check the total price of both products
	    String total1= 	productspage.firstproducttotalprice();
		Assert.assertEquals(total1, "Rs. 500");
		String total2= productspage.secondproducttotalprice();
		Assert.assertEquals(total2, "Rs. 400");
		
		
		
		



	}

}
