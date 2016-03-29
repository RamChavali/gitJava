import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

@SuppressWarnings("unused")
public class add_card {

	//############################################################################################### [-HELPERS-]
	
	/* enters input by id */
	public void enterInputById(WebDriverWait webDriverWait, String inputLoc, String inputStr, String outputMsg) {
		WebElement thisElem = webDriverWait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id(inputLoc)));
		thisElem.sendKeys(inputStr);
		System.out.println("status: "+ outputMsg);	
	}
	
	/* clicks elem by id */
	public void clickByID(WebDriverWait webDriverWait, String clickLoc, String outputMsg) {
		// -- enter input [email]
		WebElement thisElem = webDriverWait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id(clickLoc)));
		thisElem.click();
		System.out.println("status: "+ outputMsg);	
	}
	
	/* clicks elem by classname */
	public void clickByClassName(WebDriverWait webDriverWait, String clickLoc, String outputMsg) {
		// -- enter input [email]
		WebElement thisElem = webDriverWait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.className(clickLoc)));
		thisElem.click();
		System.out.println("status: "+ outputMsg);	
	}
	
	/* clicks elem by name */
	public void clickByName(WebDriverWait webDriverWait, String clickLoc, String outputMsg) {
		// -- enter input [email]
		WebElement thisElem = webDriverWait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.name(clickLoc)));
		thisElem.click();
		System.out.println("status: "+ outputMsg);	
	}

	/* read text from element */
	public void readTextById(WebDriverWait webDriverWait, String userNote, String readLoc) {
		// -- enter input [email]
		WebElement thisElem = webDriverWait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id(readLoc)));
		System.out.println("\t> user "+ userNote + thisElem.getText());	
	}
	

	
	/* prints start time */
	public void printStartTime() {
		String startTime = this.getDateTime();
		System.out.println("starting: " + startTime);
		System.out.println(this.printDividingLine());
	}
	
	/* prints end time */
	public void printEndTime() {
		System.out.println(this.printDividingLine());
		String endTime = this.getDateTime();
		System.out.println("ending: " + endTime);
	}
	
	//############################################################################################### [-TEST-]
	
	@Test
	public void test() throws Exception{
		
		//------------------------------------------------------------------------------------------- [-SETUP-]
		
		/* map with locators, + input values + output mssg */
		PropertiesReader properties = PropertiesReader.getInstance();
		
		/* file */
		File appDir = new File("src");
		File app = new File(appDir, "app-2.21.10-66.apk");
		
		/* desired capabilities */
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		/* android driver */
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		
		/* vars */
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean cardOnFile = false;
		
		//--------------------------------------------------------------------------------------TEST
		
		/* print start time */
		this.printStartTime();
		
		/* nav to Manage Cards */
		this.clickByClassName(wait, properties.get("navBarClass"), properties.get("navBarClickedMssg"));
		this.clickByName(wait, properties.get("navAccountName"), properties.get("navCardsClickedMssg"));
		
		/* signup or login */
		this.clickByID(wait, properties.get("linkSigninID"), properties.get("navSigninClickedMssg"));
		
		/* proceed login */
		this.enterInputById(wait,properties.get("inputEmailID"), properties.get("emailStr"), properties.get("enteredEmailMssg"));
		this.enterInputById(wait, properties.get("inputPassID"), properties.get("passStr"), properties.get("enteredPassMssg"));
		this.clickByID(wait, properties.get("btnSigninID"), properties.get("btnSignInClickedMssg"));
		
		/* print login details for reference */
		this.readTextById(wait, "name", properties.get("accountNameDisplayID"));
		this.readTextById(wait, "email", properties.get("accountEmailDisplayID"));
		this.readTextById(wait, "phone", properties.get("accountPhoneDisplayID"));

		/* nav back to Manage Cards */
		this.clickByClassName(wait, properties.get("navBarClass"), properties.get("navBarClickedMssg"));
		this.clickByName(wait, properties.get("navCardsName"), properties.get("navCardsClickedMssg"));
		
		/* if card on file, extra pre-step (click 'Add Payment Card') */
		if (!driver.findElements(By.name(properties.get("addPayCardName"))).isEmpty()) {
			driver.findElementByName(properties.get("addPayCardName")).click();
			System.out.println(properties.get("statusOnAddCardScreenMssg"));
		}
		
		/* enter card details */
		this.enterInputById(wait, properties.get("inputCCNumID"), properties.get("ccNumStr"), properties.get("enteredCCNumMssg"));
		this.enterInputById(wait, properties.get("inputCCExpID"), properties.get("ccExpStr"), properties.get("enteredExpDateMssg"));
		this.enterInputById(wait, properties.get("inputCVVID"), properties.get("ccCVVStr"), properties.get("enteredCCVMssg"));
		this.clickByID(wait, properties.get("submitNextID"), properties.get("btnAddPayCardNextClickedMssg"));
		
		/* if addr on file, extra step to add 'New' */
		if (!driver.findElements(By.name(properties.get("addNewBillAddrID"))).isEmpty()) {
			driver.findElementByName(properties.get("addNewBillAddrID")).click();
			System.out.println(properties.get("statusOnAddAddrScreenMssg"));
		}
		
		
		/* print end time */
		this.printEndTime();
	}

	//############################################################################################### [-HELPERS 2-]
	
	/* returns datetime for reference */
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	/* returns dividing line */
	private String printDividingLine() {
		String dividingLine = new String(new char[100]).replace("\0", "-");
		return dividingLine;
	}
	
}
