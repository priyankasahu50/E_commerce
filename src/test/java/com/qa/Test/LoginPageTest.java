package com.qa.Test;

import java.io.File;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;

import GenericUtility.GenericUtils;



public class LoginPageTest extends TestBase {
	
	

	LoginPage loginpage ;
	HomePage homepage;






	public LoginPageTest() throws Exception {

		super();
	}







	@BeforeMethod

	public void setUp() throws Exception {

		TestBase.intitalization();

		loginpage=new LoginPage();

	}
	


	@Test(enabled=true)

	public void LoginPage_TC001() throws Exception {


	



		homepage=loginpage.loginUser();

		String actual_result=homepage.hptitle_Verification();


		Assert.assertEquals(actual_result,"Welcome to your account. Here you can manage all of your personal information and orders.");




	}


	@DataProvider(name="getdataexcel")

	public Object[][] getdatafromexcel() throws IOException{

		Object[][] data=GenericUtils.dataProvider("Test-Cases-for-OrangeHRM-SoftwareTestingHelp.xlsx");

		return data;
	}


	@Test (dataProvider="getdataexcel",enabled=false)

	public void LoginPage_TC_002(String gender,String fname,String lname,String password,String day,String month,String year,String company,String add1,String add2,String city,String state,String pin,String country,String mobile,String other) {

		String title=loginpage.signUP(gender, fname, lname, password, day, month, year, company, add1, add2, city, state, pin, country, mobile, other);

		Assert.assertEquals("title ","Login - My Store");

	}


	@Test(enabled=true)
	public void Login_page_TC_003() throws Exception {



		String title=loginpage.unregistereduser_AdProduct("T-Shirts");

		Assert.assertEquals(title,"Login - My Store");



	}


	@AfterMethod

	public void teardown(ITestResult result) throws Exception {

		driver.close();







	}

}
