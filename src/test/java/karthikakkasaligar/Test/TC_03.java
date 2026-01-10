package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_03 extends BaseTest{

	@Test(dataProvider = "getdata")
	public void LoginUserwithincorrectemailandpassword(String email1 , String password1)
	{
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		signuporloginpage.login(email1,password1);
	    String Errortext=signuporloginpage.geterrortext();
		Assert.assertEquals("Your email or password is incorrect!", Errortext);
	}

	@DataProvider
	public Object[][] getdata()
	{
	return	new Object[][] {{"karthik77@gmail.com","Test@321"}};
	}
}
