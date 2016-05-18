package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.Group;
import com.johndeere.pages.GroupManagerPage;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.SetupPage;
import com.johndeere.pages.group.CreateGroupPage;
import com.johndeere.pages.group.GroupsPage;

public class CreateGroupTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateGroupTest instance;

		public static CreateGroupTest getInstance() {

			if (instance == null) {

				instance = new CreateGroupTest();

			}

			return instance;

		}

	private CreateGroupTest() {
		
		
		
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private SetupPage setupPage;
	private GroupsPage groupsPage;
	private CreateGroupPage createGroupPage;
	private GroupManagerPage groupManagerPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create groups
	 * @param group - (Group)
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 */
	public boolean createGroup(Group group, Logger logger){
			
		//Prepare environment
		this.prepareEnvironment();
				
		logger.log("Accessing into Salesforce application");
		driver.get(Constants.SF_BACKEND_URL);
				
		logger.log("Login into the Salesforce application");
		loginPage.login(Constants.QA_SYSTEM_ADMIN_USERNAME, Constants.QA_SYSTEM_ADMIN_PASSWORD);
					
		logger.log("Accessing into Setup page");
		homePage.navigateToSetupPage();
		
		logger.log("Navigating to Setup page");
		setupPage.navigateToGroupsPage();
		
		logger.log("Navigating to Create Group page");
		groupsPage.navigateToCreateGroupPage();
		
		logger.log("Creating Group");
		createGroupPage.createGroup(group);
		
		if(this.checkResult("Error: This Group Name already exists or has been previously used. Please choose a different name.")){
			
			logger.log("Error: This Group Name already exists or has been previously used. Please choose a different name.");
			return false;
			
		}
		
		logger.log("Navigating into Group Manager page");
		homePage.navigateToSynchronizeGroupPage(driver);
		
		logger.log("Synchronizing Group");
		groupManagerPage.synchronizeGroup(group.getGroupLabel());
		
		if(!this.checkResult("Group Updated Successfully")){
			
			logger.log("Problem synchronizing the group");
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
		this.setupPage = PageFactory.initElements(driver, SetupPage.class);
		this.groupsPage = PageFactory.initElements(driver, GroupsPage.class);
		this.createGroupPage = PageFactory.initElements(driver, CreateGroupPage.class);
		this.groupManagerPage = PageFactory.initElements(driver, GroupManagerPage.class);
		
	}

}