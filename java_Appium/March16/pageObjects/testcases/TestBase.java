package testcases;
import java.io.File;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TestBase {

	static AndroidDriver driver;
//	PropertiesReader uiMap;
	
	@BeforeMethod
	public void houseWork() throws Exception {
//		uiMap = PropertiesReader.getInstance();
		// Files + Desired Capabilities
		File appDir = new File("src");
		File app = new File(appDir, "app-2.21.10-66.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
	}
}

