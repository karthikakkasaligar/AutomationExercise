package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.DeletionConfirmationPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

//Test Case 2: Login User with correct email and password
//1. Launch browser--Done
//2. Navigate to url 'http://automationexercise.com'--Done
//3. Verify that home page is visible successfully--Done
//4. Click on 'Signup / Login' button--Done
//5. Verify 'Login to your account' is visible--Done
//6. Enter correct email address and password--Done
//7. Click 'login' button--done
//8. Verify that 'Logged in as username' is visible---done
//9. Click 'Delete Account' button--
//10. Verify that 'ACCOUNT DELETED!' is visible

public class TC_02 extends BaseTest {

	@Test(dataProvider = "getdata")
	public void LoginUserwithcorrectemailandpassword(String email1, String password1) {

		// Login/SignUpPage
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		String LoginText = signuporloginpage.getlogintext();
		Assert.assertEquals("Login to your account", LoginText);
		signuporloginpage.login(email1,password1);

		// LoginConfirmationPage
		homepage.Header.loginconfirmation();

		// Deletion confirmation page
		DeletionConfirmationPage deletionconfirmationPage = homepage.Header.deleaccountcta();
		deletionconfirmationPage.Deleteconfirmation();
	}
	
	@DataProvider
	public Object[][] getdata() {
	return new	Object[][] {{"901karthik@yopmail.com" ,"karthik123"}};
	}
	

} 
