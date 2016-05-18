package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.GrowerDealerAssociation;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.account.AccountRecordPage;
import com.johndeere.pages.account.GrowerDealerAssociationPage;
import com.johndeere.pages.account.GrowerDealerAssociationTypePage;

public class CreateGrowerDealerAssociationTest extends GeneralTest{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateGrowerDealerAssociationTest instance;

	public static CreateGrowerDealerAssociationTest getInstance() {

		if (instance == null) {

			instance = new CreateGrowerDealerAssociationTest();

		}

		return instance;

	}

	private CreateGrowerDealerAssociationTest() {
			
			
			
	}


	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountRecordPage accountRecordPage;
	private GrowerDealerAssociationTypePage growerDealerAssociationTypePage;
	private GrowerDealerAssociationPage growerDealerAssociationPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create accounts
	 * @param gda - (GrowerDealerAssociation) this is the association to create between 2 accounts
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 */
	public boolean createGrowerDealerAssociation(GrowerDealerAssociation gda, Logger logger){
			
		//Prepare environment
		this.prepareEnvironment();
				
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
				
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
					
		logger.log("Searching and accessing into the Grower Record page");
		this.homePage.searchAndAccessIntoRecordPage(driver, "Account", gda.getGrowerAccountName());
		
		logger.log("Accessing into the Create Grower Dealer Association page");
		this.accountRecordPage.navigateToRelatedDealerAssociationPage();
		
		logger.log("Selecting Grower Dealer Association Type");
		this.growerDealerAssociationTypePage.selectGrowerDealerAssociationType(gda.getAssociationType());
		
		logger.log("Starting creation of Grower - Dealer Account association");
		this.growerDealerAssociationPage.createGrowerDealerAssociation(gda);
			
		if(this.checkResult("Error: Value does not exist or does not match filter criteria.")){
			
			logger.log("Error: You are trying to create a relationship providing a grower account that does not exist in the system");
			return false;
			
		}
		
		logger.log("Log out from system\n");
		homePage.logout();
	
		return true;
		
	}
	
	/**
	 * Function to initialize environments
	 */
	@Override
	public void prepareEnvironment() {
		
		this.Initialize();
		this.loginPage = PageFactory.initElements(driver, LoginPage.class);	
		this.homePage = PageFactory.initElements(driver, HomePage.class);
		this.accountRecordPage = PageFactory.initElements(driver, AccountRecordPage.class);
		this.growerDealerAssociationTypePage = PageFactory.initElements(driver, GrowerDealerAssociationTypePage.class);
		this.growerDealerAssociationPage = PageFactory.initElements(driver, GrowerDealerAssociationPage.class);
		
	}
	
}