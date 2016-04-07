package testcases;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.PropertiesReader;
import objectsrepo.testPage_iOS;
import utilities.AppiumServer;

public class test_iOS {
	PropertiesReader properties = PropertiesReader.getInstance();
	File appDir = new File("src");
	File app = new File(appDir, "Curbside_simulator.app");
	AppiumServer server=new AppiumServer(); 
	DesiredCapabilities cap = new DesiredCapabilities();
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		server.stopServer(); // add if statement?
		server.startServer(); 
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "CS iPhone 6");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, properties.get("ios_deviceName"));
		//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("udid", properties.get("ios_udid")); // using device-preloaded
		cap.setCapability("bundleId", properties.get("ios_bundleId"));
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
	}
	@Test
	public test_iOS() throws Exception
	{
		this.setUp();
		//-------------->> setUp
		IOSDriver driver = new IOSDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		testPage_iOS tp = new testPage_iOS(driver);
		tp.navToMyAccountScreen();
		//tp.getCurrentPageSource();
		
		
		//-------------->> tearDown
		this.tearDown();
	}
	
	@AfterClass
	public void tearDown() {
		server.stopServer();
	}
	
}