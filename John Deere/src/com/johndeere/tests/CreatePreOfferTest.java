package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.PreOffer;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.preoffer.CreatePreOfferPage;
import com.johndeere.pages.preoffer.CreatePriceSellingTermPage;
import com.johndeere.pages.preoffer.PreOfferAddUsersPage;
import com.johndeere.pages.preoffer.PreOfferRecordPage;
import com.johndeere.pages.preoffer.PreOfferSharingsPage;
import com.johndeere.pages.preoffer.PreOfferTypePage;
import com.johndeere.pages.preoffer.PreOffersPage;

public class CreatePreOfferTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreatePreOfferTest instance;

		public static CreatePreOfferTest getInstance() {

			if (instance == null) {

				instance = new CreatePreOfferTest();

			}

			return instance;

		}

	private CreatePreOfferTest() {
		
		
		
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private PreOffersPage preOffersPage;
	private PreOfferTypePage preOfferTypePage;
	private CreatePreOfferPage createPreOfferPage;
	private PreOfferRecordPage preOfferRecordPage;
	private CreatePriceSellingTermPage createPriceSellingTermPage;
	private PreOfferSharingsPage preOfferSharingsPage;
	private PreOfferAddUsersPage preOfferAddUsersPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create pre offers
	 * @param preOffer - (PreOffer)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 */
	public boolean createPreOffer(PreOffer preOffer, Logger logger){
			
		//Prepare environment
		this.prepareEnvironment();
				
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
				
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
		
		logger.log("Creating new Pre Offer");
		homePage.navigateToPreOffersPage(driver);
		
		logger.log("Selecting pre offer type");
		preOffersPage.navigateIntoSelectPreOfferTypePage();
		preOfferTypePage.selectPreOfferType(preOffer.getPreOfferType());
		
		logger.log("Providing required data in the Create Pre Offer page");
		createPreOfferPage.createPreOffer(preOffer);
		
		logger.log("Navigating into the create Pre Defined Price Selling Terms page");
		preOfferRecordPage.navigateToCreatePriceSellingTerm();
		
		logger.log("Creating a new Pre Defined Price Selling Term");
		createPriceSellingTermPage.createPreDefinedPriceSellingTerm(driver, preOffer.getSellingTerm(), preOffer.getPreOfferName(),  preOffer.getMdpPrice(), preOffer.getMsrp(), preOffer.getStartOfQuantity(), preOffer.getEndOfQuantity());
		
		logger.log("Navigating to the Create / Edit PreOffer page, to publish the pre offer");
		preOfferRecordPage.navigateToCreateEditPreOfferPage();
		
		logger.log("Publishing pre offer");
		createPreOfferPage.publishPreOffer();
		
		if(!preOffer.getGroupName().equals("")){
		
			logger.log("Navigating to Pre Offer Sharings page");
			preOfferRecordPage.navigateToSharePreOfferPage();
			
			logger.log("Navigating to Pre Offer Add Users page");
			preOfferSharingsPage.navigatToAddUsersToPreOfferPage();
			
			logger.log("Addings groups and users to the pre offer");
			preOfferAddUsersPage.sharePreOfferWithUsersGroups(driver, preOffer);
			
			if(this.checkResult("New Sharing")){
				
				logger.log("Something happened when you tried to add users or / and groups to this preOffer. Please debug it and search the problem");
				return false;
				
			}
			
		}else{
			
			if(this.checkResult("Pre Offer Edit")){
				
				logger.log("Something happened when you tried to publish the pre offer");
				return false;
				
			}
		
		}
		
		logger.log("Log out from system");
		homePage.logout();
		
		return true;
		
	}
	
	/**
	 * Function to initialize environments
	 */
	@Override
	public void prepareEnvironment(){
		
		this.Initialize();
		this.loginPage = PageFactory.initElements(driver, LoginPage.class);	
		this.homePage = PageFactory.initElements(driver, HomePage.class);
		this.preOffersPage = PageFactory.initElements(driver, PreOffersPage.class);
		this.preOfferTypePage = PageFactory.initElements(driver, PreOfferTypePage.class);
		this.createPreOfferPage = PageFactory.initElements(driver, CreatePreOfferPage.class);
		this.preOfferRecordPage = PageFactory.initElements(driver, PreOfferRecordPage.class);
		this.createPriceSellingTermPage = PageFactory.initElements(driver, CreatePriceSellingTermPage.class);
		this.preOfferSharingsPage = PageFactory.initElements(driver, PreOfferSharingsPage.class);
		this.preOfferAddUsersPage = PageFactory.initElements(driver, PreOfferAddUsersPage.class);
		
	}
	
}