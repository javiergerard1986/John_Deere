package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.Dealer;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.community.CommunityHomePage;
import com.johndeere.pages.community.DealerAccountWorkflowPage;
import com.johndeere.pages.contact.ContactRecordPage;


public class CompleteDealerAccountSetupWorkflowTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CompleteDealerAccountSetupWorkflowTest instance;

	public static CompleteDealerAccountSetupWorkflowTest getInstance() {

		if (instance == null) {

			instance = new CompleteDealerAccountSetupWorkflowTest();

		}

		return instance;

	}

	private CompleteDealerAccountSetupWorkflowTest() {
			
			
			
	}
		
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactRecordPage contactRecordPage;
	private CommunityHomePage communityHomePage;
	private DealerAccountWorkflowPage dealerAccountWorkflowPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to complete the dealer account steup workflow
	 * @param dealer - (Dealer)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 * @throws Exception
	 */
	public boolean completeDealerAccountSetupWorkflow(Dealer dealer, Logger logger){

		//Prepare environment
		prepareEnvironment();
		
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
			
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
			
		logger.log("Searching and accessing into the Contact Record page");
		this.homePage.searchAndAccessIntoRecordPage(driver, "Contact", dealer.getContactName());
		
		logger.log("Login with dealer user into the John Deere Community");
		this.contactRecordPage.loginIntoCommunity();
		
		logger.log("Navigating into the John Deere Community");
		this.communityHomePage.navigateToJohnDeereCommunity(driver);
		
		logger.log("Starting to complete dealer account setup workflow");
		this.dealerAccountWorkflowPage.completeDealerAccountSetupWorkflow(driver);
		 
		logger.log("Enabling Dealer User MarketPlace");
		this.dealerAccountWorkflowPage.enableDealerUserMarketPlace(driver);
		
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
		this.dealerAccountWorkflowPage = PageFactory.initElements(driver, DealerAccountWorkflowPage.class);
		
	}
	
}