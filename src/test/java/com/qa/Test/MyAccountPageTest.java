package com.qa.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.MyAccountPage;
import com.qa.Pages.ProductPage;

import GenericUtility.GenericUtils;

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

		myaccountpg=new MyAccountPage();

	}


	@Test

	//product added to wishlist successfully
	public void MyaccountPage_TC_001() throws Exception {



		String actual=myaccountpg.add_ProductTo_Wishlist();

		Assert.assertEquals(actual,"Added to your wishlist.");




		Reporter.log(actual);



	}

	@Test

	public void MyaccountPage_TC_002() {




		String actual_msg=myaccountpg.wishlist_Verification();

		Assert.assertEquals(actual_msg,"Faded Short Sleeve T-shirts");



		Reporter.log(actual_msg);
	}


	@AfterMethod

	public void teardown(ITestResult result) throws IOException {

		driver.quit();


	}

}
