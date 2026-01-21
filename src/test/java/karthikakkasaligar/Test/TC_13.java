package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.AccountCreationConfirmationPage;
import karthikakkasaligar.PageObjectModel.CartPage;
import karthikakkasaligar.PageObjectModel.InformationPage;
import karthikakkasaligar.PageObjectModel.PaymentsDonePage;
import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.PageObjectModel.checkoutpage;
import karthikakkasaligar.PageObjectModel.paymentpage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_13 extends BaseTest {

	@Test
	public void RegisterwhileCheckout() {
		ProductsPage productspage = homepage.Header.productsbuttonclick();

		// to refresh page to unload all advertisements
		productspage.refreshpage();

		// scrolling action
		productspage.scrolldown();

		// adding products to cart 1st element
		productspage.firstproductsselection();

		// Adding second product to cart
		productspage.secondproductselection();

		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

		// clicking on checkout
		CartPage cartpage = new CartPage(driver, wait);
		cartpage.checkoutt();
		cartpage.clickonregisterorlogin();

		// signup
		SignUPorLoginPage signuporloginpage = new SignUPorLoginPage(driver, wait);
		signuporloginpage.SignUp("Karthik", "karthik" + System.currentTimeMillis() + "@yopmail.com");

		//
		InformationPage informationpage = new InformationPage(driver, wait);
		AccountCreationConfirmationPage accountcreationconfirmationpage = informationpage.informationinfo("Test@123",
				"Karthik", "Akkasaligar", "Product Based company", "#78, Beverly hills", "Karnataka", "Hubli", "969658",
				"9590188891");

		// Account Creation Page
		accountcreationconfirmationpage.verifyAccountCreated();
		accountcreationconfirmationpage.clickContinue();

		// LoginConfirmationPage
		homepage.Header.loginconfirmation();

		// to click on cart icon after login
		homepage.Header.clickheadercarticon();

		// cart page
		checkoutpage checkout = cartpage.clickoncartcheckout();

		// checkoutpage
		Assert.assertEquals(checkout.getgetphonenumber(), "9590188891");
		Assert.assertEquals(checkout.itemdiscrption(0), "Blue Top");
		Assert.assertEquals(checkout.itemdiscrption(1), "Men Tshirt");
		paymentpage payments = checkout.checkout("Heyy");

		// payment page
		homepage.Header.scrolldown();
		PaymentsDonePage PaymentsDone =  payments.getcardetails("karthik", "123456789", "123", "jan", "1997");
		Assert.assertEquals(PaymentsDone.orderplacedconfirmation(), "ORDER PLACED!");

	}

}
