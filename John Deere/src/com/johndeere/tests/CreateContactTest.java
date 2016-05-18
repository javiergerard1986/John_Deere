package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.Contact;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.contact.ContactRecordPage;
import com.johndeere.pages.contact.ContactTypePage;
import com.johndeere.pages.contact.ContactsPage;
import com.johndeere.pages.contact.CreateContactPage;
import com.johndeere.pages.contact.CreateUserContactPage;
import com.johndeere.pages.contact.PermissionSetAssignmentsPage;
import com.johndeere.pages.contact.UserRecordPage;


public class CreateContactTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateContactTest instance;

	public static CreateContactTest getInstance() {

		if (instance == null) {

			instance = new CreateContactTest();

		}

		return instance;

	}

	private CreateContactTest() {
			
			
			
	}
		
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private ContactsPage contactsPage;
	private ContactTypePage contactTypePage;
	private CreateContactPage createContactPage;
	private ContactRecordPage contactRecordPage;
	private CreateUserContactPage createUserContactPage;
	private UserRecordPage userRecordPage;
	private PermissionSetAssignmentsPage permissionSetAssignmentsPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create contacts
	 * @param contact - (Contact)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 * @throws Exception
	 */
	public boolean createContact(Contact contact, Logger logger){

		//Prepare environment
		prepareEnvironment();
		
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
			
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
			
		logger.log("Navigating to Contacts page");
		homePage.navigateToContactsPage(driver);
		
		logger.log("Accessing into the New Contact page");
		contactsPage.acessIntoCreateContact();
		
		logger.log("Selecting Contact Type");
		contactTypePage.selectContactType(contact.getContactType());
		
		logger.log("Creating contact");
		createContactPage.createContact(contact);
		
		logger.log("Enabling Contact as Partner or Customer");
		contactRecordPage.enableContactAsPartnerOrCustomer(contact.getPartnerType());
		
		logger.log("Creating user contact");
		this.createUserContactPage.createUser(contact);
		
		logger.log("Navigating into the Permission Set Assignments page");
		this.userRecordPage.navigateToSetPermissionAssignmentsPage();
		
		logger.log("Assigning CPQ Mark and CPQ User permissions");
		this.permissionSetAssignmentsPage.addPermissionsToUser(contact.getApptusCpqMarkPermission(), contact.getApttusCpqUserPermission(), contact.getApptusCpqMarkV1Permission());
		
		if(!this.checkResult("User Detail")){
			
			logger.log("Problem found when you were trying to add permissions to the user");
			return false;
			
		}
		
		logger.log("Reseting user contact password");
		this.userRecordPage.resetPassword(this.driver);
		
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
		this.contactsPage = PageFactory.initElements(driver, ContactsPage.class);
		this.contactTypePage = PageFactory.initElements(driver, ContactTypePage.class);
		this.createContactPage = PageFactory.initElements(driver, CreateContactPage.class);
		this.contactRecordPage = PageFactory.initElements(driver, ContactRecordPage.class);
		this.createUserContactPage = PageFactory.initElements(driver, CreateUserContactPage.class);
		this.userRecordPage = PageFactory.initElements(driver, UserRecordPage.class);
		this.permissionSetAssignmentsPage = PageFactory.initElements(driver, PermissionSetAssignmentsPage.class);
		
	}
	
}