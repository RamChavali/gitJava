package testcases;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.OnboardingPage;
import objectsrepo.StoresPage;

@SuppressWarnings("unused")
public class skipOnboarding {

	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	private WebDriver driver;

	@Test
	public void skipOnboarding() throws Exception
	{
		// setup
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		WebDriverWait wait = new WebDriverWait(driver, 20);
	
		// page
		OnboardingPage onboardPage = new OnboardingPage(driver);
		StoresPage storesPage = new StoresPage(driver);
		
		// page actions
		onboardPage.gotItBtn().click();
	}
}
