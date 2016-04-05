package testcases;
import java.io.File;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.LoginPage;
import objectsrepo.ManageCardsPage;
import objectsrepo.PropertiesReader;

public class addCardData_invalidExpDate {
	PropertiesReader properties = PropertiesReader.getInstance();
	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	
	@Test
	public addCardData_invalidExpDate() throws Exception
	{
		// setup
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
	
		// pages
		LoginPage loginPage = new LoginPage(driver);
		ManageCardsPage manageCardsPage = new ManageCardsPage(driver);
		
		// TEST
		loginPage.navToSigninScreen();
		loginPage.signinUsingValidCredentials();
		manageCardsPage.navToManageCardsScreen();
		manageCardsPage.removePaymentCardsAll();
		manageCardsPage.addPayCard_invalidCardExpDate();
		
		// TODO - assert error message invoked, "Credit card validation failed."
	}
}