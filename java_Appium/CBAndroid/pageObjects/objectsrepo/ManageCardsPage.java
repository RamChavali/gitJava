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
		//--------------------------------------------------------------------------------- [FIRST CARD FLOW]
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
		//--------------------------------------------------------------------------------- [ADDITIONAL CARD FLOW]
		public void enterAdditionalBillingAddr()
			{
				if (checkIfElemExists(wait, properties.get("addCardAddNewAddrId"))) 
				{
					clickById(wait, properties.get("addCardAddNewAddrId"));
					this.enterFirstBillingAddr();
				}
			}
		public void selectExistingBillingAddr()
			{
				clickByName(wait, properties.get("manageAddPaymentCardBtnName"));
				this.addFirstPaymentCard();
				clickById(wait, properties.get("addCardSelectExistingAddrId"));
				clickById(wait, properties.get("addCardSelectExistingAddrBtn"));
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		public void addAdditionalPaymentCard() 
			{			
				clickByName(wait, properties.get("manageAddPaymentCardBtnName"));
				this.addFirstPaymentCard();
			}
		//--------------------------------------------------------------------------------- [ADD PROCESS]
		public void clickToVerifyAddress() 
			{
				clickById(wait, properties.get("addCardAddrAddBtnId"));
			}
		public void clickAgainToAddCard() 
			{
				clickById(wait, properties.get("addCardAddrAddBtnId"));
			}
		//--------------------------------------------------------------------------------- [MEETING PRECONDITIONS]
		public void removePaymentCardsAll() 
			{			
				while (checkIfElemExists(wait, properties.get("manageCardRemoveXId"))) 
					{
						clickById(wait, properties.get("manageCardRemoveXId"));
					}
			}
		public void addPaymentCardIfNoneOnFile() 
			{
				if (!checkIfElemExists(wait, properties.get("manageCardRemoveXId"))) 
					{
						this.addFirstPaymentCard();
						this.enterFirstBillingAddr();
						this.clickToVerifyAddress();
						this.clickAgainToAddCard();
					}
			}
		//--------------------------------------------------------------------------------- [ADDING MULTIPLE FLOW]
		public void addFirstTwoPaymentCards() 
			{			
				this.addFirstPaymentCard();			// adding 1st card
				this.enterFirstBillingAddr();
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
				this.addAdditionalPaymentCard();	// adding 2nd card
				this.enterAdditionalBillingAddr();
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		public void addAdditionalTwoPaymentCards() 
			{		
				int numAdd = 0;
				while (numAdd < 2) 
					{
						this.addAdditionalPaymentCard();
						this.enterAdditionalBillingAddr();
						this.clickToVerifyAddress();
						this.clickAgainToAddCard();
						numAdd++;
					}
			}
		//--------------------------------------------------------------------------------- [DATA VALIDATION]
		public void addPayCard_invalidCardNum() 
			{
				enterInputById(wait, properties.get("addCardNumId"), properties.get("ccNumWrongStr")); // here
				enterInputById(wait, properties.get("addCardExpId"), properties.get("ccExpStr"));
				enterInputById(wait, properties.get("addCardCCVId"), properties.get("ccCVVStr"));
				clickById(wait, properties.get("addCardNextBtnId"));
				this.enterFirstBillingAddr();
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		public void addPayCard_invalidCardExpDate() 
			{
				enterInputById(wait, properties.get("addCardNumId"), properties.get("ccNumStr"));
				enterInputById(wait, properties.get("addCardExpId"), properties.get("ccExpWrongStr")); // here
				enterInputById(wait, properties.get("addCardCCVId"), properties.get("ccCVVStr"));
				clickById(wait, properties.get("addCardNextBtnId"));
				this.enterFirstBillingAddr();
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		public void addPayCard_invalidCardCVV() 
			{
				enterInputById(wait, properties.get("addCardNumId"), properties.get("ccNumStr"));
				enterInputById(wait, properties.get("addCardExpId"), properties.get("ccExpStr"));
				enterInputById(wait, properties.get("addCardCCVId"), properties.get("ccCVVWrongStr")); // here
				clickById(wait, properties.get("addCardNextBtnId"));
				this.enterFirstBillingAddr();
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		public void addPayCard_invalidStreet() 
			{
				this.addFirstPaymentCard();
				enterInputById(wait, properties.get("addCardAddrFirstId"), properties.get("firstNameStr"));
				enterInputById(wait, properties.get("addCardAddrLastId"), properties.get("lastNameStr"));
				enterInputById(wait, properties.get("addCardAddrStreetId"), properties.get("streetStrWrongStr")); // here
				enterInputById(wait, properties.get("addCardAddrCityId"), properties.get("cityStr"));
				enterInputById(wait, properties.get("addCardAddrZipcodeId"), properties.get("zipStr"));
				clickById(wait, properties.get("addCardAddrAddBtnId"));
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		public void addPayCard_invalidCity() 
			{	
				this.addFirstPaymentCard();
				enterInputById(wait, properties.get("addCardAddrFirstId"), properties.get("firstNameStr"));
				enterInputById(wait, properties.get("addCardAddrLastId"), properties.get("lastNameStr"));
				enterInputById(wait, properties.get("addCardAddrStreetId"), properties.get("streetStr"));
				enterInputById(wait, properties.get("addCardAddrCityId"), properties.get("cityWrongStr")); // here
				enterInputById(wait, properties.get("addCardAddrZipcodeId"), properties.get("zipStr"));
				clickById(wait, properties.get("addCardAddrAddBtnId"));
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		public void addPayCard_invalidZip() 
			{
				this.addFirstPaymentCard();
				enterInputById(wait, properties.get("addCardAddrFirstId"), properties.get("firstNameStr"));
				enterInputById(wait, properties.get("addCardAddrLastId"), properties.get("lastNameStr"));
				enterInputById(wait, properties.get("addCardAddrStreetId"), properties.get("streetStr"));
				enterInputById(wait, properties.get("addCardAddrCityId"), properties.get("cityStr"));
				enterInputById(wait, properties.get("addCardAddrZipcodeId"), properties.get("zipWrongStr")); // here
				clickById(wait, properties.get("addCardAddrAddBtnId"));
				this.clickToVerifyAddress();
				this.clickAgainToAddCard();
			}
		
		// TODO - add todo items here
	}
