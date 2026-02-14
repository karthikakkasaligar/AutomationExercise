package karthikakkasaligar.Test;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.AccountCreationConfirmationPage;
import karthikakkasaligar.PageObjectModel.DeletionConfirmationPage;
import karthikakkasaligar.PageObjectModel.InformationPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

//TEST CASE 1 : User Signup

//1. Launch browser----done
//2. Navigate to url 'http://automationexercise.com'---done
//3. Verify that home page is visible successfully---done
//4. Click on 'Signup / Login' button---done
//5. Verify 'New User Signup!' is visible--done
//6. Enter name and email address---done
//7. Click 'Signup' button--done
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible--Done
//9. Fill details: Title, Name, Email, Password, Date of birth--Done
//10. Select checkbox 'Sign up for our newsletter!'---done
//11. Select checkbox 'Receive special offers from our partners!'---done
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number---done
//13. Click 'Create Account button'---done
//14. Verify that 'ACCOUNT CREATED!' is visible---Done
//15. Click 'Continue' button---done
//16. Verify that 'Logged in as username' is visible--done
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

public class TC_01 extends BaseTest {

	
	@Test(dataProvider = "getdata")
	public void UserSignUp(HashMap<String, String> input) throws IOException
	{
		// Login/SignUpPage
		SignUPorLoginPage signuporloginpage = homepage.Header.SignUporLogin();
		String usersignuptext = signuporloginpage.GetSignuptext();
		Assert.assertEquals("New User Signup!", usersignuptext);
		InformationPage informationpage = signuporloginpage.SignUp(input.get("name"),input.get("email"));
				
		// Information Page
		String accountinfotext = informationpage.getaccountinfotext();
		Assert.assertTrue(accountinfotext.equalsIgnoreCase("Enter Account Information"),"Account info mimatched");
		AccountCreationConfirmationPage accountcreationconfirmationpage = informationpage.informationinfo("Test@123","Karthik", "Akkasaligar", "Product Based company", "#78, Beverly hills", "Karnataka", "Hubli", "969658","9590188891");
				
		// Account Creation Page
		accountcreationconfirmationpage.verifyAccountCreated();
		accountcreationconfirmationpage.clickContinue();

		// LoginConfirmationPage
		homepage.Header.loginconfirmation();

		// Deletion confirmation page
		DeletionConfirmationPage deletionconfirmationPage = homepage.Header.deleaccountcta();
		deletionconfirmationPage.Deleteconfirmation();
	}
	
	@DataProvider
	public Object[][] getdata()
	{	
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("name", "Karthik");
		map.put("email", "karthik"+System.currentTimeMillis() +"@yopmail.com");
		return new Object[][] {{map}};
	}
	

}
