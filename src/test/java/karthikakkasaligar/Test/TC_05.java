package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_05 extends BaseTest{

	@Test(dataProvider = "getdata")
	public void RegisterUserwithexistingemail(String name, String email)
	{
		
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		String usersignuptext = signuporloginpage.GetSignuptext();
		Assert.assertEquals("New User Signup!", usersignuptext);
		signuporloginpage.SignUp(name,email);
		String EmailText= signuporloginpage.getemailalreadyexisttext();
		Assert.assertEquals(EmailText,"Email Address already exist!");
	}
	
	@DataProvider
	public Object[][] getdata()
	{
	return	new Object[][] {{"Karthik","Test123321@gmail.com"}};
	}

}
