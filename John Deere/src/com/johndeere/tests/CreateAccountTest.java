package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.Account;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.account.AccountOwnerPage;
import com.johndeere.pages.account.AccountRecordPage;
import com.johndeere.pages.account.AccountTypePage;
import com.johndeere.pages.account.AccountsPage;
import com.johndeere.pages.account.CreateAccountPage;

public class CreateAccountTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateAccountTest instance;

		public static CreateAccountTest getInstance() {

			if (instance == null) {

				instance = new CreateAccountTest();

			}

			return instance;

		}

	private CreateAccountTest() {
		
		
		
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountsPage accountsPage;
	private AccountTypePage accountTypePage;
	private CreateAccountPage createAccountPage;
	private AccountRecordPage accountRecordPage;
	private AccountOwnerPage accountOwnerPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create accounts
	 * @param account - (Account)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 */
	public boolean createAccount(Account account, Logger logger){
			
		//Prepare environment
		this.prepareEnvironment();
				
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
				
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
					
		logger.log("Navigating into Accounts page");
		homePage.navigateToAccountsPage(driver);
				
		logger.log("Accessing into Create Account page");
		accountsPage.accessIntoNewAccountPage();
		
		logger.log("Selecting account type");
		this.accountTypePage.selectAccountType(account.getAccountType());
			
		logger.log("Creating account");
		this.createAccountPage.createAccount(account);
			
		logger.log("Navigating to the Account Owner Page");
		this.accountRecordPage.clickOnAccountOwnerLink();
		
		logger.log("Changing account owner");
		this.accountOwnerPage.changeAccountOwner(account.getAccountOwner());
		
		logger.log("Enabling account as a partner account");
		if(account.getEnableAsPartner()){
				
			this.accountRecordPage.enableAccountAsPartner(driver);
		
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
		this.accountsPage = PageFactory.initElements(driver, AccountsPage.class);
		this.accountTypePage = PageFactory.initElements(driver, AccountTypePage.class);
		this.createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
		this.accountRecordPage = PageFactory.initElements(driver, AccountRecordPage.class);
		this.accountOwnerPage = PageFactory.initElements(driver, AccountOwnerPage.class);
		
	}
	
}