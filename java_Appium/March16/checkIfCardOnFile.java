import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class add_card {

	@SuppressWarnings("unused")
	@Test
	public void test() throws Exception{

		//--------------------------------------------------------------------------------------DATE
		
		// Print datetime for reference.
		System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
		System.out.println("datetime ref: " + LocalDateTime.now() + "\n");
		System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
		
		//--------------------------------------------------------------------------------------SETUP
		
		// Load map containing locators and input values
		PropertiesReader properties = PropertiesReader.getInstance();
		
		// Files + Desired Capabilities
		File appDir = new File("src");
		File app = new File(appDir, "app-2.21.10-66.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		//--------------------------------------------------------------------------------------VARS
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("\t...status: "+properties.get("appLaunchedMssg"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean cardOnFile = false;
		
		//--------------------------------------------------------------------------------------TEST
		
		// -- click navbar element
		try {
			WebElement navBarElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.className(properties.get("navBarClass"))));
			navBarElem.click();
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("navBarClickedMssg"));
		
		// -- click 'Manage Cards' from nav bar
		try {
			WebElement navCardsElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.name(properties.get("navCardsName"))));
			navCardsElem.click();
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("navCardsClickedMssg"));
		
		// -- click 'Sign In'
		try {
			WebElement linkSigninElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.id(properties.get("linkSigninID"))));
			linkSigninElem.click();
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("navSigninClickedMssg"));
		
		// -- enter input [email]
		try {
			WebElement inputEmailElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.id(properties.get("inputEmailID"))));
			inputEmailElem.sendKeys(properties.get("emailStr"));
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("enteredEmailMssg"));
		
		// -- enter input [password]
		try {
			WebElement inputPassElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.id(properties.get("inputPassID"))));
			inputPassElem.sendKeys(properties.get("passStr"));
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("enteredPassMssg"));
		
		// -- click 'Sign In' button
		try {
			WebElement submitLoginElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.id(properties.get("submitLoginID"))));
			submitLoginElem.click();
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("btnSignInClickedMssg"));
		
		// -- print account details for reference
		try {
			WebElement logoutLinkElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.id(properties.get("logoutLinkID"))));
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		String accountNameDisplayIDText = driver.findElementById(properties.get("accountNameDisplayID")).getText();
		String accountEmailDisplayIDText = driver.findElementById(properties.get("accountEmailDisplayID")).getText();
		String accountPhoneDisplayIDText = driver.findElementById(properties.get("accountPhoneDisplayID")).getText();
		System.out.println("\t\t> account name: "+accountNameDisplayIDText);
		System.out.println("\t\t> account email: "+accountEmailDisplayIDText);
		System.out.println("\t\t> account phone: "+accountPhoneDisplayIDText);
		
		// -- click navbar element
		try {
			WebElement navBarElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.className(properties.get("navBarClass"))));
			navBarElem.click();
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("navBarClickedMssg"));
		
		// -- click 'Manage Cards' from nav bar
		try {
			WebElement navCardsElem = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.name(properties.get("navCardsName"))));
			navCardsElem.click();
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		System.out.println("\t...status: "+properties.get("navCardsClickedMssg"));
	
		// -- check if account has at least 1 card on file
		try {
			if (!driver.findElements(By.id(properties.get("submitNextID"))).isEmpty()) {
				cardOnFile = false;
			} else if (!driver.findElements(By.name(properties.get("addPayCardName"))).isEmpty()) {
				cardOnFile = true;
			} 
		} catch (Exception e) {
			System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		} 
		System.out.println("\t...status: card on file="+cardOnFile);
		
//		// -- add new card (using if/else if for 2 possible flows)
//		if (cardOnFile) {
//			// --/-- click button to 'Add Payment Card'
//			try {
//				WebElement addPayCardElem = wait.until(
//				        ExpectedConditions.visibilityOfElementLocated(By.className(properties.get("addPayCardName"))));
//				addPayCardElem.click();
//			} catch (NoSuchElementException e) {
//				System.out.println("\n\nERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
//				System.out.println("\t...exiting program.");
//				System.exit(0);
//			}
//			System.out.println("\t...status: "+properties.get("btnAddPayCardClickedMssg"));
//		}
		
		
		System.out.println("DONE for now.");
		driver.quit();
	}
}

/*
 Not working, seriously need to incorporate helper methods and WAITS!
 
 public WebElement getWhenVisible(By locator, int timeout) {
    WebElement element = null;
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return element;
}

public void clickWhenReady(By locator, int timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    element.click();
}

http://stackoverflow.com/questions/12041013/selenium-webdriver-fluent-wait-works-as-expected-but-implicit-wait-does-not
 */
