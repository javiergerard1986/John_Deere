package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.SellingTermToOffer;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.preoffer.CreatePriceSellingTermPage;
import com.johndeere.pages.preoffer.PreOfferRecordPage;

public class CreateSellingTermToOfferTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateSellingTermToOfferTest instance;

		public static CreateSellingTermToOfferTest getInstance() {

			if (instance == null) {

				instance = new CreateSellingTermToOfferTest();

			}

			return instance;

		}

	private CreateSellingTermToOfferTest() {
		
		
		
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private PreOfferRecordPage preOfferRecordPage;
	private CreatePriceSellingTermPage createPriceSellingTermPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create selling term to offer
	 * @param sellingTermToOFFER - (SellingTermToOffer) this is the selling term to add to the pre offer
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 */
	public boolean createSellingTermToOffer(SellingTermToOffer sellingTermToOffer, Logger logger){
			
		//Prepare environment
		this.prepareEnvironment();
				
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
				
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
		
		logger.log("Searching and accessing into the Pre Offer Record page");
		this.homePage.searchAndAccessIntoRecordPage(driver, "PreOffer", sellingTermToOffer.getPreOfferName());
		
		logger.log("Navigating into the create Pre Defined Price Selling Terms page");
		preOfferRecordPage.navigateToCreatePriceSellingTerm();
		
		logger.log("Creating a new Pre Defined Price Selling Term");
		createPriceSellingTermPage.createPreDefinedPriceSellingTerm(driver, sellingTermToOffer.getSellingTerm(), sellingTermToOffer.getPreOfferName(),  sellingTermToOffer.getMdpPrice(), sellingTermToOffer.getMsrp(), sellingTermToOffer.getStartOfQuantity(), sellingTermToOffer.getEndOfQuantity());
		
		if(this.checkResult("Error")){
			
			logger.log("Something happens when you tried to create the Pre Defined Price Selling Term. Please debug it and search the problem");
			return false;
			
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
		this.preOfferRecordPage = PageFactory.initElements(driver, PreOfferRecordPage.class);
		this.createPriceSellingTermPage = PageFactory.initElements(driver, CreatePriceSellingTermPage.class);
		
	}
	
}