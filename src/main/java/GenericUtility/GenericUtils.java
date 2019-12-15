package GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenericUtils {


	public static String verifyPageTitle(WebDriver driver) {

		String title=driver.getTitle();
		return title;
	}

	public static void mousehover(WebDriver driver,WebElement element) {

		Actions action=new Actions(driver);

		action.moveToElement(element);
		
		
	}


	public static void scrollToView(WebDriver driver,WebElement element) {

		JavascriptExecutor jp=(JavascriptExecutor)driver;

		jp.executeScript("arguments[0].scrollIntoView(true);",element);
		




	}
	
	public static int getwindowHandle(WebDriver driver) {
		
		
		Set<String>handles=driver.getWindowHandles();
		
		int totalhandles=handles.size();
		
		return totalhandles;
		
	}
	
	
	public static void alert_Popup(WebDriver driver) {
		
		
		Alert alert=driver.switchTo().alert();
		
		String message=alert.getText();
		
		alert.dismiss();
		
		
	}

	public static  void switchwindow_frame(WebDriver driver) {
		
		
	//	String your_title = "Blouse - My Store";
		String currentWindow = driver.getWindowHandle();
		
		
		System.out.println(currentWindow);
		
	int size=driver.getWindowHandles().size();
		
		System.out.println(size);
		
		
		
		
		
		//will keep current window to switch back
		/*for(String winHandle : driver.getWindowHandles()){
		   if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
		     //This is the one you're looking for
		     break;
		   } 
		   else {
		      driver.switchTo().window(currentWindow);
		   } */
		}
	
	
	
	public static Object[][] dataProvider(String path) throws IOException {
		
	
		
		FileInputStream fin=new FileInputStream(path);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fin);
	
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int total_rows=sheet.getLastRowNum();
		int total_column=sheet.getRow(1).getLastCellNum();
		
		Object[][] data=null;
		
		for(int i=2;i<=total_rows;i++) {
			
			 for(int j=1;j<=total_column;j++) {
				 
				 data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				 
			 }
		}
		
		return data;
		
	}
		
	
	
	public static void doubleclick(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.doubleClick(element);
		
	}
	
	
	
	public static void mouseHoverJScript(WebDriver driver,WebElement HoverElement) {

		JavascriptExecutor jp=(JavascriptExecutor)driver;
		try {
			if (HoverElement.isDisplayed()) {

				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				jp.executeScript(mouseOverScript,
						HoverElement);

			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}


	public String getPageTitle(WebDriver driver)
	{

		String title;

		title=driver.getTitle();

		return title;

	}

	public static String screenshot(WebDriver driver,String testcasename) throws IOException  {

		TakesScreenshot sc= (TakesScreenshot)driver;



		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());


		System.out.println(timestamp);



		File src= sc.getScreenshotAs(OutputType.FILE);
		
		String Dest_path="C:\\Users\\ravin\\Desktop\\Qspider\\screenshots\\"+timestamp+"_"+testcasename+".jpg";

		File dest= new File(Dest_path);
		FileUtils.copyFile(src, dest);
		
		return Dest_path;


	}

}
