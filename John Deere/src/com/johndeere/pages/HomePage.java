package com.johndeere.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="phSearchInput")
	private WebElement txtGlobalSearch;
	
	@FindBy(how=How.ID, using="phSearchButton")
	private WebElement btnGlobalSearch;
	
	@FindBy(how=How.ID, using="AllTab_Tab")
	private WebElement tabAllTabs;
	
	@FindBy(how=How.ID, using="Account_Tab")
	private WebElement tabAccount;

	@FindBy(how=How.ID, using="Contact_Tab")
	private WebElement tabContact;
	
	@FindBy(how=How.LINK_TEXT, using="Pre Offers")
	private WebElement tabPreOffer;
	
	@FindBy(how=How.LINK_TEXT, using="Group Manager")
	private WebElement tabGroupManager;
	
	@FindBy(how=How.ID, using="ext-gen1")
	private WebElement lnkAccountsNumber;
	
	@FindBy(how=How.ID, using="ext-gen9")
	private WebElement lnkContactNumber;
	
	@FindBy(how=How.ID, using="ext-gen29")
	private WebElement lnkPreOfferNumber;
	
	@FindBy(how=How.ID, using="globalHeaderNameMink")
	private WebElement lnkGlobalHeaderName;
	
	@FindBy(how=How.LINK_TEXT, using="Setup")
	private WebElement lnkSetup;
	
	@FindBy(how=How.LINK_TEXT, using="Logout")
	private WebElement lnkLogout;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to make a global search of a record and accessing into his record page
	 * @param record - (String) record to search and access into his page
	 */
	public void searchAndAccessIntoRecordPage(WebDriver driver, String object, String record){
		
		this.logger.log("Providing record to search");
		this.txtGlobalSearch.sendKeys(record);

		this.logger.log("Clicking on Search button");
		this.btnGlobalSearch.click();
		
		this.clickOnObjectFolder(object);
		
		this.logger.log("Clicking on searched record link");
		WebElement lnkRecord = driver.findElement(By.linkText(record));
		lnkRecord.click();
		
	}
	
	/**
	 * Function to define in which folder click
	 * @param object - (String) basing on this object the system will define in which folder click
	 */
	public void clickOnObjectFolder(String object){
	
		if(object.equals("Account")){
			
			this.logger.log("Clicking on Account link folder");
			this.lnkAccountsNumber.click();
			
		}
		
		if(object.equals("Contact")){
			
			this.logger.log("Clicking on Contact link folder");
			this.lnkContactNumber.click();
			
		}
		
		if(object.equals("PreOffer")){
			
			this.logger.log("Clicking on Pre Offer link folder");
			this.lnkPreOfferNumber.click();
			
		}
		
	}
	
	/**
	 * Function to access into the "Accounts" page 
	 * @param - (driver) WebDriver
	 */
	public void navigateToAccountsPage (WebDriver driver){
		
		if(!this.isElementInPage("Accounts", driver)){
			
			this.tabAllTabs.click();
			
		}
		
		this.tabAccount.click();
		
	}
	
	/**
	 * Function to navigate to "Contacts" page
	 * @param - (driver) WebDriver
	 */
	public void navigateToContactsPage(WebDriver driver){
		
		if(!this.isElementInPage("Contacts", driver)){
			
			this.tabAllTabs.click();
			
		}
		
		this.tabContact.click();
		
	}
	
	/**
	 * Function to navigate to "Pre Offers" page
	 * @param - (driver) WebDriver
	 */
	public void navigateToPreOffersPage(WebDriver driver){
		
		if(!this.isElementInPage("Pre Offers", driver)){
			
			this.tabAllTabs.click();
			
		}
		
		this.tabPreOffer.click();
		
	}
	
	/**
	 * Function to navigate to the Synchronize Group page
	 * @param - (driver) WebDriver
	 */
	public void navigateToSynchronizeGroupPage(WebDriver driver){
		
		if(!this.isElementInPage("Group Manager", driver)){
		
			this.tabAllTabs.click();
			
		}

		this.logger.log("Clicking on Group Manager tab");
		this.tabGroupManager.click();
		
	}
	
	/**
	 * Navigate to Setup page
	 */
	public void navigateToSetupPage(){
		
		this.logger.log("Clicking on User link");
		this.lnkGlobalHeaderName.click();
		
		this.logger.log("Clicking on Setup link");
		this.lnkSetup.click();
		
	}
	
	/**
	 * Function to logout from system
	 */
	public void logout(){
		
		this.lnkGlobalHeaderName.click();
		this.lnkLogout.click();
		
	}
	
}