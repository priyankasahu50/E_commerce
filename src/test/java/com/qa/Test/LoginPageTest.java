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
	
	 ExtentReports extent;
	 
	 ExtentTest test;
	
	ExtentHtmlReporter htmlReporter;
	
	

	public LoginPageTest() throws Exception {
		
		super();
			}
	
	
	
	@BeforeSuite
	public void setup() {
		
		 extent = new ExtentReports();
		
		 File file = new File("C:\\Users\\ravin\\Desktop\\HR_domain\\EcommerceSite\\extent.html");
		
		 htmlReporter = new ExtentHtmlReporter(file);
		extent.attachReporter(htmlReporter);
		
		
		
	}
	
	
	
	
	@BeforeMethod
	
	public void setUp() throws Exception {
		
		TestBase.intitalization();
		
		loginpage=new LoginPage();
		
		}
	
	@Test(enabled=false)
	
	public void LoginPage_TC001() throws Exception {
		
		
		 test = extent.createTest("LoginPage_TC001", "Registered user login");
		 
		 
		
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
	
	public void verify_RegisterNewUser(String gender,String fname,String lname,String password,String day,String month,String year,String company,String add1,String add2,String city,String state,String pin,String country,String mobile,String other) {
		
		String title=loginpage.signUP(gender, fname, lname, password, day, month, year, company, add1, add2, city, state, pin, country, mobile, other);
		
	
		 try {
			Assert.assertEquals("title ","Login - My Store");
			
			Reporter.log("testcase is passes");
		} catch (Exception e) {
			Reporter.log("testcase is failed, user cannot be registered successfully");
		}

	}
	
	
	@Test(enabled=true)
	 public void Login_page_TC_003() throws Exception {
		
		 test = extent.createTest("LoginPage_TC003", "Unregistered User order product");
		 
		
		 
	
			String title=loginpage.unregistereduser_AdProduct("T-Shirts");
			
			Assert.assertEquals(title,"Login - My Store");
			
		
		
	}
	
	
	@AfterMethod
	
	public void teardown(ITestResult result) throws Exception {
		
		driver.close();
		
	
		
		 if (result.getStatus() == ITestResult.FAILURE) {
			 
			 
			 test.fail(result.getThrowable());	
			 
			 test.fail("test case is failed");
			
		 }
	            
	        else if (result.getStatus() == ITestResult.SKIP) {
	        
	        test.skip(result.getThrowable());	 
	        }
	        else {
	          test.pass("test case is passed");
	        }
		 
		 
		extent.flush();
	}
	
	
	

}
