package com.johndeere.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class ContactRecordPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="workWithPortalLabel")
	private WebElement btnManageExternalUser;
	
	@FindBy(how=How.LINK_TEXT, using="Enable Partner User")
	private WebElement lnkEnablePartnerUser;
	
	@FindBy(how=How.LINK_TEXT, using="Log in to Community as User")
	private WebElement lnkLoginUserToCommunity;
	
	@FindBy(how=How.LINK_TEXT, using="Enable Customer User")
	private WebElement lnkEnableCustomerUser;
		
	@FindBy(how=How.NAME, using="new00N7A000000G12N")
	private WebElement btnNewStaffPermission;
	
		
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Method to enable contact as partner or customer
	 * @param partnerType - (String) Partner Type
	 */
	public void enableContactAsPartnerOrCustomer(String partnerType){
		
		logger.log("Clicking on Manager External User button");
		this.btnManageExternalUser.click();
		
		if(partnerType.equals("Partner")){
			
			logger.log("Clicking on Enable Partner user option");
			this.lnkEnablePartnerUser.click();
			
		}else{
			
			logger.log("Clicking on Enable Customer user option");
			this.lnkEnableCustomerUser.click();
			
		}
		
	}
	
	/**
	 * Function to navigate to the Add New Staff Permission page
	 */
	public void navigateToStaffPermissionPage(){
		
		this.btnNewStaffPermission.click();
		
	}
	
	/**
	 * Function to login into the Community
	 */
	public void loginIntoCommunity(){
		
		logger.log("Clicking on the Manage Eternal User button");
		this.btnManageExternalUser.click();
		
		logger.log("Clicking on the Log in to Community as User option");
		this.lnkLoginUserToCommunity.click();
		
	}
	
}