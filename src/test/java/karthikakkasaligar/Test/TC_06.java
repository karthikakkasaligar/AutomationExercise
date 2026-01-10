package karthikakkasaligar.Test;

import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_06 extends BaseTest {

	@Test
	public void ContactUsFrom() {
		
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		

	}

}
