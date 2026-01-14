package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_10 extends BaseTest {

	@Test(dataProvider = "getdata")
	public void VerifySubscriptioninhomepage(String url, String Email, String Message) throws InterruptedException
	{
		SignUPorLoginPage signuporloginpage = homepage.Header.clickonhomepage();
	    String URL=	homepage.Header.gethomepageurl();
		Assert.assertEquals(URL, url);
		homepage.Header.VerifySubscription(Email);
		String subscribe=  homepage.Header.VerifySubscriptionmsg();
        Assert.assertEquals(subscribe, Message);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		return new Object[][] {{"https://automationexercise.com/","karthik@gmail.com","You have been successfully subscribed!"}};
		
	}
}
