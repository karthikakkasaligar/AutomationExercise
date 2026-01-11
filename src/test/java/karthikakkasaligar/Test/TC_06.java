package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.ContactUsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_06 extends BaseTest {

	@Test
	public void ContactUsFrom() {

		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		ContactUsPage contactuspage = homepage.Header.contactus();
		String Contactustext = contactuspage.getContactustext();
		Assert.assertEquals(Contactustext, "CONTACT US");
		String getInTouchText = contactuspage.getgetInTouchText();
		Assert.assertEquals(getInTouchText, "GET IN TOUCH");
		contactuspage.Formfillup("Karthik", "karthik@gmail.com", "hey", "hello", "C:\\Users\\karth\\Downloads");
		String Sucessmessgae = contactuspage.getSucessmessgaetext();
		Assert.assertEquals(Sucessmessgae, "Success! Your details have been submitted successfully.");
		contactuspage.NavigatetoHomepage();
		String URL = contactuspage.getcurrenturl();
		Assert.assertEquals(URL, "https://automationexercise.com/");
	}

}
