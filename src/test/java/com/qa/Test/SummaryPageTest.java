package com.qa.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.qa.Pages.SummaryPage;

import GenericUtility.GenericUtils;

public class SummaryPageTest extends TestBase {

	LoginPage login;
	HomePage homepg;
	SummaryPage summary;
	ExtentTest test;


	public SummaryPageTest() throws Exception {

		super();
	}




	@BeforeMethod

	public void setUp() throws Exception {

		TestBase.intitalization();

		login=new LoginPage();

		homepg=login.loginUser();





	}


	@Test(enabled=true)

	public void SummaryPage_TC_003() throws Exception {

		//SoftAssert sa= new SoftAssert();



		homepg.AddProductWomen("Blouses");
		summary=homepg.loadSummarypage();


		String actual=summary.placeOrder();

		Assert.assertEquals(actual, "Order confirmation - My Store");


		String reference_id=summary.getReferencId();
		int length=reference_id.length();

		Assert.assertEquals(length, 9);


	}



	@Test(enabled=true)

	public void SummaryPage_TC_002() throws Exception {




		homepg.AddProductWomen("Blouses");
		homepg.AddProductWomen("T-Shirts");

		summary=homepg.loadSummarypage();

		float total=summary.get_Displayed_Total_price();
		float expected=(float) 45.51;

		Assert.assertEquals(total, expected);
		Reporter.log("total is correct after adding shipping");


	}


	@Test(enabled=true)

	//add the produt,verify that the total price should be inclusive of shipping price
	//add the products,verify the total price displayed should be equal to proct

	public void SummaryPage_TC_001() throws Exception {




		homepg.AddProductWomen("Blouses");
		homepg.AddProductWomen("T-Shirts");

		summary=homepg.loadSummarypage();

		Assert.assertEquals(summary.get_Displayed_Total_price(), summary.get_total_price());

	


	}




	@AfterMethod

	public void teardown (ITestResult result) throws IOException{

		driver.quit();



	}
}
