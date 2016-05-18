package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.StaffPermission;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.account.StaffPermissionTypePage;
import com.johndeere.pages.contact.ContactRecordPage;
import com.johndeere.pages.contact.ContactStaffPermissionPage;


public class CreateStaffPermissionTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateStaffPermissionTest instance;

	public static CreateStaffPermissionTest getInstance() {

		if (instance == null) {

			instance = new CreateStaffPermissionTest();

		}

		return instance;

	}

	private CreateStaffPermissionTest() {
			
			
			
	}
		
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactRecordPage contactRecordPage;
	private StaffPermissionTypePage staffPermissionTypePage;
	private ContactStaffPermissionPage contactStaffPermission;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create staff permission
	 * @param staffPermission - (StaffPermission)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 * @throws Exception
	 */
	public boolean createStaffPermission(StaffPermission staffPermission, Logger logger){

		//Prepare environment
		prepareEnvironment();
		
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
			
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
			
		logger.log("Searching and accessing into the Contact Record page");
		this.homePage.searchAndAccessIntoRecordPage(driver, "Contact", staffPermission.getContactName());
		
		logger.log("Accesing into the New Staff Permission page");
		contactRecordPage.navigateToStaffPermissionPage();
		
		logger.log("Selecting Staff Permission Type");
		staffPermissionTypePage.selectStaffPermissionType(staffPermission.getPermissionType());
		
		logger.log("Creating Staff Permission");
		contactStaffPermission.createStaffPermission(staffPermission.getPermissionOnAccount(), staffPermission.getContactName(), staffPermission.getRole());
		
		logger.log("Returning to Contact Record page");
		contactStaffPermission.returnToContactRectordPage(staffPermission.getContactName(), driver);
		
		logger.log("Checking test result");
		if(!this.checkResult("Contact Detail")){
			
			logger.log("Problem found when you were traying to add Staff Permission to the contact");
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
		this.contactRecordPage = PageFactory.initElements(driver, ContactRecordPage.class);
		this.staffPermissionTypePage = PageFactory.initElements(driver, StaffPermissionTypePage.class);
		this.contactStaffPermission = PageFactory.initElements(driver, ContactStaffPermissionPage.class);
		
	}
	
}