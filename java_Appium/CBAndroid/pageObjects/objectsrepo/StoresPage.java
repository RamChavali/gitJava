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
		
		// ############################################################################# [1] NAVIGATION
		public void navToStoresPage() 
			{		
				clickById(wait, properties.get("gotItID"));
				clickByClassName(wait, properties.get("navBarClass"));
				clickByName(wait, properties.get("navStoresName"));
			}
		
		// ############################################################################# [2] ENVIRONMENT
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
		
		// ############################################################################# [3] UI
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
		
		// ############################################################################# [4] UI - STORE FRAME
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
		
		// ############################################################################# [5] HEADER SECTION
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
				scrollToElementUsingId(properties.get("categoryAll"));
				clickByName(wait, properties.get("categoryAll"));
			}
		
		
		// ############################################################################# [6] ADD CART FLOWS
		public void addCartWithPlusIcon()
			{
				scrollToElement(properties.get("addCartHintDollar"));
				clickById(wait, properties.get("addCartFromStoreId"));
			}
		
		// add cart from Product Detail Page 
		// TODO - research this issue
		// https://github.com/havefuncoding/gitJava/issues/14
		public void addCartFromProductDetailPage() throws InterruptedException 
			{
				scrollToElement(properties.get("addCartHintDollar"));
				clickByClassName(wait, properties.get("retailerPageProductFrameClassName"));
				clickById(wait, properties.get("addCartFromProductDetailId"));
			}
		
		// search for water
		public void searchForWater() 
			{
				clickById(wait, properties.get("searchBarId"));
				enterInputById(wait, properties.get("searchBarId"), properties.get("addCartFromSearchStoreLevelValue")+"\n");
			}
		// reaching categories level
		public void navToCateogryLevelTargetBeverages() 
			{
				clickByName(wait, properties.get("targetTestingStoreName"));
				clickByName(wait, properties.get("targetTestingStoreParentCategoryName"));
				clickByName(wait, properties.get("targetTestingStoreChildCategoryName"));
				
			}
/*		
 * TODO - need to loop through and scroll to next element until param met
 * 	// add from search at mall level
		public void navToMallStore() 
			{
				scrollToExactElement(properties.get("targetTestingMallName"));
				clickByName(wait, properties.get("targetTestingMallName"));
			}*/
			
		
		// ############################################################################# [7] REMOVE FLOWS
		public void removeWithPlusIcon() 
			{
				this.addCartWithPlusIcon();
			}
		public void removeFromProductDetailPage()
			{
				scrollToElement(properties.get("addCartHintDollar"));
				clickByClassName(wait, properties.get("retailerPageProductFrameClassName"));
				clickById(wait, properties.get("productDetailQtyDropdownId"));
				clickById(wait, properties.get("productDetailQtyDropdownTrashIconId"));
			}
		public void removeFromCartPage() 
			{
				clickById(wait, properties.get("storesCartIconId"));
				clickById(wait, properties.get("productDetailQtyDropdownId"));
				clickById(wait, properties.get("productDetailQtyDropdownTrashIconId"));
			}
		
		// ############################################################################# [8] CHANGE QTY FLOWS
		public void changeQtyFromProductDetailPage()
			{
				clickById(wait, properties.get("storesCartIconId"));
				clickById(wait, properties.get("productDetailQtyDropdownId"));
				clickByName(wait, properties.get("diffQuantityValue"));
			}
		public void changeQtyFromCartPage()
			{
				//add
			}
		
		
	}
