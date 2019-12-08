package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

import GenericUtility.GenericUtils;

public class SummaryPage extends TestBase {

	
	
	//checkout OR

		@FindBy(xpath="//div[@class=\"shopping_cart\"]/a")
		WebElement cartopen;


		@FindBy(xpath="//table[@id=\"cart_summary\"]/tfoot/tr[3]/td[2]")
		WebElement shippingcost;


		@FindBy(xpath="//table[@id=\"cart_summary\"]/tfoot/tr/td[3]")
		WebElement price;


		@FindBy(xpath="//a[@title=\"View my shopping cart\"]/span[@class=\"ajax_cart_quantity unvisible\"]")
		WebElement cartquantity;
		
		@FindBy(xpath="//table[@id=\"cart_summary\"]/tfoot/tr[6]/td[2]")
		WebElement tax;
		
		//OR place order
		
		@FindBy(xpath="//p[@class=\"cart_navigation clearfix\"]/a[@title=\"Proceed to checkout\"]")
		WebElement checkout2;
		
		@FindBy(xpath="//button[@name=\"processAddress\"]/span")
		WebElement checkout3;
		
		@FindBy(xpath="//button[@name=\"processCarrier\"]/span")
		WebElement checkout4;
		
		@FindBy(xpath="//div[@class=\"checker\"]/span")
		
		WebElement agree;
		
		@FindBy(xpath="//div[@id=\"HOOK_PAYMENT\"]/div[2]//p/a")
		WebElement bankwirepayment;
		
		@FindBy(xpath="//p[@id=\"cart_navigation\"]/button")
		WebElement confirmorder;
		
		@FindBy(xpath="//div[@class=\"box order-confirmation\"]/br[3]/following::text()")
		
		WebElement refid;

		
		
		
	public SummaryPage() throws Exception {
		
		
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String placeOrder() {
		
		GenericUtils.scrollToView(driver, checkout2);

		checkout2.click();
		
		GenericUtils.scrollToView(driver, checkout3);
		checkout3.click();
		
		agree.click();
		
		checkout4.click();
		
		bankwirepayment.click();
		
		confirmorder.click();
		
		String title=driver.getTitle();
		
		return title;
		
	}
	
	public String getReferencId() {
		
		WebElement reference1=driver.findElement(By.xpath("//div[@class=\"box order-confirmation\"]"));
		
		String reference=reference1.getText().trim();
		
		
		System.out.println(reference);
		
	   
	    
	    String[] arrOfStr = reference.split("- ");
      
            //System.out.println(arrOfStr[4].trim());
   
	      int total_length=arrOfStr[4].length();
	      
	      String sub_string="Do not forget to include your order reference ";
	    
	      int sub_length=sub_string.length();
	    
	   // System.out.println(sub_length);
	    
	    int ref_startpostion=total_length-11;
	    
	   // System.out.println(ref_startpostion);
	    
	    int ref_lastpostion=total_length;
	    
	  //  System.out.println(ref_lastpostion);
	    
	    
	    
	     
	    reference= arrOfStr[4].substring(ref_startpostion, ref_lastpostion).trim().substring(0,9);
	    
	    
	   
		
		return reference;
	}


	public  float  get_Displayed_Total_price() {


		

		String shipping_cost=shippingcost.getText().replace('$', ' ').trim();

	


		String product_price=price.getText().replace('$', ' ').trim();

	
		String tax_price=tax.getText().replace('$', ' ').trim();
		

		float total=Float.parseFloat(shipping_cost)+Float.parseFloat(product_price)+Float.parseFloat(tax_price);
	
		System.out.println(total);
		
		return total;
		
	}

	
	public float get_total_price() {
		
		List <WebElement> list=driver.findElements(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr"));
		
		//  //table[@id="cart_summary"]/tbody/tr[1]//td[@class="cart_total"]/span[@class="price"]
		
		String xpath_before="//table[@id=\"cart_summary\"]/tbody/tr[";
		
		String xpath_after="]//td[@class=\"cart_total\"]/span[@class=\"price\"]";
		
		float total=0;
		
		for( int i=1;i<=list.size();i++) {
			
		String product_price=	driver.findElement(By.xpath(xpath_before+i+xpath_after)).getText().trim().replace('$', ' ').trim();
		
		//System.out.println(product_price);
			
		float float_price=Float.parseFloat(product_price);
		
		//System.out.println(float_price);
		
	     total=total+float_price;
	     
		
		}
		System.out.println(total);
		
		String shipping_cost=shippingcost.getText().replace('$', ' ').trim();

		
		String tax_price=tax.getText().replace('$', ' ').trim();
		
		total=Float.parseFloat(shipping_cost)+total+Float.parseFloat(tax_price);
		
		//System.out.println();
		
		System.out.println(total);
		return total;
		
	}

}
