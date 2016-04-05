package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.LoginPage;
import objectsrepo.PropertiesReader;
import utilities.AppiumServer;

public class validLogin_afterLogoutSameAcct {
	PropertiesReader properties = PropertiesReader.getInstance();
	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	AppiumServer server=new AppiumServer(); 
	DesiredCapabilities cap = new DesiredCapabilities();
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		server.stopServer(); // add if statement?
		server.startServer(); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
	}
	
	@Test
	public validLogin_afterLogoutSameAcct() throws Exception
	{
		this.setUp();
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navToSigninScreen();
		loginPage.signinUsingValidCredentials();
		loginPage.logout();
		loginPage.navToSigninScreenAfterLoggingOut();
		loginPage.signinUsingValidCredentials(); // logging in with same credentials
		this.tearDown();
	}
	
	@AfterClass
	public void tearDown() {
		server.stopServer();
	}
}
