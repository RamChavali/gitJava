import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class desiredcapab {

	@Test
	public void test() throws MalformedURLException {
		
		// File
		File appDir = new File("src");
		File app = new File(appDir, "app-2.21.10-66.apk");
		
		// Desired Capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		
		// Test
		driver.findElementById("com.curbside.nCurbside:id/button_got_it").click();
		driver.findElementByClassName("android.widget.ImageButton").click();
		driver.findElementById("com.curbside.nCurbside:id/menurow_title").click();
		driver.findElementById("com.curbside.nCurbside:id/button_sign_in").click();
		driver.findElementById("com.curbside.nCurbside:id/edit_email").sendKeys("*****");
		driver.findElementById("com.curbside.nCurbside:id/edit_password").sendKeys("*****");
		driver.findElementById("com.curbside.nCurbside:id/button_sign_in").click();
	}

}
