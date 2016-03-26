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

@SuppressWarnings("unused")
public class test{

	@Test
	public void test() throws Exception {
		
		PropertiesReader properties = PropertiesReader.getInstance();
		String cardToBeRemoved;
		boolean cardOnFile = false;
		
		// Files + Desired Capabilities
		File appDir = new File("src");
		File app = new File(appDir, "app-2.21.10-66.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		// Instantiate new driver object.
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		
		// ---------------------------------------------------------------------- [1] message 
		
		// Print datetime for reference.
		System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
		System.out.println("datetime ref: " + LocalDateTime.now() + "\n");
		System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
		
		// ---------------------------------------------------------------------- [2] login
		
		// Check that navbar element is visible.
		try {
			driver.findElements(By.className(properties.get("navBarClass")));
			System.out.println("\t...navigating user to login screen");
		} catch (NoSuchElementException e) {
			System.out.println("ERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}	
		
		// Navigate to login screen & Login.
		driver.findElementByClassName(properties.get("navBarClass")).click();
		driver.findElementByName(properties.get("navAccountName")).click();
		driver.findElementById("com.curbside.nCurbside:id/button_sign_in").click();
		driver.findElementById(properties.get("inputEmailID")).sendKeys(properties.get("emailStr"));
		driver.findElementById(properties.get("inputPassID")).sendKeys(properties.get("passStr"));
		driver.findElementById(properties.get("submitLoginID")).click();
		
		// Check that login is successful.
		try {
			driver.findElementById(properties.get("logoutLinkID"));
			System.out.println("\t...login successful");
		} catch (NoSuchElementException e) {
			System.out.println("ERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		
		// ---------------------------------------------------------------------- [3] cards
		
		// Check that navbar element is visible.
		try {
			driver.findElements(By.className(properties.get("navBarClass")));
			System.out.println("\t...navigating user to manage cards");
		} catch (NoSuchElementException e) {
			System.out.println("ERROR: " + e.getMessage().substring(0, e.getMessage().indexOf('.')+1));
			System.out.println("\t...exiting program.");
			System.exit(0);
		}
		
		// Navigate to manage cards screen & check if card(s) on file. 
		driver.findElementByClassName(properties.get("navBarClass")).click();
		driver.findElementByName(properties.get("navCardsName")).click();
		if (!driver.findElements(By.id(properties.get("submitNextID"))).isEmpty() ||
			!driver.findElements(By.id(properties.get("removeCardID"))).isEmpty()) {
			//what to add here? apparently works without populating?
		} else {
			throw new Exception ("\t...unable to verify if card(s) on file");
		}
		
		// Adding to print card on file.
		if (driver.findElements(By.id(properties.get("submitNextID"))).isEmpty()) {
			System.out.format("\t\t...verdict: Card on file, %s.", driver.findElementById(properties.get("viewCCTextID")).getText());
		} else if (driver.findElements(By.id(properties.get("removeCardID"))).isEmpty()) {
			System.out.println("\t\t...verdict: No card on file.");
		} else {
			throw new Exception ("\t...unable to verify status.");
		}
		
		// Will Return.
		System.out.println(">> reached a stopping point, will return.");
	}

}
