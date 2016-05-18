package com.johndeere.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.johndeere.pages.Page;

public class StaffPermissionTypePage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="p3")
	private WebElement cmbTy;
	
	@FindBy(how=How.XPATH, using=".//*[@id='bottomButtonRow']/input[1]")
	private WebElement btnContinue;
	
	@FindBy(how=How.NAME, using="btnCancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to select the staff permission type
	 * @param staffPermissionType - (String)
	 */
	public void selectStaffPermissionType(String staffPermissionType){
			
		Select cmbStaffPermissionType = new Select(cmbTy);
		cmbStaffPermissionType.selectByVisibleText(staffPermissionType);
		this.btnContinue.click();
				
	}
	
}