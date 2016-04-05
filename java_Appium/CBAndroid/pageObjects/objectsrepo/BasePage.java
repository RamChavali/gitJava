package objectsrepo;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

@SuppressWarnings("unused")
public class BasePage {
	
	//############################################################################################### [-SETUP-]
			
			WebDriver driver;
			WebDriverWait wait;
			
			public BasePage(WebDriver driver) throws Exception 
				{
					this.driver=driver;
					this.wait = new WebDriverWait(driver, 20);
				}

	//############################################################################################### [-HELPERS-]
	
		// send keys to element [ID]
		public void enterInputById(WebDriverWait webDriverWait, String inputLoc, String inputStr) 
			{
				WebElement thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputLoc)));
				thisElem.sendKeys(inputStr);
				String outputMssg = "entered " + inputStr + " into " + inputLoc;
				System.out.println("info: "+ outputMssg);	
			}
		
		// click element [ID]
		public static void clickById(WebDriverWait webDriverWait, String clickLoc) 
			{
				WebElement thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(clickLoc)));
				thisElem.click();
				String outputMssg = "clicked by id, " + clickLoc;
				System.out.println("info: "+ outputMssg);	
			}
		
		// click element at 1st index of ID group 
		public void clickById_atFirstIndex(WebDriverWait webDriverWait, String clickLoc)
			{
				List<WebElement> elemsList = driver.findElements(By.className(clickLoc));
				elemsList.get(0).click();
				String outputMssg = "clicked by class name @1st index, " + clickLoc;
				System.out.println("info: "+ outputMssg);
			}
		
		// click element [CLASSNAME]
		public void clickByClassName(WebDriverWait webDriverWait, String clickLoc) 
			{
				WebElement thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(clickLoc)));
				thisElem.click();
				String outputMssg = "clicked by class name, " + clickLoc;
				System.out.println("info: "+ outputMssg);	
			}		
		
		// click element [NAME]
		public void clickByName(WebDriverWait webDriverWait, String clickLoc) 
			{
				WebElement thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(clickLoc)));
				thisElem.click();
				String outputMssg = "clicked by name, " + clickLoc;
				System.out.println("info: "+ outputMssg);	
			}		

		// get text from element [ID]
		public void readTextById(WebDriverWait webDriverWait, String readLoc) 
			{
				WebElement thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(readLoc)));
				String readText = thisElem.getText();
				String outputMssg = "read " + readText + " from id, " + readLoc;
				System.out.println("info: "+ outputMssg);
			}
		
		// check if element exists [ID]
		//TODO:  see if it makes sense to just throw the exception here and then let the caller take care of it
		//eg throws Exception
		public boolean checkIfElemExists(WebDriverWait webDriverWait, String elemLoc) 
			{
				WebElement thisElem;
				try{
					thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemLoc)));
				}catch(Exception e){
					System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
					e.printStackTrace();
					System.out.println("Page source for reference: " + driver.getPageSource());
					System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
					return false;
				}
				if (thisElem != null) {
					String outputMssg = "verified element visible on page: " + elemLoc;
					System.out.println("info: " + outputMssg);
					return true;
				} else {
					return false;
				}
			}
		// wait for element to be visible
		public WebElement getElemById(WebDriverWait webDriverWait, String elemLoc)
			{
				WebElement thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemLoc)));
				return thisElem;
			}
		public WebElement getElemByName(WebDriverWait webDriverWait, String elemLoc)
		{
			WebElement thisElem = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemLoc)));
			return thisElem;
		}
		// TODO - key press and print status
//		public void simulateEnterClick() 
//			{
//				
//			}
		

		
		
		
}
