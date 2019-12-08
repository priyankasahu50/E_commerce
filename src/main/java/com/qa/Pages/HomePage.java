package com.qa.Pages;



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Base.TestBase;

import GenericUtility.GenericUtils;

public class HomePage extends TestBase {


	@CacheLookup


	//welcome OR
	@FindBy(xpath="//p[@class=\"info-account\"]")

	WebElement welcometext;


	@FindBy(xpath="//a[@title=\"Log me out\"]")
	WebElement signout;


	//	addproduct OR

	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[1]/a")

	WebElement womentab;


	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/span")
	WebElement tops_tab_open;


	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[1]/a")
	WebElement tshirtlink;


	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[2]/a")
	WebElement blouselink;

	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[2]/span")

	WebElement dress_tab_open;

	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[2]/ul/li[1]/a")

	WebElement casual_dress_link;



	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[2]/ul/li[2]/a")

	WebElement evening_dress_link;



	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[2]/ul/li[3]/a")

	WebElement summer_dress_link;


	@FindBy(xpath="//a[@title=\"View my customer account\"]")

	WebElement myaccountlink;


	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")

	WebElement toplink;

	@FindBy(xpath="//div[@class=\"shopping_cart\"]/a[@title=\"View my shopping cart\"]")
	WebElement cart;

	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")

	WebElement quantity;


	//image select OR

	@FindBy(xpath="//ul[@class=\"product_list grid row\"]/li[1]//div[@class=\"right-block\"]/div[@class=\"button-container\"]/a[@title=\"Add to cart\"]")

	////p[@id="add_to_cart"]/button[@type="submit"]

	WebElement addtocartbtn;

	@FindBy(xpath="//ul[@class=\"product_list grid row\"]/li[1]//img")
	WebElement productimg;

	@FindBy(xpath="//span[@class=\"cross\" and @title=\"Close window\"]")
	WebElement closewindow;


	public HomePage() throws Exception {

		super();

		PageFactory.initElements(driver, this);
	}

	public String hptitle_Verification() {

		String result;


		String title=GenericUtils.verifyPageTitle(driver);

		if (title.contains("My account - My Store")) {



			result=welcometext.getText();
		}

		else {

			result="homepage title is not valid";

		}

		return result;
	}


	public void AddProductWomen2(String productname) throws InterruptedException {

		WebDriverWait wait= new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(womentab)); 

		wait.until(ExpectedConditions.elementToBeClickable(womentab));



		//	WebElement womentab=driver.findElement(By.xpath("/*[@id=\\\"block_top_menu\\\"]/ul/li[1]/a"));
		GenericUtils.mouseHoverJScript(driver, womentab);

		womentab.click();
		tops_tab_open.click();
		tshirtlink.click();

		GenericUtils.scrollToView(driver, productimg);

		Thread.sleep(2000);

		GenericUtils.mouseHoverJScript(driver, productimg);


		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")).click();

		Set<String>handles=driver.getWindowHandles();

		int totalhandles=handles.size();

		System.out.println(totalhandles);
		
        String parent=driver.getWindowHandle();
        
        System.out.println(parent);
	   



	}



	public void AddProductWomen(String productname) throws Exception {




		WebDriverWait wait= new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.visibilityOf(womentab)); 

		wait.until(ExpectedConditions.elementToBeClickable(womentab));



		//	WebElement womentab=driver.findElement(By.xpath("/*[@id=\\\"block_top_menu\\\"]/ul/li[1]/a"));
		GenericUtils.mouseHoverJScript(driver, womentab);

		womentab.click();
		tops_tab_open.click();
		dress_tab_open.click();



		if(productname.contains("T-shirts")) {


			tshirtlink.click();

		}

		else if (productname.contains("Blouses")){

			blouselink.click();

		}


		else if (productname.contains("Summer")){

			summer_dress_link.click();

		}



		else if (productname.contains("Casual")){

			casual_dress_link.click();

		}



		else if (productname.contains("Evening")){

			evening_dress_link.click();

		}



		GenericUtils.scrollToView(driver, productimg);

		Thread.sleep(2000);

		GenericUtils.mouseHoverJScript(driver, productimg);






		addtocartbtn.click();

		Thread.sleep(3000);

		closewindow.click();

	}


	public String getCartQuanity() {

		String cartquantity=quantity.getText();

		return cartquantity;

	}

	public String navigateToProducts(String productname) throws InterruptedException {

		String title;


		womentab.click();
		tops_tab_open.click();
		dress_tab_open.click();



		if(productname.contains("T-shirts")) {


			tshirtlink.click();

		}

		else if (productname.contains("Blouses")){

			blouselink.click();

		}


		else if (productname.contains("Summer")){

			summer_dress_link.click();

		}



		else if (productname.contains("Casual")){

			casual_dress_link.click();

		}



		else if (productname.contains("Evening")){

			evening_dress_link.click();

		}


		title=GenericUtils.verifyPageTitle(driver);

		return title;





	}




	public LoginPage signout() throws Exception {

		signout.click();
		return new LoginPage();
	}




	public MyAccountPage load_MyAccountPage() throws Exception {

		myaccountlink.click();

		return new MyAccountPage();
	}


	public SummaryPage loadSummarypage() throws Exception {


		GenericUtils.scrollToView(driver, cart);

		Thread.sleep(2000);

		GenericUtils.mouseHoverJScript(driver, cart);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//p[@class=\"cart-buttons\"]/a/span")).click();

		System.out.println("checkout");

		return new SummaryPage();



	}












}










