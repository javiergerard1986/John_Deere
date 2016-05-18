package com.johndeere.tests;

import org.openqa.selenium.support.PageFactory;
import com.johndeere.constants.Constants;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.UserToGroup;
import com.johndeere.pages.GroupManagerPage;
import com.johndeere.pages.HomePage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.SetupPage;
import com.johndeere.pages.group.CreateGroupPage;
import com.johndeere.pages.group.GroupRecordPage;
import com.johndeere.pages.group.GroupsPage;

public class CreateUserToGroupTest extends GeneralTest{
	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateUserToGroupTest instance;

		public static CreateUserToGroupTest getInstance() {

			if (instance == null) {

				instance = new CreateUserToGroupTest();

			}

			return instance;

		}

	private CreateUserToGroupTest() {
		
		
		
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private LoginPage loginPage;
	private HomePage homePage;
	private SetupPage setupPage;
	private GroupsPage groupsPage;
	private GroupRecordPage groupRecordPage;
	private CreateGroupPage createGroupPage;
	private GroupManagerPage groupManagerPage;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create groups
	 * @param userToGroup - (UserToGroup) this object contain an user and a group, the user will be added into the group
	 * @param logger - (Logger)
	 * @return boolean - If creation is success return true, else return false
	 */
	public boolean createUserToGroup(UserToGroup userToGroup, Logger logger){
			
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
		
		logger.log("Searching group in page to navigate into the group page");
		groupsPage.searchAndClickInGroup(userToGroup.getGroupName(), driver);
		
		logger.log("Navigating into the Create / Edit Group Page");
		groupRecordPage.navigateToCreateEditGroupPage();
		
		logger.log("Adding user into the group");
		createGroupPage.addUsers(userToGroup.getUser());
		
		logger.log("Saving Group");
		createGroupPage.saveGroup();
		
		if(this.checkResult("Group Information")){
			
			logger.log("Error: Something happening when you were trying to add an user into the group. Please debug it");
			return false;
			
		}
		
		logger.log("Navigating into Group Manager page");
		homePage.navigateToSynchronizeGroupPage(driver);
		
		logger.log("Synchronizing Group");
		groupManagerPage.synchronizeGroup(userToGroup.getGroupName());
		
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
		this.groupRecordPage = PageFactory.initElements(driver, GroupRecordPage.class);
		this.createGroupPage = PageFactory.initElements(driver, CreateGroupPage.class);
		this.groupManagerPage = PageFactory.initElements(driver, GroupManagerPage.class);
		
	}

}