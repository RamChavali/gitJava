package objectsrepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoresPage extends BasePage 
	{
		// SETUP
		PropertiesReader properties = PropertiesReader.getInstance();
		public StoresPage(WebDriver driver) throws Exception 
			{
				super(driver);
			}
		
		// METHODS
		public void navToStoresPage() 
			{		
				clickById(wait, properties.get("gotItID"));
				clickByClassName(wait, properties.get("navBarClass"));
				clickByName(wait, properties.get("navStoresName"));
			}
		public void accessDebugScreen() throws InterruptedException 
			{
				clickById(wait, properties.get("storesSearchIconId"));
				enterInputById(wait, properties.get("storesSearchIconId"), properties.get("envAccessStr")+"\n");
				if (!driver.findElements(By.className(properties.get("envAccessUnexpectedClassName"))).isEmpty()) {
					driver.navigate().back();
				}
			}
		public void invokeAPIHost()
			{
				clickByName(wait, properties.get("apiHostEndpointName"));
			}	
		public void enterQ1Env() 
			{
				getElemById(wait, properties.get("apiHostEditFieldId")).clear();
				enterInputById(wait, properties.get("apiHostEditFieldId"), properties.get("envQ1Str"));
				clickByName(wait, properties.get("apiHostEditOKName"));
			}
				
		
		// UI Check Methods - Header section
		public void checkForStoreHeaderSectionUI()
			{
				this.checkForHeaderSearchIconUI();
				this.checkForHeaderCartIconUI();
				this.checkForHeaderPickupLinkUI();
				this.checkForHeaderNearbyLinkUI();
				this.checkForHeaderMapLinkUI();
			}
		public boolean checkForHeaderSearchIconUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesSearchIconId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForHeaderCartIconUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesCartIconId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForHeaderPickupLinkUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesPickupLinkId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForHeaderNearbyLinkUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesNearbyLinkId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForHeaderMapLinkUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesMapLinkId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		
		// UI Check Methods - Store Frame
		public void checkForStoreFrameSectionUI() {
			this.checkForStoreFrameImageUI();
			this.checkForStoreFrameNameUI();
			this.checkForStoreFrameAddrUI();
			this.checkForStoreFrameReadyStatusUI();
			this.checkForStoreFrameDistanceUI();
			this.checkForStoreFrameCurbsideBadgeUI();
		}
		public boolean checkForStoreFrameImageUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesFrameImageId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForStoreFrameNameUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesFrameNameId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForStoreFrameAddrUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesFrameAddrId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForStoreFrameReadyStatusUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesFrameReadyStatusId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForStoreFrameDistanceUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesFrameDistanceId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		public boolean checkForStoreFrameCurbsideBadgeUI() {
			boolean elemUIVerified = false;
			if (checkIfElemExists(wait, properties.get("storesFrameBadgeViewId"))) {
				elemUIVerified = true;
			} 
			return elemUIVerified;
		}
		
		// Navigation Check Methods Header section
		public void checkForNavigationToAndBack() {
			this.navToAndBackFromNearbyLink();
			this.navToAndBackFromMapLink();
			this.navToAndFromCartLink();
		}
		public void navToAndBackFromNearbyLink() {
			clickById(wait, properties.get("storesNearbyLinkId"));
			driver.navigate().back();
		}
		public void navToAndBackFromMapLink() {
			clickById(wait, properties.get("storesMapLinkId"));
			driver.navigate().back();
		}
		public void navToAndFromCartLink() {
			clickById(wait, properties.get("storesCartIconId"));
			driver.navigate().back();
		}
		
		// navigates to first store frame
		public void clickOnFirstRetailerImage() 
			{
				//TODO - why this doesn't work:
				//clickById_atFirstIndex(wait, properties.get("retailerImageId"));	
				clickById(wait, properties.get("retailerImageId"));
			}
		
		// navigates to TARGET
				public void clickOnRetailerTarget() 
			{
				//TODO - why this doesn't work:
				//clickById_atFirstIndex(wait, properties.get("retailerImageId"));	
				scrollToElement(properties.get("addCartFromProductDetailStoreForTestingName"));
				clickByName(wait, properties.get("addCartFromProductDetailStoreForTestingName"));
			}
		
		// check that "All Cateogries" catoegory available
		public void checkForCategory_All()
			{
				scrollToExactElement(properties.get("categoryAll"));
				clickByName(wait, properties.get("categoryAll"));
			}
		
		// add cart from Store Page
		public void addCartFromStorePage()
			{
				scrollToElement(properties.get("addCartHintDollar"));
				clickById(wait, properties.get("addCartFromStoreId"));
			}
		
		// add cart from Product Detail Page 
		// TODO - research this issue
		// https://github.com/havefuncoding/gitJava/issues/14
		public void addCartFromProductDetailPage() throws InterruptedException 
			{
				Thread.sleep(2000);
				scrollToElement(properties.get("addCartHintDollar"));
//				scrollToExactElement(properties.get("categoryAll"));
				Thread.sleep(2000);
				clickByClassName(wait, properties.get("retailerPageProductFrameClassName"));
				Thread.sleep(2000);
//				driver.navigate().back();
//				clickByClassName(wait, properties.get("retailerPageProductFrameClassName"));
				clickById(wait, properties.get("addCartFromProductDetailId"));
			}
		
	}
