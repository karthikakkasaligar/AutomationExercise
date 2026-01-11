package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_04 extends BaseTest {

	@Test(dataProvider = "getdata")
	public void LogoutUser(String email1, String password1)
	{
		
		// Login/SignUpPage
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		signuporloginpage.login(email1,password1);
		homepage.Header.logout();
		String LoginText = signuporloginpage.getlogintext();
		Assert.assertEquals("Login to your account", LoginText);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
	return	new Object[][] {{"Test123321@gmail.com","Test@123"}};
	}

}
