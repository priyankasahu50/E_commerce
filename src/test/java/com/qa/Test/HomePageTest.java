package com.qa.Test;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;

import GenericUtility.GenericUtils;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage ;
	HomePage homepage;

	public HomePageTest() throws Exception {
		
		super();
	}
	
	
@BeforeMethod
	
	public void setUp() throws Exception {
		
		TestBase.intitalization();
		
		loginpage=new LoginPage();
		
		homepage=loginpage.loginUser();
		
		}



@Test

public void HomePage_TE001() throws InterruptedException {
	
	homepage.AddProductWomen2("T-Shirts");
	
	
	
	
}






@Test(enabled=false)

//add products to cart,logout,login number of products added should be same to cart

public void addproduct_Verification() throws Exception {
	String cartquantity;
	String cartquantity1;
	homepage.AddProductWomen("T-shirts");
	
	cartquantity=homepage.getCartQuanity();
	Reporter.log("1. "+cartquantity+" product added successfully");
	
	loginpage=homepage.signout();
	homepage=loginpage.loginUser();
	
	cartquantity1=homepage.getCartQuanity();
	
    Assert.assertEquals(cartquantity1, cartquantity, "testcase failed, product added is removed");

	
}

@DataProvider(name = "data-provider")

public Object[][] getdata() {
	
	Object[][] data=new Object[][]{{"T-shirts"},{"Blouses"},{"Casual"},{"Evening"},{"Summer"}};
	
	
	return data;
	
}

@Test(dataProvider = "data-provider",enabled=false)

//Verify that user is able to navigate through all the products across different categories


public void navigateProductVerification(String product) throws InterruptedException {
	
	
	String pagetitle=homepage.navigateToProducts(product);
	
    Reporter.log(pagetitle);
		
	Assert.assertTrue(pagetitle.contains(product),"Product cannot be navigated");
			
	
}



	



@AfterMethod

public void teardown (){
	
	
		//driver.quit();
	}

}
