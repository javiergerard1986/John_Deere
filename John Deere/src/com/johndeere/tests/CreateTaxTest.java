package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.Tax;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.account.AccountRecordPage;
import com.johndeere.pages.account.CreateTaxPage;


public class CreateTaxTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateTaxTest instance;

		public static CreateTaxTest getInstance() {

			if (instance == null) {

				instance = new CreateTaxTest();

			}

			return instance;

		}

	private CreateTaxTest() {
		
		
		
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountRecordPage accountRecordPage;
	private CreateTaxPage createTaxPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create taxes
	 * @param tax - (Tax)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 */
	public boolean createTax(Tax tax, Logger logger){
			
		//Prepare environment
		this.prepareEnvironment();
				
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
				
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
					
		logger.log("Accessing into the Account record page");
		homePage.searchAndAccessIntoRecordPage(driver, "Account", tax.getDealerAccount());
		
		logger.log("Accessing into the Create Tax page");
		accountRecordPage.navigateToNewTaxPage();
		
		logger.log("Creating tax");
		createTaxPage.createTax(tax);
		
		if(this.checkResult("Error: No matches found.")){
			
			logger.log("Problem: the state/region that you are providing is invalid. Please check your data and contact the BA");
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
		this.accountRecordPage = PageFactory.initElements(driver, AccountRecordPage.class);
		this.createTaxPage = PageFactory.initElements(driver, CreateTaxPage.class);
		
	}

}