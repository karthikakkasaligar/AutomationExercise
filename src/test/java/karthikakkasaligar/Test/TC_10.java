package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_10 extends BaseTest {

	@Test
	public void VerifySubscriptioninhomepage() throws InterruptedException
	{
		SignUPorLoginPage signuporloginpage = homepage.Header.clickonhomepage();
	    String URL=	homepage.Header.gethomepageurl();
		Assert.assertEquals(URL, "https://automationexercise.com/");
		homepage.Header.VerifySubscription("karthik@gmail.com");
		String subscribe=  homepage.Header.VerifySubscriptionmsg();
        Assert.assertEquals(subscribe, "You have been successfully subscribed!");
	}

}
