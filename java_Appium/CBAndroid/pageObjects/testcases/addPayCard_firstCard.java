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
import objectsrepo.PropertiesReader;
import objectsrepo.LoginPage;
import objectsrepo.ManageCardsPage;
import utilities.AppiumServer;

public class addPayCard_firstCard {
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
	public addPayCard_firstCard() throws Exception
	{
		this.setUp();
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		LoginPage loginPage = new LoginPage(driver);
		ManageCardsPage manageCardsPage = new ManageCardsPage(driver);
		loginPage.navToSigninScreen();
		loginPage.signinUsingValidCredentials();
		manageCardsPage.navToManageCardsScreen();
		manageCardsPage.removePaymentCardsAll();
		manageCardsPage.addFirstPaymentCard();
		manageCardsPage.enterFirstBillingAddr();
		manageCardsPage.clickToVerifyAddress();
		manageCardsPage.clickAgainToAddCard();	
		this.tearDown();
	}
	
	@AfterClass
	public void tearDown() {
		server.stopServer();
	}
}