package com.johndeere.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SetupPage extends Page {

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.LINK_TEXT, using="Manage Users")
	private WebElement lnkManageUsers;
	
	@FindBy(how=How.LINK_TEXT, using="Public Groups")
	private WebElement lnkPublicGroups;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Navigate to Groups page
	 */
	public void navigateToGroupsPage(){
	
		this.logger.log("Clicking on Manage Users link");
		this.lnkManageUsers.click();
		
		this.logger.log("Clicking on Groups link");
		this.lnkPublicGroups.click();
		
	}
	
}