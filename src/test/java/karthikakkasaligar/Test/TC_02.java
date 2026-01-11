package karthikakkasaligar.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.AccountCreationConfirmationPage;
import karthikakkasaligar.PageObjectModel.DeletionConfirmationPage;
import karthikakkasaligar.PageObjectModel.InformationPage;
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

	String newemail;
	String Password ="Test@123";
	
	@Test
	public void createnewaccount()
	{
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		String usersignuptext = signuporloginpage.GetSignuptext();
		Assert.assertEquals("New User Signup!", usersignuptext);
		
		newemail ="karthik"+System.currentTimeMillis() +"@yopmail.com";
		InformationPage informationpage = signuporloginpage.SignUp("Karthik",newemail);
				
		// Information Page
		String accountinfotext = informationpage.getaccountinfotext();
		Assert.assertTrue(accountinfotext.equalsIgnoreCase("Enter Account Information"),"Account information Text is Mismatched");
		AccountCreationConfirmationPage accountcreationconfirmationpage = informationpage.informationinfo("Test@123","Karthik", "Akkasaligar", "Product Based company", "#78, Beverly hills", "Karnataka", "Hubli", "969658","9590188891");
				
		// Account Creation Page
		accountcreationconfirmationpage.verifyAccountCreated();
		accountcreationconfirmationpage.clickContinue();

		// LoginConfirmationPage
		homepage.Header.loginconfirmation();
		homepage.Header.logout();
		
	}
	
	
	
	@Test(dependsOnMethods = "createnewaccount")
	public void LoginUserwithcorrectemailandpassword() {

		// Login/SignUpPage
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		String LoginText = signuporloginpage.getlogintext();
		Assert.assertEquals("Login to your account", LoginText);
		signuporloginpage.login(newemail,Password);

		// LoginConfirmationPage
		homepage.Header.loginconfirmation();

		// Deletion confirmation page
		DeletionConfirmationPage deletionconfirmationPage = homepage.Header.deleaccountcta();
		deletionconfirmationPage.Deleteconfirmation();
	}
	
	
	

} 
