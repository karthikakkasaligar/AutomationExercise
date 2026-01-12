package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.PageObjectModel.TestCasePage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_07 extends BaseTest {

	@Test
	public void VerifyTestCasePage() {
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		TestCasePage testcasepage = homepage.Header.clickTestCaseButton();
		String URL = testcasepage.getcurrenturl();
		Assert.assertEquals(URL, "https://automationexercise.com/test_cases");
	}

}
