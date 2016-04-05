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

public class addCardData_invalidCity {
	PropertiesReader properties = PropertiesReader.getInstance();
	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	
	@Test
	public addCardData_invalidCity() throws Exception
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
		manageCardsPage.addPayCard_invalidCity();
		
		// TODO - assert error message invoked, "Please try again."
		// TODO - auto fixes city, is this expected?
	}
}

/*
[{
	"first_name": "Jane",
	"last_name": "Prod",
	"type": "VISA",
	"last_4": "7433",
	"exp_month": 1,
	"exp_year": 2018,
	"address": {
		"state": "CA",
		"line_2": "",
		"zipcode": "94306",
		"country": "US",
		"line_1": "260 Sheridan Ave Ste 300",
		"city": "Palo Alto",  <<<------------------ auto fixes?
		"barcode": null
	},
	"pin_required": false,
	"addr_validated": true,
	"users_id": 318591,
	"card_icon_url": "http://cdn-s.shopcurbside.com.s3.amazonaws.com/creditcardicons/visa",
	"id": 162002,
	"created_at": "2016-04-02T05:31:32.329Z"
}]
*/