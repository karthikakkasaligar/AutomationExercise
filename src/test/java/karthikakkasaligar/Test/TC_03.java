package karthikakkasaligar.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_03 extends BaseTest{

	@Test(dataProvider = "getdata")
	public void LoginUserwithincorrectemailandpassword(HashMap<String, String> input)
	{
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		signuporloginpage.login(input.get("email"),input.get("password"));
	    String Errortext=signuporloginpage.geterrortext();
		Assert.assertEquals("Your email or password is incorrect!", Errortext);
	}

	@DataProvider
	public Object[][] getdata()
	{
		HashMap<String, String>map=new HashMap<String, String>();
		map.put("email", "Test12332@gmail.com");
		map.put("password", "karthik123");
		return	new Object[][] {{map}};
	}
}
