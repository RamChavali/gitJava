import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class add_addCreditCard {

	@SuppressWarnings("unchecked")
	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		// Files + Desired Capabilities
		File appDir = new File("src");
		File app = new File(appDir, "app-2.21.10-66.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Input Data
		@SuppressWarnings("rawtypes")
		Dictionary inputMap = new Hashtable();
		inputMap.put("email", "*****");
		inputMap.put("pass", "*****");
		inputMap.put("ccNum", "*****");
		inputMap.put("ccExp", "*****");
		inputMap.put("ccCVV", "*****");
		inputMap.put("phoneNum", "*****");
		inputMap.put("firstName", "*****");
		inputMap.put("lastName", "*****");
		inputMap.put("street", "*****");
		inputMap.put("city", "*****");
		inputMap.put("zip", "*****");
		
		// Locators
		@SuppressWarnings("rawtypes")
		Dictionary uiMap = new Hashtable();
		uiMap.put("gotItID", "com.curbside.nCurbside:id/button_got_it");
		uiMap.put("navBarClass", "android.widget.ImageButton");
		uiMap.put("navAccountName", "My Account");
		uiMap.put("linkSigninID", "com.curbside.nCurbside:id/button_sign_in");
		uiMap.put("inputEmailID", "com.curbside.nCurbside:id/edit_email");
		uiMap.put("inputPassID", "com.curbside.nCurbside:id/edit_password");
		uiMap.put("submitLoginID", "com.curbside.nCurbside:id/button_sign_in");
		uiMap.put("navCardsName", "Manage Cards");
		uiMap.put("inputCCNumID", "com.curbside.nCurbside:id/edit_card_number");
		uiMap.put("inputCCExpID", "com.curbside.nCurbside:id/edit_expiration");
		uiMap.put("inputCVVID", "com.curbside.nCurbside:id/edit_cvv");
		uiMap.put("submitNextID", "com.curbside.nCurbside:id/button_add_card");
		uiMap.put("inputFirstnID", "com.curbside.nCurbside:id/edit_first_name");
		uiMap.put("inputLastnID", "com.curbside.nCurbside:id/edit_last_name");
		uiMap.put("inputStreetID", "com.curbside.nCurbside:id/edit_street");
		uiMap.put("inputCityID", "com.curbside.nCurbside:id/edit_city");
		uiMap.put("inputZipID", "com.curbside.nCurbside:id/edit_zip");
		uiMap.put("submitAddID", "com.curbside.nCurbside:id/button_add_card");
		
		// TEST
		driver.findElementById((String) uiMap.get("gotItID")).click();
		driver.findElementByClassName((String) uiMap.get("navBarClass")).click();
		driver.findElementByName((String) uiMap.get("navAccountName")).click();
		driver.findElementById((String) uiMap.get("linkSigninID")).click();
		driver.findElementById((String) uiMap.get("inputEmailID")).sendKeys((String) inputMap.get("email"));
		driver.findElementById((String) uiMap.get("inputPassID")).sendKeys((String) inputMap.get("pass"));
		driver.findElementById((String) uiMap.get("submitLoginID")).click();
		driver.findElementByClassName((String) uiMap.get("navBarClass")).click();
		driver.findElementByName((String) uiMap.get("navCardsName")).click();
		driver.findElementById((String) uiMap.get("inputCCNumID")).sendKeys((String) inputMap.get("ccNum"));
		driver.findElementById((String) uiMap.get("inputCCExpID")).sendKeys((String) inputMap.get("ccExp"));
		driver.findElementById((String) uiMap.get("inputCVVID")).sendKeys((String) inputMap.get("ccCVV"));
		driver.findElementById((String) uiMap.get("submitNextID")).click();
		
		driver.findElementById((String) uiMap.get("inputFirstnID")).sendKeys((String) inputMap.get("firstName"));
		driver.findElementById((String) uiMap.get("inputLastnID")).sendKeys((String) inputMap.get("lastName"));
		driver.findElementById((String) uiMap.get("inputStreetID")).sendKeys((String) inputMap.get("street"));
		driver.hideKeyboard();
		driver.findElementById((String) uiMap.get("inputCityID")).sendKeys((String) inputMap.get("city"));
		driver.hideKeyboard();
		driver.findElementById((String) uiMap.get("inputZipID")).sendKeys((String) inputMap.get("zip"));
		driver.hideKeyboard();
		driver.findElementById((String) uiMap.get("submitAddID")).click();
		Thread.sleep(200);
		driver.findElementById((String) uiMap.get("submitAddID")).click();
	}

}
