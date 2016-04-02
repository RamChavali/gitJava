package testcases;
import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.ForgotPassPage;
import objectsrepo.PropertiesReader;

public class forgotPass_validEmailNonUser {
	PropertiesReader properties = PropertiesReader.getInstance();
	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	
	@Test
	public forgotPass_validEmailNonUser() throws Exception
	{
		// setup
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
	
		// pages
		ForgotPassPage forgotPassPage = new ForgotPassPage(driver);
		
		// TEST - Reset password feature should not work for valid email from NON-USER.
		forgotPassPage.navToForgotPassScreen();
		forgotPassPage.resetPassUsingValidEmailNonUser();
		
		// TODO - assert error "Please try again"
	}
}