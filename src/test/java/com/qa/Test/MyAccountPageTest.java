package com.qa.Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.MyAccountPage;
import com.qa.Pages.ProductPage;

public class MyAccountPageTest extends TestBase {

	LoginPage login;

	HomePage homepage;
	
	MyAccountPage myaccountpg;




	public MyAccountPageTest() throws Exception {

		super();

	}

	@BeforeMethod

	public void setup() throws Exception {


		TestBase.intitalization();
		
		login=new LoginPage();

		homepage=login.loginUser();
		
		myaccountpg=homepage.load_MyAccountPage();

	}


	@Test

	//product added to wishlist successfully
	public void wishlist_TC_001() throws Exception {

	

		String actual=myaccountpg.add_ProductTo_Wishlist();
		
	
		
		Assert.assertTrue(actual.contains("Added to your wishlist"), "items not added to wishlist");
		
		Reporter.log(actual);
		
	

	}
	
	@Test
	
	public void wishlist_TC_002() {
		
		String actual_msg=myaccountpg.wishlist_Verification();
		
		Assert.assertFalse(actual_msg.contains("items not added"), "items not added to wishlist");
		
		Reporter.log(actual_msg);
	}
	
	
	@AfterMethod
	
	public void teardown() {
		
		driver.quit();
	}

}
