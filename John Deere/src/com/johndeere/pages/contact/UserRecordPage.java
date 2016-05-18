package com.johndeere.pages.contact;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class UserRecordPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------	
	@FindBy(how=How.NAME, using="resetPW")
	private WebElement btnResetPassword;
		
	@FindBy(how=How.NAME, using="editPermSetAssignments")
	private WebElement btnEditAssignments;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Method to navigate into the Permission Set Assignments Page
	 */
	public void navigateToSetPermissionAssignmentsPage(){
		
		this.btnEditAssignments.click();
		
	}
	
	/**
	 * Method to reset user password
	 * @param - (driver) WebDriver
	 */
	public void resetPassword(WebDriver driver){
		
		this.btnResetPassword.click();
		Alert enableAsPartnerAlert = driver.switchTo().alert();
		enableAsPartnerAlert.accept();
		
	}
	
}