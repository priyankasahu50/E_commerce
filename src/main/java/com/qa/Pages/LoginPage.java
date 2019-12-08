package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.TestBase;

import GenericUtility.GenericUtils;

public class LoginPage extends TestBase {


	//Pagefactory or Object repository

	@FindBy(xpath ="//a[@class='login']")

	WebElement loginlink;


	@FindBy(id="email")

	WebElement userid;

	@FindBy(id="passwd")

	WebElement password;

	@FindBy(id="SubmitLogin")

	WebElement submit;

	@FindBy(id="email_create")

	WebElement create_email;

	@FindBy(xpath="//button[@id=\"SubmitCreate\"]")

	WebElement submit_create;

	//OR add Product

	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")

	WebElement womentab;


	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/span")
	WebElement tops_tab_open;


	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[1]/a")
	WebElement tshirtlink;


	@FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[2]/a")
	WebElement blouselink;


	@FindBy(xpath="//p[@class=\"cart_navigation clearfix\"]/a[@title=\"Proceed to checkout\"]")
	WebElement checkout2;



	@FindBy(xpath="//ul[@class=\"product_list grid row\"]/li[1]//div[@class=\"right-block\"]/div[@class=\"button-container\"]/a[@title=\"Add to cart\"]")

	////p[@id="add_to_cart"]/button[@type="submit"]

	WebElement addtocartbtn;

	@FindBy(xpath="//ul[@class=\"product_list grid row\"]/li[1]//img")
	WebElement productimg;

	@FindBy(xpath="//a[@title=\"Proceed to checkout\"]")
	WebElement checkout;


	//OR for signup

	@FindBy(xpath="//div[@class=\"radio-inline\"][1]/label/div")

	WebElement male;

	@FindBy(xpath="//div[@class=\"radio-inline\"][2]/label/div")

	WebElement female;

	@FindBy(id="customer_firstname")
	WebElement fname1;

	@FindBy(id="customer_lastname")

	WebElement lastname;


	@FindBy(id="passwd")

	WebElement passwordnew;



	@FindBy(id="firstname")

	WebElement firstname;



	@FindBy(id="lastname")

	WebElement lastname2;


	@FindBy(id="company")

	WebElement company;


	@FindBy(id="address1")

	WebElement address1;


	@FindBy(id="address2")

	WebElement address2;


	@FindBy(id="city")

	WebElement city;

	@FindBy(id="postcode")

	WebElement postcode;

	@FindBy(id="phone_mobile")

	WebElement phone_mobile;

	@FindBy(id="other")

	WebElement other;


	@FindBy (id="days")
	WebElement day;


	@FindBy (id="months")
	WebElement months;


	@FindBy (id="years")
	WebElement years;


	@FindBy (id="id_state")
	WebElement state;


	@FindBy (id="id_country")
	WebElement country;

	@FindBy (id="alias")
	WebElement Assign_address;

	@FindBy(xpath="//button[@id=\"submitAccount\"]")

	WebElement register;



	public LoginPage() throws Exception {

		super();

		PageFactory.initElements(driver, this);


	}


	public String unregistereduser_AdProduct(String productname) throws Exception {

		GenericUtils.mousehover(driver, womentab);

		womentab.click();
		tops_tab_open.click();

		if(productname.contains("T-shirts")) {


			tshirtlink.click();

		}

		else if (productname.contains("Blouses")){

			blouselink.click();

		}


		GenericUtils.scrollToView(driver, productimg);

		Thread.sleep(2000);

		GenericUtils.mouseHoverJScript(driver, productimg);

		addtocartbtn.click();

		Thread.sleep(3000);

		checkout.click();
		
		Thread.sleep(3000);
		
		GenericUtils.scrollToView(driver, checkout2);

		checkout2.click();

		String title=driver.getTitle();

		return title;

	}


	public String signUP(String gender,String fname,String lname,String password,String days,String month,String year,String comp,String add1,String add2,String city1,String state1,String pin1,String ctry,String mobile,String linkadd) {



		if (gender.contains("male")) {

			male.click();
		}

		else
			female.click();






		fname1.sendKeys(fname);
		lastname.sendKeys(lname);

		passwordnew.sendKeys(password);

		GenericUtils.scrollToView(driver, country);

		Select select =new Select(day);
		select.selectByVisibleText(days);

		Select select2 =new Select(months);
		select.selectByVisibleText(month);


		Select select3 =new Select(years);
		select.selectByVisibleText(year);

		firstname.sendKeys(fname);
		lastname2.sendKeys(lname);

		company.sendKeys(comp);
		address1.sendKeys(add1);
		address2.sendKeys(add2);

		city.sendKeys(city1);

		Select selectstate=new Select(state);
		selectstate.selectByVisibleText(state1);

		postcode.sendKeys(pin1);


		Select selectcountry=new Select(country);
		selectcountry.selectByVisibleText(ctry);

		GenericUtils.scrollToView(driver, register);


		phone_mobile.sendKeys(mobile);

		other.sendKeys(linkadd);

		register.click();

		String title=driver.getTitle();

		return title;

	}


	public HomePage loginUser() throws Exception {

		loginlink.click();

		userid.sendKeys(prop.getProperty("username"));

		password.sendKeys(prop.getProperty("password"));
		submit.click();

		return new HomePage();
	}


	public void createAccount() {




	}




}
