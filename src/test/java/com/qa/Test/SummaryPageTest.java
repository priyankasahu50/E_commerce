package com.qa.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.SummaryPage;

public class SummaryPageTest extends TestBase {
	
	LoginPage login;
	HomePage homepg;
	SummaryPage summary;
	

	public SummaryPageTest() throws Exception {
		
		super();
		}
	
	
	

@BeforeMethod
	
	public void setUp() throws Exception {
		
		TestBase.intitalization();
		
		login=new LoginPage();
		
		homepg=login.loginUser();
		
		
		
	
		
		}


@Test

public void summarypage_TC002() throws Exception {
	
	//SoftAssert sa= new SoftAssert();
	

	System.out.println("test case starting");
	
	homepg.AddProductWomen("Blouses");
	summary=homepg.loadSummarypage();
	
	
	String actual=summary.placeOrder();
	
	
	
	
	
	try {
		Assert.assertEquals(actual, "Order confirmation - My Store");
		
		Reporter.log("testcase is passed::Order placed successfully");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		Reporter.log("testcase is failed::Order is not placed successfully");
	}
	
	String reference_id=summary.getReferencId();
	int length=reference_id.length();
	
	System.out.println(length);
	System.out.println(reference_id);
	
	try {
		Assert.assertEquals(length, 9);
		
		Reporter.log("reference id is generated is of length 9 "+reference_id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		Reporter.log("refrence id generated is not correct");
	}
	
	//sa.assertAll();
	
	
	
}



@Test(enabled=false)

public void summarypage_TC_001() throws Exception {
	
	homepg.AddProductWomen("Blouses");
	homepg.AddProductWomen("T-Shirts");
	
	summary=homepg.loadSummarypage();
	
	float total=summary.get_Displayed_Total_price();
	
	if (total==29.00) {
		
		
	Assert.assertEquals(total, 29.00);
		Reporter.log("total is correct after adding shipping");
	}
	
	else {
		Assert.assertEquals(total, 29.00);
		Reporter.log("total is incorrect after adding shipping");
	}
	
	
}


@Test(enabled=false)

//add the produt,verify that the total price should be inclusive of shipping price
//add the products,verify the total price displayed should be equal to proct

public void summary_page_TC_002() throws Exception {
	
	homepg.AddProductWomen("Blouses");
	homepg.AddProductWomen("T-Shirts");
	
	summary=homepg.loadSummarypage();
	
   if(summary.get_Displayed_Total_price()==summary.get_total_price()) {
	   
	   

	   Reporter.log("testcase is passed" +summary.get_Displayed_Total_price()+" "+summary.get_total_price());
	   

	   
   }
   

   
   
   else {
	   
	   Reporter.log("testcase is failed"+summary.get_Displayed_Total_price()+" "+summary.get_total_price());
	   Reporter.log("displayed total "+summary.get_Displayed_Total_price());
	   
	   Reporter.log("calculated total "+summary.get_total_price());
}


}




@AfterMethod

public void teardown (){
	
	driver.quit();
	}

}
