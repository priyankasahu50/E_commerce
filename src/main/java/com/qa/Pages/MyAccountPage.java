package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

import GenericUtility.GenericUtils;

public class MyAccountPage extends TestBase{

	
	
	@FindBy(xpath="//li[@class=\"lnk_wishlist\"]/a")
	
	WebElement wishlist_link;
	
	

	
	@FindBy(xpath="//table[@class=\"table table-bordered\"]/tbody/tr/td/a")
	
	WebElement mywishlist_link;
	
	@FindBy(xpath="//p[@id=\"s_title\"]")
	
	WebElement item_title;
	
	
	
	
	@FindBy(xpath="//div[@class=\"product-image-container\"]/a[@title=\"Faded Short Sleeve T-shirts\"]/img")
	
	WebElement imagelink;
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[3]/div[1]/a")
	
	WebElement wishlistbutton;
	
	
	@FindBy(xpath="//a[@title=\"Close\" and @class=\"fancybox-item fancybox-close\"]")
	
	WebElement fancybox_close;
	
	@FindBy(xpath="//input[@id=\"quantity_wanted\"]")
	
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
	
	
	
	
	
	
	public MyAccountPage() throws Exception {
		
		super();
		
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	public String wishlist_Verification() {
		
		String message;
		
		
		wishlist_link.click();
		
		if(mywishlist_link.isDisplayed()) {
			
			mywishlist_link.click();
			GenericUtils.scrollToView(driver, item_title);
			
			 message=item_title.getText().trim();
			
			
		}
		
		
		else {
			
			message="items not added";
		
			
		}
		
		 return message;
		
	}
	
	
	
public String add_ProductTo_Wishlist() throws InterruptedException {
		
		womentab.click();
		tops_tab_open.click();
		tshirtlink.click();
		
		GenericUtils.scrollToView(driver, imagelink);
		
		GenericUtils.mouseHoverJScript(driver, imagelink);
		
		Thread.sleep(2000);
	
		GenericUtils.mouseHoverJScript(driver, wishlistbutton);
		
		wishlistbutton.click();
		
		
		//quantity.clear();
		
		//quantity.sendKeys("2");
		
		
		
		
		
		
		
		
		String message=confirmpopup.getText();
		
		close.click();
		
		return message;
		
		
		
	}
	

}
