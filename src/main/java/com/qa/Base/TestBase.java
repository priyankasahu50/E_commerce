package com.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static  WebDriver driver;
	
	public static Properties prop;

	public TestBase() throws Exception {
		
		//load property file having environmental variables
		
		prop=new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\Users\\ravin\\Desktop\\HR_domain\\EcommerceSite\\src\\main\\java\\Data\\config.properties");
		
		prop.load(ip);
		
		}
	
	
	
	public static void intitalization() {
		
		
		String browserName= prop.getProperty("Browser");
		String url=prop.getProperty("URL");
		
		if (browserName.contentEquals("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravin\\Desktop\\Qspider\\selenium_jar\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		}
		
		
		else {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ravin\\Desktop\\Qspider\\selenium_jar\\geckodriver.exe");
			
			driver=new FirefoxDriver();	
		}
		
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("URL"));
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	

}
