package testcases;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.LoginPage;
import objectsrepo.PropertiesReader;

public class loginInvalid_both {
	PropertiesReader properties = PropertiesReader.getInstance();
	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	
	@Test
	public loginInvalid_both() throws Exception
	{
		// setup
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
	
		// pages
		LoginPage loginPage = new LoginPage(driver);
		
		// TEST - User should not be able to login using INVALID e-mail and INVALID password.
		loginPage.navToSigninScreen();
		loginPage.signinUsingInvalidBoth();
	}
}
