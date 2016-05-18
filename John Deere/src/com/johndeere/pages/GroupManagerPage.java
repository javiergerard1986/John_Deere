package com.johndeere.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class GroupManagerPage extends Page {

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="j_id0:j_id2:publicgroups")
	private WebElement cmbGr;
	
	@FindBy(how=How.NAME, using="j_id0:j_id2:j_id37")
	private WebElement btnSync;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to synchronize a group
	 * @param groupName - (String) This is the group name to synchronize
	 */
	public void synchronizeGroup(String groupName){
	
		this.logger.log("Selecting Group");
		Select cmbGroup = new Select(cmbGr);
		cmbGroup.selectByVisibleText(groupName);
		
		this.logger.log("Clicking on the Synchronize button");
		this.btnSync.click();
		
	}
	
}