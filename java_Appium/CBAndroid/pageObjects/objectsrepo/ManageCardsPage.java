package objectsrepo;

import org.openqa.selenium.WebDriver;

public class ManageCardsPage extends BasePage 
	{
		// SETUP
		PropertiesReader properties = PropertiesReader.getInstance();
		public ManageCardsPage(WebDriver driver) throws Exception 
			{
				super(driver);
			}
		
		// METHODS
		public void navToManageCardsScreen() 
			{			
				clickByClassName(wait, properties.get("navBarClass"));
				clickByName(wait, properties.get("navManageCardsName"));
			}
		public void addFirstPaymentCard() 
			{			
				enterInputById(wait, properties.get("addCardNumId"), properties.get("ccNumStr"));
				enterInputById(wait, properties.get("addCardExpId"), properties.get("ccExpStr"));
				enterInputById(wait, properties.get("addCardCCVId"), properties.get("ccCVVStr"));
				clickById(wait, properties.get("addCardNextBtnId"));
				
			}
		public void enterFirstBillingAddr()
			{
				enterInputById(wait, properties.get("addCardAddrFirstId"), properties.get("firstNameStr"));
				enterInputById(wait, properties.get("addCardAddrLastId"), properties.get("lastNameStr"));
				enterInputById(wait, properties.get("addCardAddrStreetId"), properties.get("streetStr"));
				enterInputById(wait, properties.get("addCardAddrCityId"), properties.get("cityStr"));
				enterInputById(wait, properties.get("addCardAddrZipcodeId"), properties.get("zipStr"));
				clickById(wait, properties.get("addCardAddrAddBtnId"));
			}
		public void clickToVerifyAddress() 
			{
				clickById(wait, properties.get("addCardAddrAddBtnId"));
			}
		public void clickAgainToAddCard() 
			{
				clickById(wait, properties.get("addCardAddrAddBtnId"));
			}
		
		public void removePaymentCardsAll() 
			{			
				while (checkIfElemExists(wait, properties.get("manageCardRemoveXId"))) 
					{
						clickById(wait, properties.get("manageCardRemoveXId"));
					}
			}
		public void addAdditionalPaymentCard() 
			{			
				clickByName(wait, properties.get("manageAddPaymentCardBtnName"));
				this.addFirstPaymentCard();
			}
		
		
		
//		public void addFirstTwoPaymentCards() 
//			{			
//				this.addFirstPaymentCard();
//				this.navToManageCardsScreen();
//				this.addAdditionalPaymentCard();
//			}
//		public void addAdditionalTwoPaymentCards() 
//			{			
//				int numAdd = 2;
//				while (numAdd<=2) 
//					{
//						this.addAdditionalPaymentCard();
//					}
//				
//			}
//		public void removePaymentCard() 
//			{			
//				
//			}

//		public void cardOnFile() 
//			{
////				checkIfElemExists(wait, properties.get("manageCardLastFourId"));
//			}


		
		
		
		
		
		
		// TODO - add todo items here
	}
