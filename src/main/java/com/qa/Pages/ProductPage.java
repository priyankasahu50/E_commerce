package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

import GenericUtility.GenericUtils;

public class ProductPage extends TestBase {
	
	
	@FindBy(xpath="//div[@class=\"product-image-container\"]/a/img")
	
	WebElement imagelink;
	
	
	@FindBy(xpath="//a[@id=\"wishlist_button\"]")
	
	WebElement wishlistbutton;
	
	
	@FindBy(xpath="//p[@id=\"quantity_wanted_p\"]/input")
	
	WebElement quantity;
	
	
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")

	WebElement womentab;

	
	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/span")
	WebElement tops_tab_open;
	
	
	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[1]/a")
	WebElement tshirtlink;
	
	@FindBy(xpath="//p[@class=\"fancybox-error\"]")
	WebElement confirmpopup;
	
	@FindBy(xpath="//a[@title=\"Close\"]")
	WebElement close;
	
	

	public ProductPage()  throws Exception {
		
		super();
		
		PageFactory.initElements(driver, this);

}
	
	
	
	
	public String add_ProductTo_Wishlist() {
		
		womentab.click();
		tops_tab_open.click();
		tshirtlink.click();
		
		GenericUtils.scrollToView(driver, imagelink);
		
		imagelink.click();
		
		quantity.sendKeys("2");
		
		wishlistbutton.click();
		
		
		String message=confirmpopup.getText();
		
		close.click();
		
		return message;
		
		
		
	}
	
	
}
