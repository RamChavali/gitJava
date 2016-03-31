package testcases;
import java.awt.im.spi.InputMethod;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.AccountPreLoginPage;
import objectsrepo.AddCardFirstPage;
import objectsrepo.AddCardSecondPage;
import objectsrepo.ManageCardsPage;
import objectsrepo.OnboardingPage;
import objectsrepo.PropertiesReader;
import objectsrepo.SelectBillingAddrPage;
import objectsrepo.StoresPage;

@SuppressWarnings("unused")
public class addCreditCard {
	
	// setup
	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	private WebDriver driver;

	// test status
	boolean testPass = false;
	
	@Test
	public void addCreditCardTest() throws Exception
	{
		// setup
		PropertiesReader properties = PropertiesReader.getInstance();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
	
		// page
		OnboardingPage onboardPage = new OnboardingPage(driver);
		StoresPage storesPage = new StoresPage(driver);
		AccountPreLoginPage accountPreLoginPage = new AccountPreLoginPage(driver);
		ManageCardsPage manageCardsPage = new ManageCardsPage(driver);
		AddCardFirstPage addCardFirstPage = new AddCardFirstPage(driver);
		AddCardSecondPage addCardSecondPage = new AddCardSecondPage(driver);
		SelectBillingAddrPage selectBillingAddrPage = new SelectBillingAddrPage(driver);
		
		// navigates to manage cards page
		onboardPage.gotItBtn().click();
		storesPage.navbar().click();
		storesPage.navMyAccount().click();
		accountPreLoginPage.signinLink().click();
		accountPreLoginPage.signinEmail().sendKeys(properties.get("emailStr"));
		accountPreLoginPage.signinPass().sendKeys(properties.get("passStr"));
		accountPreLoginPage.signinBtn().click();
		storesPage.navbar().click();
		storesPage.navManageCards().click();
		
		// checks if card existing on file
		if (!driver.findElements(By.id(properties.get("manageCardLastFourId"))).isEmpty()) {
			manageCardsPage.manageAddPaymentCardBtn().click();
		}
		
		// adds new credit card
		addCardFirstPage.addCardNum().sendKeys(properties.get("ccNumStr"));
		addCardFirstPage.addCardExp().sendKeys(properties.get("ccExpStr"));
		addCardFirstPage.addCardCCV().sendKeys(properties.get("ccCVVStr"));
		addCardFirstPage.addCardNextBtn().click();
		
		// checks if address on file
		if (driver.findElements(By.name(properties.get("enterBillingAddrHeaderName"))).isEmpty()) {
			selectBillingAddrPage.selectBillingAddrNewBtn().click();
		}
		
		// adds new address
		addCardSecondPage.addCardAddrFirst().sendKeys(properties.get("firstNameStr"));
		addCardSecondPage.addCardAddrLast().sendKeys(properties.get("lastNameStr"));
		addCardSecondPage.addCardAddrStreet().sendKeys(properties.get("addressStr"));
		addCardFirstPage.hideKeyboardIfPresent();
		addCardSecondPage.addCardAddrCity().sendKeys(properties.get("cityStr"));
		addCardFirstPage.hideKeyboardIfPresent();
		addCardSecondPage.addCardAddrZipcode().sendKeys(properties.get("zipStr"));
		addCardFirstPage.hideKeyboardIfPresent();
		addCardSecondPage.addCardAddrAddBtn().click(); // 1st click to validate address
		addCardSecondPage.addCardAddrAddBtn().click(); // 2nd click to actually submit
		
		// if user still on same page, clicks add button once more
		if (!driver.findElements(By.name(properties.get("selectBillingAddrHeaderName"))).isEmpty()) {
			addCardSecondPage.addCardAddrAddBtn().click();
		}
		
		// check for test status
		if (driver.findElementByName(properties.get("manageCardsHeaderName")) != null) {
			testPass = true;
		} 
		
		// print test result
		System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
		System.out.println("Test Status: " + testPass);
		System.out.println("\n" + new String(new char[100]).replace("\0", "-")+ "\n");
		
	}

}
