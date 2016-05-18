package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.DealerPreOffer;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.community.CommunityHomePage;
import com.johndeere.pages.community.MyOffersPage;
import com.johndeere.pages.community.PublishPreOfferPage;
import com.johndeere.pages.contact.ContactRecordPage;


public class PublishOfferTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static PublishOfferTest instance;

	public static PublishOfferTest getInstance() {

		if (instance == null) {

			instance = new PublishOfferTest();

		}

		return instance;

	}

	private PublishOfferTest() {
			
			
			
	}
		
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactRecordPage contactRecordPage;
	private CommunityHomePage communityHomePage;
	private MyOffersPage myOffersPage;
	private PublishPreOfferPage publishPreOfferPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to publish an offer
	 * @param dealerPreOffer - (DealerPreOffer)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 * @throws Exception
	 */
	public boolean publishOffer(DealerPreOffer dealerPreOffer, Logger logger){

		//Prepare environment
		prepareEnvironment();
		
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
			
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
			
		logger.log("Searching and accessing into the Contact Record page");
		this.homePage.searchAndAccessIntoRecordPage(driver, "Contact", dealerPreOffer.getContactName());
		
		logger.log("Login with dealer user into the John Deere Community");
		this.contactRecordPage.loginIntoCommunity();
		
		logger.log("Navigating into the John Deere Community");
		this.communityHomePage.navigateToJohnDeereCommunity(driver);
		
		logger.log("Navigating into the " + dealerPreOffer.getPreOfferName() + " pre offer page");
		this.myOffersPage.navigateIntoPublishPreOfferPage(driver, dealerPreOffer.getPreOfferName());
		
		logger.log("Publishing pre offer");
		this.publishPreOfferPage.publishPreOffer();
		
		if(!this.checkResult("You have successfully saved your marketplace offering.")){
		
			logger.log("Error: we were not able to find the success publish message, please debug the problem");
			return false;
			
		}
		 
		logger.log("Log out from system");
		this.communityHomePage.logout(driver);
		
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
		this.contactRecordPage = PageFactory.initElements(driver, ContactRecordPage.class);
		this.communityHomePage = PageFactory.initElements(driver, CommunityHomePage.class);
		this.myOffersPage = PageFactory.initElements(driver, MyOffersPage.class);
		this.publishPreOfferPage = PageFactory.initElements(driver, PublishPreOfferPage.class);
		
	}
	
}