package com.johndeere.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.johndeere.pages.Page;

public class PermissionSetAssignmentsPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="j_id0:j_id2:j_id3:permSetAssignSection:pages:duelingListBox:backingList_a")
	private WebElement cmbAvailablePe;
	
	@FindBy(how=How.ID, using="j_id0:j_id2:j_id3:permSetAssignSection:pages:duelingListBox:add")
	private WebElement btnAddPermission;	
	
	@FindBy(how=How.NAME, using="j_id0:j_id2:j_id3:j_id19:save")
	private WebElement btnSave;
	
	@FindBy(how=How.NAME, using="j_id0:j_id2:j_id3:j_id19:bottom:cancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Method to add permissions to an user
	 * @param - (cpqMarkPermission) boolean
	 * @param - (cpqUserPermission) boolean
	 */
	public void addPermissionsToUser(boolean apttusCpqMarkPermission, boolean apttusCpqUserPermission, boolean apttusCpqMarkV1Permission){
		
		Select cmbAvailablePermissions = new Select(this.cmbAvailablePe);
		
		if(apttusCpqMarkPermission){
			
			this.logger.log("Selecting Apptus CPQ Marketplace permission to contact");
			cmbAvailablePermissions.selectByVisibleText("Apttus CPQ Marketplace");
			
			this.logger.log("Clicking on Add permission button");
			this.btnAddPermission.click();
			
		}
		
		
		if(apttusCpqUserPermission){
			
			this.logger.log("Selecting Apptus CPQ User permission to contact");
			cmbAvailablePermissions.selectByVisibleText("Apttus CPQ User");
			
			this.logger.log("Clicking on Add permission button");
			this.btnAddPermission.click();
			
		}
		
		if(apttusCpqMarkV1Permission){
			
			this.logger.log("Selecting Apptus CPQ Marketplace V1 permission to contact");
			cmbAvailablePermissions.selectByVisibleText("Apttus CPQ Marketplace 11/20/15");
			this.logger.log("Clicking on Add permission button");
			this.btnAddPermission.click();
			
		}
		
		this.logger.log("Clicking on Save button");
		this.btnSave.click();
		
	}
	
}